package com.SHELBY.calculator.controllers;

import com.SHELBY.calculator.service.Var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VarController {

    @GetMapping("/vars")
    public String showVars(@RequestParam(required = false, defaultValue = "") String vars, Model model) {
        vars = Var.printvar();
        model.addAttribute("vars", vars);
        return "vars";
    }
}
