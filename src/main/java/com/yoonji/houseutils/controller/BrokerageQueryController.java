package com.yoonji.houseutils.controller;

import com.yoonji.houseutils.constants.ActionType;
import com.yoonji.houseutils.policy.BrokeragePolicy;
import com.yoonji.houseutils.policy.BrokeragePolicyFactory;
import com.yoonji.houseutils.policy.PurchaseBrokeragePolicy;
import com.yoonji.houseutils.policy.RentBrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 중개 수수료가 얼만지 질의하는 컨트롤러 */

@RestController
public class BrokerageQueryController {

    //매매인지 임대인지에 따라 수수료가 달라지므로, 그 타입을 인자로 받는다
    @GetMapping("/api/calc/brokerage")
    public Long calBrokerage(@RequestParam ActionType actionType,
                             @RequestParam Long price){
        // TODO: 중개 수수료 계산하는 로직
        /*
        if(actionType == ActionType.PURCHASE){
            PurchaseBrokeragePolicy policy = new PurchaseBrokeragePolicy();
            return policy.calculate(price);
        }
        if(actionType == ActionType.RENT){
            RentBrokeragePolicy policy = new RentBrokeragePolicy();
            return policy.calculate(price);
        }  타입을 처리하는 부분은 최대한 Factory에서만 clean하게 분기될 수 있도록 -> */
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
