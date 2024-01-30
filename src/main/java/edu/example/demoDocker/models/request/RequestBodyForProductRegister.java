package edu.example.demoDocker.models.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@ToString()
@Getter @Setter
@Validated
public class RequestBodyForProductRegister {
    @NotNull Long instanceId; // Идентификатор экземпляра продукта (обязательный атрибут)
    String registryTypeCode; // Тип регистра
    String accountType; //Тип счета
    String currencyCode; // Код валюты
    @NotNull String branchCode; //Код филиала
    String priorityCode; // Код срочности
    String mdmCode; // ID клиента
    String clientCode; // Код клиента
    String trainRegion; // Регион принадлежности железной дороги
    String counter; //Счетчик
    String salesCode; // Код точки продаж
}
