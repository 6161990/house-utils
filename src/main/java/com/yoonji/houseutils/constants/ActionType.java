package com.yoonji.houseutils.constants;

import lombok.AllArgsConstructor;

/**
 * 타입 정의 - 매매 / 임대차 */
@AllArgsConstructor
public enum ActionType {
    PURCHASE("매매"),
    RENT("임대");

    private String description;
}
