package org.problems.designpatterns.factory;

public class PaymentGatewayFactory {
    public static PaymentGateway getPaymentGateway(String name) {
        switch (name) {
            case "paypal" -> {
                return new PaypalGateway();
            }
            case "razorpay" -> {
                return new RazorPayGateway();
            }
            default -> throw new IllegalArgumentException("Invalid payment gateway: " + name);
        }
    }
}
