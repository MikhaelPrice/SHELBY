package com.SHELBY.calculator.service;

import com.SHELBY.calculator.controllers.CalculatorController;
import com.SHELBY.calculator.exceptions.calcException;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public Var add(Var other) throws calcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws calcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else if (other instanceof Vector) {
            double[] res = new double[((Vector) other).getValue().length];
            for (int i = 0; i < res.length; i++) {
                res[i] = ((Vector) other).getValue()[i];
            }
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value - res[i];
            }
            return new Vector(res);
        } else if (other instanceof Matrix) {
            double[][] res = new double[((Matrix) other).getSizeI()][((Matrix) other).getSizeJ()];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = ((Matrix) other).getValue()[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = this.value - res[i][j];
                }
            }
            return new Matrix(res);
        } else {
            return other.sub(this);
        }
    }

    @Override
    public Var div(Var other) throws calcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) {
                CalculatorController.errorMessage = "На нуль делить нельзя";
                throw new calcException("На нуль делить нельзя");
            }
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    @Override
    public Var grade(Var other) throws calcException {
        if (!(other instanceof Scalar)) {
            CalculatorController.errorMessage = "Нельзя возводить в степень в нескалярные величины";
            throw new calcException("Нельзя возводить в степень в нескалярные величины");
        }
        double res = Math.pow(this.getValue(), Double.parseDouble(other.toString()));
        return new Scalar(res);
    }

    @Override
    public Var mul(Var other) throws calcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
