package com.yoonji.houseUtils.policy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BrokeragePolicyTest {

    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    void setUp() {
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }

    @Test
    void purchaseBrokeragePolicy_test() {
        Long price = 30_000_000L;

        Long actual = purchaseBrokeragePolicy.calculate(price);

        assertThat(actual).isEqualTo(180_000L);
    }
}