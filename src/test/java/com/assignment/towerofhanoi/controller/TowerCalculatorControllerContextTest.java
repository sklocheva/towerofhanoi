package com.assignment.towerofhanoi.controller;

import com.assignment.towerofhanoi.util.ConstantsTestUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Sophia Klocheva
 * on 16/12/2020
 * <p>
 * Test TowerCalculatorController with Spring context
 * without starting the whole server.
 */
@SpringBootTest
@AutoConfigureMockMvc
class TowerCalculatorControllerContextTest
{

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test loading home page.
     *
     * @throws Exception
     */
    @Test
    public void testTowerControllerHome() throws Exception
    {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(ConstantsTestUtils.INIT_TEXT)));
    }

    /**
     * Integration test of calculation of Tower of Hanoi through Controller.
     *
     * @throws Exception
     */
    @Test
    public void testTowerControllerCalculate() throws Exception
    {
        this.mockMvc.perform(
                get(ConstantsTestUtils.CALC_URL)
                        .param(ConstantsTestUtils.CALC_PATH_PARAM, "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(ConstantsTestUtils.INIT_TEXT)))
                .andExpect(model().attribute("moves", Matchers.equalTo(ConstantsTestUtils.CALCULATE_RESULT_1)));
    }

}