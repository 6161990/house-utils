package com.yoonji.houseUtils.policy;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 매매일 때, 중계 수수료를 계산한다.
 * */
@Getter
public class PurchaseBrokeragePolicy implements BrokeragePolicy{

    private final List<BrokerageRule> rules;

    public PurchaseBrokeragePolicy() {
        rules = Arrays.asList(
                new BrokerageRule(50_000_000L, 0.6, 250_000L),
                new BrokerageRule(200_000_000L, 0.5, 800_000L),
                new BrokerageRule(600_000_000L, 0.4, null),
                new BrokerageRule(900_000_000L, 0.5, null),
                new BrokerageRule(Long.MAX_VALUE,0.9, null)
        );
    }

}
