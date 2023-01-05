package com.yoonji.houseUtils.controller;

import com.yoonji.houseUtils.constants.ActionType;
import com.yoonji.houseUtils.policy.BrokeragePolicy;
import com.yoonji.houseUtils.policy.BrokeragePolicyFactory;
import com.yoonji.houseUtils.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 중계수수료 조회 컨트롤러
 * */
@RestController
@RequiredArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService service;

    @GetMapping("/api/calc/brokerage")
    public Long calcPrice(@RequestParam ActionType actionType,
                          @RequestParam Long price){
        BrokeragePolicy brokeragePolicy = BrokeragePolicyFactory.of(actionType);
        return brokeragePolicy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(@PathVariable Long apartmentId,
                                   @RequestParam ActionType actionType){
        BrokeragePolicy brokeragePolicy = BrokeragePolicyFactory.of(actionType);
        return brokeragePolicy.calculate(service.priceOrThrow(apartmentId));
    }
}
