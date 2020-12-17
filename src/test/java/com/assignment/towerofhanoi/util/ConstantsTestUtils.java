package com.assignment.towerofhanoi.util;

/**
 * @author Sophia Klocheva
 * on 16/12/2020
 * <p>
 * Constants used for tests.
 */
public class ConstantsTestUtils
{
    public static final String CALC_URL = "/calculate";
    public static final String CALC_PATH_PARAM = "number";

    public static final String CALCULATE_RESULT_1 = "Move disc 1 from A to C.\r\n";
    public static final String CALCULATE_RESULT_3 = "Move disc 1 from A to C.\r\n" +
            "Move disc 2 from A to B.\r\n" +
            "Move disc 1 from C to B.\r\n" +
            "Move disc 3 from A to C.\r\n" +
            "Move disc 1 from B to A.\r\n" +
            "Move disc 2 from B to C.\r\n" +
            "Move disc 1 from A to C.\r\n";

    public static final String INIT_TEXT = "Tower of Hanoi problem";
}
