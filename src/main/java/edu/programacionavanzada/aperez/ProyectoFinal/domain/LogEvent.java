package edu.programacionavanzada.aperez.ProyectoFinal.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@KeySpace("logEvents")
public class LogEvent implements Serializable {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();

    private String classOwner;

    private UUID processId;

    private String process;

    private Map<String, Object> parameterMap;
}