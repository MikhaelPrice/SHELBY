package com.SHELBY.calculator.service;

import com.SHELBY.calculator.calcException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String[] priority = {"=", "+", "-", "*", "/", "^"};
    public static ResourceBundle rb;

    private String expressionSimplification(String str) throws calcException {
        Parser parser = new Parser();
        try {
            if (str.contains("(") && str.contains(")")) {
                Pattern patternExpressionsInBrackets = Pattern.compile("\\([^()]+\\)");
                Matcher matcher = patternExpressionsInBrackets.matcher(str);
                if (matcher.find()) {
                    String expressionsInBrackets = matcher.group();
                    String expr = expressionsInBrackets.substring(1, expressionsInBrackets.length() - 1);
                    String resultExpressionsInBrackets = String.valueOf(parser.calc(expr));
                    int start = matcher.start();
                    int end = matcher.end();
                    String result = str.substring(0, start) + resultExpressionsInBrackets + str.substring(end);
                    return expressionSimplification(result.replaceAll(" ", ""));
                }
            }
        } catch (calcException e) {
            e.printStackTrace();
        }
        return str;
    }

    private Var calcOneOperation(String strOne, String strOperation, String strTwo) throws calcException {
        Var two = Var.createVar(strTwo);
        if (strOperation.equals("=")) {
            return Var.saveVar(strOne, two);
        }
        Var one = Var.createVar(strOne);
        if (one == null || two == null) {
            throw new calcException("Нет переменной");
        }
        switch (strOperation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
            case "^":
                return one.grade(two);
        }
        throw new calcException("Невозможно распознать операцию");
    }

    private int currentOperationIndex(List<String> operations) {
        int currentResult = -1;
        int currentPrior = -1;
        for (int i = 0; i < operations.size(); i++) {
            int pr = -1;
            String op = operations.get(i);
            for (int j = 0; j < priority.length; j++) {
                if (priority[j].equals(op)) {
                    pr = j;
                    break;
                }
            }
            if (currentPrior < pr) {
                currentPrior = pr;
                currentResult = i;
            }
        }
        return currentResult;
    }

    public Var calc(String expression) throws calcException {
        Var res = null;
        try {
            if (expression.contains("(") && expression.contains(")")) {
                expression = expressionSimplification(expression);
            }
            String[] tmp = expression.split(Patterns.OPERATION);
            List<String> operands = new ArrayList<>(Arrays.asList(tmp));
            List<String> operations = new ArrayList<>();
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
                operations.add(matcher.group());
            }
            while (operations.size() > 0) {
                int pos = currentOperationIndex(operations);
                String one = operands.get(pos);
                String op = operations.remove(pos);
                String two = operands.remove(pos + 1);
                res = calcOneOperation(one, op, two);
                operands.set(pos, res.toString());
            }

        } catch (calcException e) {
            System.out.println(e.getMessage());
        }
        if (res == null) {
            throw new calcException();
        }
        return res;
    }
}

