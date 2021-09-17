package com.yoonji.houseutils.policy;

/**
 * 매매일 때 중개 수수료를 계산해주는 클래스 */
public class PurchaseBrokeragePolicy implements BrokeragePolicy{

    /* BrokeragePolicy 에서 공통 로직으로 옮겼음
    public Long calculate(Long price){
        // TODO : 가격을 받아서 중개 수수료를 계산한다.
        BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price) ;
    }*/

    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if(price < 50_000_000){
            rule = new BrokerageRule(0.6, 250_000L);
        }else if(price < 200_000_000){
            rule = new BrokerageRule(0.5, 800_000L);
        }else if(price < 600_000_000){
            rule = new BrokerageRule(0.4, null); //상한 금액은 없음
        }else if(price < 900_000_000){
            rule = new BrokerageRule(0.5, null); //상한 금액은 없음
        }else {
            rule = new BrokerageRule(0.9, null); //상한 금액은 없음
        }
        return rule;
    }
}
