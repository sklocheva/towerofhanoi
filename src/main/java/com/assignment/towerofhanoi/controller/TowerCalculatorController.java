package com.assignment.towerofhanoi.controller;

import com.assignment.towerofhanoi.calculator.TowerOfHanoiCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Sophia Klocheva
 * on 14/12/2020
 * <p>
 * TowerCalculatorController provides the API
 * for Tower of Hanoi calculation and result visualisation.
 * <p>
 * It loads the home page where
 */
@Slf4j
@Controller
public class TowerCalculatorController
{
    @Autowired
    private TowerOfHanoiCalculator hanoiCalculator;

    /**
     * Loads initial page.
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String calculateHome(Model model)
    {
        return "calculator";
    }

    /**
     * Calculates the set of moves needed to move the rings
     * from peg A to C and displays them on the page.
     *
     * @param disk
     * @param model
     * @return
     */
    @GetMapping("/calculate")
    public String calculateTowerOfHanoi(@ModelAttribute("disksNumber") Integer disk, Model model)
    {
        log.info("*** Received request. Number of disks: " + disk);
        if (disk <= 0)
        {
            log.warn("DiskNumber smaller than 0");
            return "calculator";
        }
        String resultMoves = hanoiCalculator.calculateTower(disk);
        log.info(String.format("*** Result for %d disks is: %s", disk, resultMoves));
        model.addAttribute("moves", resultMoves);

        return "calculator";
    }

}
