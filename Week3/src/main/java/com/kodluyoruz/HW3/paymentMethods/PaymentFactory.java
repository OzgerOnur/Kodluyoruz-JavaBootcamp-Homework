package com.kodluyoruz.HW3.paymentMethods;

import com.kodluyoruz.HW3.paymentMethods.enums.PaymentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentFactory {
    private final Map<PaymentType,PaymentMethods> paymentMap;

    public PaymentFactory(List<PaymentMethods> paymentList) {
        this.paymentMap = paymentList.stream()
                .collect(Collectors.toMap(PaymentMethods::getType, pm->pm));

    }

    public PaymentMethods getPaymentMethod(PaymentType type){
        return paymentMap.get(type);
    }


}
