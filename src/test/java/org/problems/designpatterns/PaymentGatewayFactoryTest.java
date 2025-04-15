package org.problems.designpatterns;

import org.junit.jupiter.api.Test;
import org.problems.designpatterns.factory.PaymentGateway;
import org.problems.designpatterns.factory.PaymentGatewayFactory;
import org.problems.designpatterns.factory.PaypalGateway;
import org.problems.designpatterns.factory.RazorPayGateway;

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