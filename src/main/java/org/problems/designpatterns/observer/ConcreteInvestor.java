package org.problems.designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteInvestor implements Investor {
    private String investorName;
    private static final Logger log = LoggerFactory.getLogger(ConcreteInvestor.class);

    public ConcreteInvestor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(String stockName, Double newValue) {
        log.info("Investor {} is updated that price for stock {} is changed to {}.", investorName, stockName, newValue);
    }
}
