package com.SHELBY.calculator.controllers;

import com.SHELBY.calculator.service.Parser;
import com.SHELBY.calculator.calcException;
import com.SHELBY.calculator.domain.Calculations;
import com.SHELBY.calculator.repo.CalculationsRepository;
import com.SHELBY.calculator.service.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculationsRepository calculationsRepository;

    @GetMapping
    public String getExpression(@RequestParam(required = false, defaultValue = "") String expression,
                                Model model) {
        String result;
        Parser parser = new Parser();
        try {
            result = parser.calc(expression.trim()).toString();
        } catch (calcException e) {
            result = e.getMessage();
        }
        model.addAttribute("expression", expression);
        model.addAttribute("result", result);
        Calculations calculations = new Calculations(expression, result);
        calculationsRepository.save(calculations);
        return "calculator";
    }

}
