package com.yoonji.houseutils.policy;

import lombok.AllArgsConstructor;

/**
 * 가격이 특정 범위일 때 상한 효율과 상한금액을 가지는 클래스*/
@AllArgsConstructor
public class BrokerageRule {

    private Double brokeragePercent;
    private Long limitAmount;


    public Long calcMaxBrokerage(Long price){
        if(limitAmount == null) {
            return multiplyPercent(price); // 큰 금액들에 대해서는 상한 효율이 없었음
        }
        return Math.min(multiplyPercent(price), limitAmount); //상한 금액이 있는 경우
    }

    private Long multiplyPercent(Long price) {
/*      Double amount = Math.floor(brokeragePercent / 100 * price); //floor 소수점 잘라줌
        return amount.longValue(); //double을 Long형으로
        코드 정리를 통해 아래와 같이 , longValue를 쓰려면 Double 객체형이어야 하기 떄문에 */
        return Double.valueOf(Math.floor(brokeragePercent /100 * price)).longValue();
    }


}
