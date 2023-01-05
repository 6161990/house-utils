package com.yoonji.houseUtils.policy;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * 가격이 특정 범위일 때, 상한효율과 상한금액을 가지고 중계 수수료를 계산한다.
 */
@AllArgsConstructor
public class BrokerageRule {
    private Double brokeragePercent;

    @Nullable
    private Long limitPrice;

    public Long calcMaxBrokerage(Long price) {
        if (limitPrice == null) {
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price) , limitPrice);
    }

    private long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }

}
