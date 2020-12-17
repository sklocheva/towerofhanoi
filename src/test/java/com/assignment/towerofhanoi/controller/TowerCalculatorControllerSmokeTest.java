package com.assignment.towerofhanoi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sophia Klocheva
 * on 16/12/2020
 * <p>
 * Test if TowerCalculatorController is present
 * after the Spring context loads.
 */
@SpringBootTest
public class TowerCalculatorControllerSmokeTest
{
    @Autowired
    TowerCalculatorController controller;

    /**
     * Assert that controller is present when context loads
     *
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception
    {
        assertThat(controller).isNotNull();
    }
}
