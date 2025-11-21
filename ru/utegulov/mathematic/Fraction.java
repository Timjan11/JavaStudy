package ru.utegulov.mathematic;


import java.util.Objects;

public class Fraction {

    final private int numerator;
    final private int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator= numerator;
        if(denominator<=0){
            throw new IllegalArgumentException("Знаменатель не должен быть меньше либо равен нулю!");
        }
        this.denominator = denominator;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if (other == null) return false;
        if(getClass() != other.getClass()) return false;
        Fraction fr = (Fraction) other;
        if(this.numerator != fr.numerator || this.denominator != fr.denominator){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public String toString(){
        return numerator+"/"+denominator;
    }

    public Fraction addition(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        return new Fraction(num, commonDenominator);
    }

    public Fraction subtraction(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        return new Fraction(num, commonDenominator);
    }

    public Fraction multiplication(Fraction other) {
        int num = this.numerator * other.numerator;
        int denom = this.denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction division(Fraction other) {
        int num = this.numerator * other.denominator;
        int denom = this.denominator * other.numerator;
        return new Fraction(num, denom);
    }

    public void example(Fraction x, String action) {

        if ("addition".equals(action)) {
            Fraction result = this.addition(x);
            System.out.println(this.numerator + "/" + this.denominator + " + " +
                    x.numerator + "/" + x.denominator + " = " +
                    result.numerator + "/" + result.denominator);
        }
        else if ("subtraction".equals(action)) {
            Fraction result = this.subtraction(x);
            System.out.println(this.numerator + "/" + this.denominator + " - " +
                    x.numerator + "/" + x.denominator + " = " +
                    result.numerator + "/" + result.denominator);
        }
        else if ("multiplication".equals(action)) {
            Fraction result = this.multiplication(x);
            System.out.println(this.numerator + "/" + this.denominator + " * " +
                    x.numerator + "/" + x.denominator + " = " +
                    result.numerator + "/" + result.denominator);
        }
        else if ("division".equals(action)) {
            Fraction result = this.division(x);
            System.out.println(this.numerator + "/" + this.denominator + " / " +
                    x.numerator + "/" + x.denominator + " = " +
                    result.numerator + "/" + result.denominator);
        }
        else {
            System.out.println("Неизвестная операция: " + action);
        }
    }

    public Fraction reduce(){
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        return new Fraction(numerator/gcd, denominator/gcd);

    }
    public int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
