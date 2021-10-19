package com.kodluyoruz.HW3.paymentMethods;

import com.kodluyoruz.HW3.cartsAndBills.Bill;
import com.kodluyoruz.HW3.paymentMethods.enums.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class Cash implements PaymentMethods{


    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }

    @Override
    public void pay(Bill bill) {
        System.out.println("Payment completed" +
                "\nPayed: " + bill.getEveryThingsInHere()
                +"\nCommission price: 0"
        );

    }



}
