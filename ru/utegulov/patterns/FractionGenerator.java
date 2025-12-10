package ru.utegulov.patterns;

import ru.utegulov.mathematic.Fraction;

import java.util.Random;

public class FractionGenerator {

    private static FractionGenerator instance;

    private Random random = new Random();

    public FractionGenerator() {
        this.random = new Random();
    }

    public static FractionGenerator getInstance() {
        if(instance == null){
            instance = new FractionGenerator();
        }
        return instance;
    }

    public Random getRandom() {
        return random;
    }

    public Fraction generateFraction(){
        int numerator = random.nextInt();
        int denominator = random.nextInt();
        if(denominator==0){
            while(denominator==0){
                denominator = random.nextInt();
            }
        }

        return new Fraction(numerator, denominator);
    }

    public Fraction generateFractionWithNumerator(int numerator){
        int denominator = random.nextInt();
        if(denominator==0){
            while(denominator==0){
                denominator = random.nextInt();
            }
        }
        return new Fraction(numerator, denominator);
    }

    public Fraction generateFractionWithDenominator(int denominator){
        int numerator = random.nextInt();
        if(denominator==0){
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        return new Fraction(numerator, denominator);
    }



}
