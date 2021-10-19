package com.kodluyoruz.HW3.properties;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "payment-properties")
@Component
@Data
public class PaymentProperties {
    private double commission;

}
