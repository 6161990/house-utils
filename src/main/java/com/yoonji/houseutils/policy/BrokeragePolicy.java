package com.yoonji.houseutils.policy;

import com.yoonji.houseutils.exception.ErrorCode;
import com.yoonji.houseutils.exception.HouseUtilsException;

import java.util.List;

/**
 * 중개 수수료 정책 인터페이스
 */
public interface BrokeragePolicy {

   // BrokerageRule createBrokerageRule(Long price);
    List<BrokerageRule> getRules();

    default Long calculate(Long price){
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThan())
                .findFirst().orElseThrow(()-> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        /*BrokerageRule rule = createBrokerageRule(price);
        return rule.calcMaxBrokerage(price);*/
        return brokerageRule.calcMaxBrokerage(price);
    }

}
