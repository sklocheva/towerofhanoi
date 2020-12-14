package com.assignment.towerofhanoi.controller;

import com.assignment.towerofhanoi.calculator.TowerOfHanoiCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sophia Klocheva
 * on 14/12/2020
 */
@Controller
public class TowerCalculatorController
{
    @Autowired
    private TowerOfHanoiCalculator hanoiCalculator;

    @GetMapping("tower")
    public String calculateHome(Model model)
    {
        return "calculator";
    }
    @GetMapping("calculate")
    public String calculateTowerOfHanoi(@ModelAttribute("number") int numberOfDisks, Model model)
    {
        model.addAttribute("moves", hanoiCalculator.calculateTower(numberOfDisks));
        return "calculator";
    }

}
