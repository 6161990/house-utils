package com.yoonji.houseUtils.policy;

import com.yoonji.houseUtils.exception.ErrorCode;
import com.yoonji.houseUtils.exception.HouseUtilsException;

import java.util.List;

public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price){
        BrokerageRule brokerageRule = getRules().stream().filter(rule -> price < rule.getLessThan())
                .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERVAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }

}
