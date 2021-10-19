package com.kodluyoruz.HW3.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "discount")
@Component
@Data
public class DiscountProperties {
    private double percentage;



}
