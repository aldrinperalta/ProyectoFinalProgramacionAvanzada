package edu.programacionavanzada.aperez.ProyectoFinal.domain;

import edu.programacionavanzada.aperez.ProyectoFinal.model.dto.CheckoutDTO;
import edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions.CheckoutAddressNoAssignedException;
import edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions.CheckoutPaymentMethodNoAssignedException;
import edu.programacionavanzada.aperez.ProyectoFinal.model.exceptions.PayCheckoutWithoutProductsException;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "checkouts")
public class Checkout {

    @Id
    private UUID id;

    @OneToOne
    private Address address;

    @OneToOne
    private PaymentMethod paymentMethod;

    @OneToMany
    private List<CheckoutProduct> productsToBuy;

    public CheckoutDTO toDTO() {
        return CheckoutDTO.builder()
                .id(id)
                .address(address == null ? null : address.toDTO())
                .paymentMethod(paymentMethod == null ? null : paymentMethod.toDTO())
                .productsToBuy(productsToBuy == null ? new ArrayList<>() : productsToBuy.stream().map(CheckoutProduct::toDTO).collect(Collectors.toList()))
                .build();
    }

    public Order toOrder() {
        if (address == null) {
            throw new CheckoutAddressNoAssignedException(id);
        }
        if (paymentMethod != null) {
            throw new CheckoutPaymentMethodNoAssignedException(id);
        }
        if (productsToBuy.isEmpty()) {
            throw new PayCheckoutWithoutProductsException(id);
        }
        BigDecimal total = new BigDecimal(0);
        for (CheckoutProduct checkoutProduct : productsToBuy) {
            total = total.add(checkoutProduct.getProduct().getPrice().multiply(new BigDecimal(checkoutProduct.getQuantity())));
        }
        return Order.builder()
                .address(address)
                .paymentMethod(paymentMethod)
                .productsToBuy(productsToBuy)
                .total(total)
                .buyDateTime(LocalDateTime.now())
                .build();
    }

}