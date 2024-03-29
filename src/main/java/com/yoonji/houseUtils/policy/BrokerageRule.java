package com.yoonji.houseUtils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * 가격이 특정 범위일 때, 상한효율과 상한금액을 가지고 중계 수수료를 계산한다.
 */
@AllArgsConstructor
public class BrokerageRule {

    @Getter
    private Long lessThan;
    private Double brokeragePercent;
    private Long limitPrice;

    public BrokerageRule(Long lessThan, Double brokeragePercent) {
        this(lessThan, brokeragePercent, Long.MAX_VALUE);
    }

    public Long calcMaxBrokerage(Long price) {
        return Math.min(multiplyPercent(price) , limitPrice);
    }

    private long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }

}
