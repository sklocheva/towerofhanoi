package com.assignment.towerofhanoi.controller;

import com.assignment.towerofhanoi.calculator.TowerOfHanoiCalculator;
import com.assignment.towerofhanoi.util.ConstantsTestUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Sophia Klocheva
 * on 16/12/2020
 * <p>
 * Test TowerCalculatorController with mocked injected classes.
 */
@WebMvcTest(TowerCalculatorController.class)
public class TowerCalculatorControllerMockTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TowerOfHanoiCalculator calculator;

    /**
     * Test controller with mocked result.
     *
     * @throws Exception
     */
    @Test
    public void testTowerControllerReturnMockedText() throws Exception
    {
        when(calculator.calculateTower(1))
                .thenReturn(ConstantsTestUtils.CALCULATE_RESULT_1);

        this.mockMvc.perform(
                get(ConstantsTestUtils.CALC_URL)
                        .param(ConstantsTestUtils.CALC_PATH_PARAM, "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(ConstantsTestUtils.INIT_TEXT)))
                .andExpect(model().attribute("moves", Matchers.equalTo(ConstantsTestUtils.CALCULATE_RESULT_1)));
    }

    /**
     * Test error message for negative number
     *
     * @throws Exception
     */

    @Test
    public void testTowerControllerNegativeErrorText() throws Exception
    {
        this.mockMvc.perform(
                get(ConstantsTestUtils.CALC_URL)
                        .param(ConstantsTestUtils.CALC_PATH_PARAM, "-3"))
                .andDo(print())
                .andExpect(content().string(containsString(ConstantsTestUtils.INIT_TEXT)))
                .andExpect(model().attribute("error", Matchers.notNullValue()))
                .andExpect(model().attribute("move", Matchers.nullValue()));
    }
}
