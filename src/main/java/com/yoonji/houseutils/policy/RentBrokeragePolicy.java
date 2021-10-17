package com.yoonji.houseutils.policy;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 임대일 때 중개 수수료를 계산해주는 클래스 */
@Getter
public class RentBrokeragePolicy implements BrokeragePolicy{

    /* BrokeragePolicy 에서 공통 로직으로 옮겼음
    public Long calculate(Long price){
        // TODO : 가격을 받아서 중개 수수료를 계산한다.
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price) ;
    }*/

/*    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price < 50_000_000){
            rule = new BrokerageRule(0.5, 250_000L);
        }else if(price < 100_000_000){
            rule = new BrokerageRule(0.4, 300_000L);
        }else if(price < 300_000_000){
            rule = new BrokerageRule(0.3, null); //상한 금액은 없음
        }else if(price < 600_000_000){
            rule = new BrokerageRule(0.4, null); //상한 금액은 없음
        }else {
            rule = new BrokerageRule(0.8, null); //상한 금액은 없음
        }
        return rule;
    }*/

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
