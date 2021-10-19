package com.kodluyoruz.HW3.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "delivery-fee")
@Component
@Data
public class DeliveryFeeProperties {
    private double deliveryFee;
    private double deliveryFeeLimit;



}
