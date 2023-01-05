package com.yoonji.houseUtils.policy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(
                purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L);
        assertEquals(
                purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L);
        assertEquals(
                purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        assertEquals(
                purchaseBrokeragePolicy.calculate(800_000_000L), 4_000_000L);
        assertEquals(
                purchaseBrokeragePolicy.calculate(1_000_000_000L), 9_000_000L);
    }

    @Test
    void rentBrokeragePolicy_test() {
        assertEquals(
                rentBrokeragePolicy.calculate(30_000_000L), 150_000L);
        assertEquals(
                rentBrokeragePolicy.calculate(100_000_000L), 300_000L);
        assertEquals(
                rentBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        assertEquals(
                rentBrokeragePolicy.calculate(800_000_000L), 6_400_000L);
        assertEquals(
                rentBrokeragePolicy.calculate(1_000_000_000L), 8_000_000L);
    }

}