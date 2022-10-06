package com.SHELBY.calculator.service;

import com.SHELBY.calculator.controllers.CalculatorController;
import com.SHELBY.calculator.exceptions.calcException;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");
        String[] strings = strVector.split(",");
        value = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            value[i] = Double.parseDouble(strings[i]);
        }
    }

    @Override
    public Var sub(Var other) throws calcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (((Vector) other).value.length != this.value.length) {
                CalculatorController.errorMessage = "Векторы разной длины";
                throw new calcException("Векторы разной длины");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector) other).getValue()[i];
            }
            return new Vector(res);
        } else {
            return other.sub(this);
        }
    }

    @Override
    public Var div(Var other) throws calcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            if (((Scalar) other).getValue() == 0) {
                CalculatorController.errorMessage = "На нуль делить нельзя";
                throw new calcException("На нуль делить нельзя");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] /= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else {
            return super.div(other);
        }
    }

    @Override
    public Var grade(Var other) throws calcException {
        if (!(other instanceof Scalar)) {
            CalculatorController.errorMessage = "Нельзя возводить в степень в нескалярные величины";
            throw new calcException();
        }
        double otherToDouble = Double.parseDouble(other.toString());
        if (otherToDouble == 0) {
            return new Scalar(1);
        }
        boolean isEven = otherToDouble % 2 == 0;
        double[] v1 = Arrays.copyOf(getValue(), getValue().length);
        double[] result = Arrays.copyOf(getValue(), getValue().length);
        double res = 0;
        if (isEven) {
            for (int i = 1; i < otherToDouble; i++) {
                for (int j = 0; j < v1.length; j++) {
                    if (i % 2 == 0) {
                        v1[j] *= res;
                    } else {
                        v1[j] *= result[j];
                    }
                }
                res = 0;
                for (int k = 0; k < v1.length; k++) {
                    result[k] = v1[k];
                    if (i % 2 != 0) {
                        res += result[k];
                    }
                }
                v1 = Arrays.copyOf(getValue(), getValue().length);
            }
            return new Scalar(res);
        } else {
            for (int i = 1; i < otherToDouble; i++) {
                for (int j = 0; j < v1.length; j++) {
                    if (i % 2 == 0) {
                        v1[j] *= res;
                    } else {
                        v1[j] *= result[j];
                    }
                }
                res = 0;
                for (int k = 0; k < v1.length; k++) {
                    result[k] = v1[k];
                    if (i % 2 != 0) {
                        res += result[k];
                    }
                }
                v1 = Arrays.copyOf(getValue(), getValue().length);
            }
            return new Vector(result);
        }
    }

    @Override
    public Var mul(Var other) throws calcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double sum = 0;
            double[] res = Arrays.copyOf(value, value.length);
            if (((Vector) other).value.length != this.value.length) {
                CalculatorController.errorMessage = "Векторы разной длины";
                throw new calcException("Векторы разной длины");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Vector) other).getValue()[i];
                sum += res[i];
            }
            return new Scalar(sum);

        } else if (other instanceof Matrix) {
            double[][] res = new double[((Matrix) other).getSizeI()][((Matrix) other).getSizeJ()];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = ((Matrix) other).getValue()[i][j];
                }
            }
            double[] result = Arrays.copyOf(value, value.length);
            double[][] newMatrix = new double[res[0].length][1];
            if (result.length != res.length) {
                CalculatorController.errorMessage = "Матрица и вектор разного порядка";
                throw new calcException("Матрица и вектор разного порядка");
            }
            for (int i = 0; i < res[0].length; i++) {
                for (int j = 0; j < result.length; j++) {
                    newMatrix[i][0] += result[j] * res[j][i];
                }
            }
            return new Matrix(newMatrix);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var add(Var other) throws calcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (((Vector) other).value.length != this.value.length) {
                CalculatorController.errorMessage = "Векторы разной длины";
                throw new calcException("Векторы разной длины");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).getValue()[i];
            }
            return new Vector(res);
        } else {
            return other.add(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        for (int i = 0; i < getValue().length; i++) {
            if (i < getValue().length - 1) {
                str.append(getValue()[i]).append(", ");
            } else {
                str.append(getValue()[i]);
            }
        }
        str.append("}");
        return str.toString();
    }
}
