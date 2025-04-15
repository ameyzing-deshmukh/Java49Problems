package org.problems.designpatterns.factory;

public class RazorPayGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment via RazorPay for amount: " + amount);
    }
}
