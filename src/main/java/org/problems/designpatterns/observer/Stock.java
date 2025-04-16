package org.problems.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    public Stock(String name, Double currentValue) {
        this.name = name;
        this.currentValue = currentValue;
    }

    private String name;
    private Double currentValue;
    private List<Investor> investorList = new ArrayList<>();

    public void subscribeToStock(Investor investor) {
        if (!investorList.contains(investor))
            investorList.add(investor);
    }

    public void unsubscribeToStock(Investor investor) {
        investorList.remove(investor);
    }

    public void setCurrentValue(Double newValue) {
        if (!this.currentValue.equals(newValue)) {
            this.currentValue = newValue;
            for (Investor investor : investorList) {
                investor.update(this.name, this.currentValue);
            }
        }
    }
}
