package com.yoonji.houseUtils.policy;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 임대일 때, 중계 수수료를 계산한다.
 * */
@Getter
public class RentBrokeragePolicy implements BrokeragePolicy{
    private final List<BrokerageRule> rules;

    public RentBrokeragePolicy (){
        rules = Arrays.asList(
                new BrokerageRule(50_000_000L, 0.5, 200_000L),
                new BrokerageRule(100_000_000L, 0.4, 300_000L),
                new BrokerageRule(300_000_000L, 0.3),
                new BrokerageRule(600_000_000L, 0.4),
                new BrokerageRule(Long.MAX_VALUE, 0.8)
        );
    }
}
