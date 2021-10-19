package com.kodluyoruz.HW3.paymentMethods;

import com.kodluyoruz.HW3.cartsAndBills.Bill;
import com.kodluyoruz.HW3.paymentMethods.enums.PaymentType;
import com.kodluyoruz.HW3.properties.PaymentProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCart implements PaymentMethods{
    private final PaymentProperties paymentProperties;


    @Override
    public PaymentType getType() {
        return PaymentType.CREDIT;
    }

    @Override
    public void pay(Bill bill) {
        double commissionPrice = bill.getEveryThingsInHere() * (paymentProperties.getCommission()/100);
        double Total = bill.getEveryThingsInHere() + commissionPrice;
        System.out.println("Payment completed"
                +"\nPayed: " + bill.getEveryThingsInHere()
                +"\nCommission price: " + commissionPrice
                +"\nTotal: " + Total
        );


    }
}
