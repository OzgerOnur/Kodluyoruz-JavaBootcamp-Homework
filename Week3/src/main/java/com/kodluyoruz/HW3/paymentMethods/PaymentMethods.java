package com.kodluyoruz.HW3.paymentMethods;

import com.kodluyoruz.HW3.cartsAndBills.Bill;
import com.kodluyoruz.HW3.paymentMethods.enums.PaymentType;

public interface PaymentMethods {

   PaymentType getType();
   void pay(Bill bill);

}
