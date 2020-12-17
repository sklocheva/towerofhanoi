package com.assignment.towerofhanoi.calculator;

import com.assignment.towerofhanoi.util.ConstantsTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sophia Klocheva
 * on 15/12/2020
 * <p>
 * Test functionality of TowerOfHanoiCalculator with small and large numbers.
 */
class TowerOfHanoiCalculatorTest
{
    private TowerOfHanoiCalculator calculator = new TowerOfHanoiCalculator();

    @Test
    public void calculateTowerSmallNumber()
    {
        assertEquals(calculator.calculateTower(1), ConstantsTestUtils.CALCULATE_RESULT_1);
        assertEquals(calculator.calculateTower(3), ConstantsTestUtils.CALCULATE_RESULT_3);
    }

    @Test
    public void calculateTowerRandom()
    {
        calculator.calculateTower((int) (10.0 * Math.random()));
    }
}