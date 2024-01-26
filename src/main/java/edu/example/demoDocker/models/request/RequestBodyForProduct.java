package edu.example.demoDocker.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import java.util.Date;

@ToString(includeFieldNames=true)
@Getter
@Setter
@Validated
public class RequestBodyForProduct {
    Long instanceId; // Идентификатор экземпляра продукта
    String productType; // Тип Экземпляра Продукта (ЭП)
    @NotNull String productCode; // Код продукта в каталоге продуктов
    @NotNull String registerType; // Тип регистра
    @NotNull String mdmCode; // Код Клиента (mdm)
    @NotNull String contractNumber; // Номер договора
    @NotNull Date contractDate; // Дата заключения договора обслуживания
    @NotNull Integer priority; // Приоритет
    float interestRatePenalty; // Штрафная процентная ставка
    float minimalBalance; // Неснижаемый остаток
    float thresholdAmount; // Пороговая сумма
    String accountingDetails; // Реквизиты выплаты
    String rateType; // Выбор ставки в зависимости от суммы
    float taxPercentageRate; // Ставка налогообложения
    float technicalOverdraftLimitAmount; // Сумма лимита технического овердрафта
    @NotNull Integer contractId; // ID Договора
    @NotNull String BranchCode; // Код филиала (внутренний код - не БИК)
    @NotNull String IsoCurrencyCode; // Код валюты
    @NotNull String urgencyCode; // Код срочности договора (всегда "00")
    @NotNull String byCentralBankType; // Тип Клиента по ЦБ
    int ReferenceCode; // Код точки продаж
    Properties[] additionalPropertiesVip; // массив дополнительных признаков для сегмента КИБ(VIP)
    InstanceArrangement[] instanceArrangements; // массив Доп.соглашений
}

@Setter @Getter class Properties {
    String key;
    String value;
    String name;
}

@Setter @Getter class InstanceArrangement {
    String GeneralAgreementId; // ID доп.Ген.соглашения
    String SupplementaryAgreementId; // ID доп.соглашения
    String arrangementTypel; // Тип соглашения
    int	shedulerJobId; // Идентификатор периодичности учета
    @NotNull String Number; // Номер ДС
    @NotNull Date openingDate; // Дата начала сделки
    Date closingDate; // Дата окончания сделки
    Date CancelDate; // Дата отзыва сделки
    int	validityDuration; // Срок действия сделки
    String cancellationReason; // Причина расторжения
    String Status; // Состояние/статус
    Date interestCalculationDate; // Начисление начинается с (дата)
    float interestRate; // Процент начисления на остаток
    float coefficient; // Коэффициент
    String coefficientAction; // Действие коэффициента
}
