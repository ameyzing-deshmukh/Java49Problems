package org.problems.designpatterns.observer;

import org.junit.jupiter.api.Test;

public class ObserverPatternTest {

    @Test
    public void testObserverPattern() {
        Stock stock = new Stock("Apple", 155.0);

        Investor amey = new ConcreteInvestor("Amey");
        Investor vijay = new ConcreteInvestor("Vijay");
        Investor rajesh = new ConcreteInvestor("Rajesh");

        stock.subscribeToStock(amey);
        stock.subscribeToStock(vijay);
        stock.subscribeToStock(rajesh);

        stock.setCurrentValue(160.0);

        stock.unsubscribeToStock(vijay);

        stock.setCurrentValue(170.0);

        stock.subscribeToStock(vijay);
        stock.subscribeToStock(vijay);

        stock.setCurrentValue(170.1);
    }
}
