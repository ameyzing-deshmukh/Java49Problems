package org.problems.DesignPatterns;

public class PaypalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via Paypal for amount: " + amount);
    }
}
