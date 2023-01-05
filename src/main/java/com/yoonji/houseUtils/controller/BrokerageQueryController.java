package com.yoonji.houseUtils.controller;

import com.yoonji.houseUtils.constants.ActionType;
import com.yoonji.houseUtils.policy.BrokeragePolicy;
import com.yoonji.houseUtils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 중계수수료 조회 컨트롤러
 * */
@RestController
public class BrokerageQueryController {
    @GetMapping("/api/calc/brokerage")
    public Long calcPrice(@RequestParam ActionType actionType,
                          @RequestParam Long price){
        BrokeragePolicy brokeragePolicy = BrokeragePolicyFactory.of(actionType);
        return brokeragePolicy.calculate(price);
    }
}
