package com.assignment.towerofhanoi.controller;

import com.assignment.towerofhanoi.util.ConstantsTestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sophia Klocheva
 * on 16/12/2020
 * <p>
 * Test TowerCalculatorController using Http request,
 * with loading Spring context and server.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TowerCalculatorControllerHttpTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String URL_BASE = "http://localhost:";
    private final String URL_CALC = "/calculate?number=";

    /**
     * Assert that initial page is returned with correct text.
     */
    @Test
    public void testHttpInitialPageController()
    {
        assertThat(this.restTemplate.getForObject(
                URL_BASE + port + "/", String.class)).doesNotContain("dfdfd");
        assertThat(this.restTemplate.getForObject(
                URL_BASE + port + "/", String.class)).contains(ConstantsTestUtils.INIT_TEXT);
    }

    /**
     * Integration test of Tower of Hanoi calculation from calculation page.
     */
//    @Test
    public void testHttpCalculatorController()
    {
        System.out.println(URL_BASE + port + URL_CALC + 1);
        assertThat(this.restTemplate.getForObject(
                URL_BASE + port + URL_CALC + 1, String.class))
                .contains(ConstantsTestUtils.CALCULATE_RESULT_1);
    }
}
