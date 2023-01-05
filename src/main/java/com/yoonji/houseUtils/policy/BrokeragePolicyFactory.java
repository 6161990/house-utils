package com.yoonji.houseUtils.policy;

import com.yoonji.houseUtils.constants.ActionType;
import com.yoonji.houseUtils.exception.ErrorCode;
import com.yoonji.houseUtils.exception.HouseUtilsException;

/**
 * ActionType 에 따라 BrokeragePolicy 를 생성하는 책임
 * */
public class BrokeragePolicyFactory {

    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();


    public static BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 ActionType 에 대한 정책이 존재하지 않습니다.");
        }
    }
}
