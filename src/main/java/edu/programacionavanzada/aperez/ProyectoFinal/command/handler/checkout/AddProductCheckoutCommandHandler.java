package edu.programacionavanzada.aperez.ProyectoFinal.command.handler.checkout;

import edu.programacionavanzada.aperez.ProyectoFinal.command.checkout.AddProductCheckoutCommand;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.CheckoutProduct;
import edu.programacionavanzada.aperez.ProyectoFinal.domain.Product;
import edu.programacionavanzada.aperez.ProyectoFinal.model.response.checkout.CheckoutAddProductResponse;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.aperez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutProductRepository;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.CheckoutRepository;
import edu.programacionavanzada.aperez.ProyectoFinal.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@CommandEvent(command = AddProductCheckoutCommand.class)
@Slf4j
public class AddProductCheckoutCommandHandler implements CommandHandler<CheckoutAddProductResponse, AddProductCheckoutCommand> {

    private final CheckoutRepository checkoutRepository;
    private final ProductRepository productRepository;
    private final CheckoutProductRepository checkoutProductRepository;

    @Override
    public CheckoutAddProductResponse handle(AddProductCheckoutCommand addProductCheckoutCommand) {
        log.debug("Add producto to Checkout {}", addProductCheckoutCommand.toString());
        Checkout checkout = checkoutRepository.findById(addProductCheckoutCommand.getId()).orElseThrow();
        Product product = productRepository.findById(addProductCheckoutCommand.getProduct()).orElseThrow();
        if (addProductCheckoutCommand.getQuantity() > product.getAvailableQuantity()) {
            throw new RuntimeException("Available product if less than you need");
        }
        List<CheckoutProduct> productsToBuy = checkout.getProductsToBuy();
        if (productsToBuy == null) {
            productsToBuy = new ArrayList<>();
        }
        CheckoutProduct checkoutProduct = findProductInCheckout(productsToBuy, product.getId());
        if (checkoutProduct == null) {
            checkoutProduct = CheckoutProduct.builder()
                    .product(product)
                    .quantity(addProductCheckoutCommand.getQuantity())
                    .build();
            checkoutProductRepository.save(checkoutProduct);
            productsToBuy.add(checkoutProduct);
        } else {
            checkoutProduct.setQuantity(checkoutProduct.getQuantity() + addProductCheckoutCommand.getQuantity());
            checkoutProductRepository.save(checkoutProduct);
        }
        product.setAvailableQuantity(product.getAvailableQuantity() - addProductCheckoutCommand.getQuantity());
        productRepository.save(product);
        checkout.setProductsToBuy(productsToBuy);
        checkoutRepository.save(checkout);
        return CheckoutAddProductResponse.builder()
                .checkout(checkout.toDTO())
                .build();
    }

    private CheckoutProduct findProductInCheckout(List<CheckoutProduct> productsToBuy, Long productId) {
        for (CheckoutProduct checkoutProduct : productsToBuy) {
            if (checkoutProduct.getProduct().getId().equals(productId)) {
                return checkoutProduct;
            }
        }
        return null;
    }
}