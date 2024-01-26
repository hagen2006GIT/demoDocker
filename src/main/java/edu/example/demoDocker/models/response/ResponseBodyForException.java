package edu.example.demoDocker.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.core.annotation.Order;

@Data
@AllArgsConstructor
@ToString
public class ResponseBodyForException {
    @Order(value = 1) String defaultMessage;
    @Order(value = 2) String ExceptionText;
    @Order(value = 3) StackTraceElement[] stack;
}
