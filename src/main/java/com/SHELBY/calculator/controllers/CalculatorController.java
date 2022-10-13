package com.SHELBY.calculator.controllers;

import com.SHELBY.calculator.service.Parser;
import com.SHELBY.calculator.exceptions.calcException;
import com.SHELBY.calculator.domain.Calculations;
import com.SHELBY.calculator.repo.CalculationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculationsRepository calculationsRepository;

    public static String errorMessage;

    @GetMapping
    public String getExpression(@RequestParam(required = false, defaultValue = "") String expression,
                                Model model) {
        String result;
        Parser parser = new Parser();
        try {
            result = parser.calc(expression.trim()).toString();
        } catch (calcException e) {
            result = errorMessage;
        }
        Calculations calculations = new Calculations(expression, result);
        calculationsRepository.save(calculations);
        if (calculationsRepository.findById(calculations.getId()).isPresent()) {
            model.addAttribute("expression", calculationsRepository.findById(calculations.getId()).get().getExpression());
            model.addAttribute("result", calculationsRepository.findById(calculations.getId()).get().getResult());
        }
        return "calculator";
    }

}
