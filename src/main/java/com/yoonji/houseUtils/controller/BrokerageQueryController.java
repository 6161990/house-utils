package com.yoonji.houseUtils.controller;

import com.yoonji.houseUtils.constants.ActionType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {
    @GetMapping("/api/calc/brokerage")
    public Long calcPrice(@RequestParam ActionType actionType,
                          @RequestParam Long price){
        // 중개 수수료를 계산하는 로직
        return null;
    }
}
