package com.SHELBY.calculator.service;

import com.SHELBY.calculator.controllers.CalculatorController;
import com.SHELBY.calculator.exceptions.calcException;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    private static final Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static String printvar() {
        StringBuilder var = new StringBuilder();
        if (!vars.isEmpty()) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                var.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
            }
        }
        return var.toString();
    }

    static Var createVar(String operand) throws calcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (vars.containsKey(operand)) {
            return vars.get(operand);
        } else {
            CalculatorController.errorMessage = "Невозможно преобразовать выражение. Проверьте корректность написания выражения";
            throw new calcException("Невозможно преобразовать выражение. Проверьте корректность написания выражения");
        }
    }

    @Override
    public Var add(Var other) throws calcException {
        CalculatorController.errorMessage = "Нельзя сложить: " + this + "+" + other;
        throw new calcException("Нельзя сложить: " + this + "+" + other);
    }

    @Override
    public Var sub(Var other) throws calcException {
        CalculatorController.errorMessage = "Нельзя вычесть: " + this + "-" + other;
        throw new calcException("Нельзя вычесть: " + this + "-" + other);
    }

    @Override
    public Var mul(Var other) throws calcException {
        CalculatorController.errorMessage = "Нельзя умножить: " + this + "*" + other;
        throw new calcException("Нельзя умножить: " + this + "*" + other);
    }

    @Override
    public Var div(Var other) throws calcException {
        CalculatorController.errorMessage = "Нельзя разделить: " + this + "/" + other;
        throw new calcException("Нельзя разделить: " + this + "/" + other);
    }

    @Override
    public Var grade(Var other) throws calcException {
        CalculatorController.errorMessage = "Нельзя возвести в степень: " + this + "^" + other;
        throw new calcException("Нельзя возвести в степень: " + this + "^" + other);
    }
}
