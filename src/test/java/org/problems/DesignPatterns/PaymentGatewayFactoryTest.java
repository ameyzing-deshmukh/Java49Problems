package org.problems.DesignPatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentGatewayFactoryTest {

    @Test
    void getPaymentGateway() {
        PaymentGateway paypal = PaymentGatewayFactory.getPaymentGateway("paypal");
        PaymentGateway razorPay = PaymentGatewayFactory.getPaymentGateway("razorpay");

        assertInstanceOf(PaypalGateway.class, paypal);
        assertInstanceOf(RazorPayGateway.class, razorPay);

        try {
            PaymentGatewayFactory.getPaymentGateway("gibrish");
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid payment gateway: gibrish", ex.getMessage());
        }

        paypal.processPayment(2000.90);
        razorPay.processPayment(3000.2);
    }
}