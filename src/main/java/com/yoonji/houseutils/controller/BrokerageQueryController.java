package com.yoonji.houseutils.controller;

import com.yoonji.houseutils.constants.ActionType;
import com.yoonji.houseutils.policy.BrokeragePolicy;
import com.yoonji.houseutils.policy.BrokeragePolicyFactory;
import com.yoonji.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 중개 수수료가 얼만지 질의(조회)하는 컨트롤러
 * */

@RestController
@AllArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;


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
        }  //FIXME 타입을 처리하는 부분은 최대한 Factory에서만 clean하게 분기될 수 있도록 -> */
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    // 아파트라는 데이터를 관리하고 있다가 해당 아파트(apartmentId)의 중개 수수료를 알려주기 위한 api
    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(
            @PathVariable Long apartmentId,
            @RequestParam ActionType actionType
    ){
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        // Long price =0L; // TODO : apartmentId 로 DB에서 price를 가져오기, 해당 지역변수가 굳이 필요 없음 따라서 아래와 같이 진행
        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }
}
