package com.yoonji.houseUtils.controller;

import com.yoonji.houseUtils.constants.ActionType;
import com.yoonji.houseUtils.policy.PurchaseBrokeragePolicy;
import com.yoonji.houseUtils.policy.RentBrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {
    @GetMapping("/api/calc/brokerage")
    public Long calcPrice(@RequestParam ActionType actionType,
                          @RequestParam Long price){
        // 중개 수수료를 계산하는 로직
        if(actionType == ActionType.PURCHASE){
            PurchaseBrokeragePolicy policy = new PurchaseBrokeragePolicy();
            return policy.calculate(price);
        }
        if(actionType == ActionType.RENT){
            RentBrokeragePolicy policy = new RentBrokeragePolicy();
            return policy.calculate(price);
        }
        return null;
    }
}
