package com.yoonji.houseUtils.policy;

public interface BrokeragePolicy {
    BrokerageRule createBrokerageRule(Long price);
    default public Long calculate(Long price){
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);
    }

}
