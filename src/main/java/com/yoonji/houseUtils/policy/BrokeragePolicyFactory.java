package com.yoonji.houseUtils.policy;

import com.yoonji.houseUtils.constants.ActionType;
/**
 * ActionType 에 따라 BrokeragePolicy 를 생성하는 책임
 * */
public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
                throw new IllegalArgumentException("해당 ActionType 에 대한 정책이 존재하지 않습니다.");
        }
    }
}
