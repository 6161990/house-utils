package com.yoonji.houseutils.policy;

import com.yoonji.houseutils.constants.ActionType;
import com.yoonji.houseutils.exception.ErrorCode;
import com.yoonji.houseutils.exception.HouseUtilsException;

public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType){
        switch (actionType){
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default:
            //    throw new IllegalArgumentException("해당 action type에 대한 정책이 존재하지 않습ㄴ디ㅏ.");
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST,"해당 actionType에 대한 정책이 존재하지 않습니다.");
        }
    }
}
