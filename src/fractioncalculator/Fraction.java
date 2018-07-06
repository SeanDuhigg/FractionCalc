package fractioncalculator;

import java.util.*;
/**
 *
 * @author Sean
 */
public class Fraction {
    
    private int numerator;
    private int denominator;
    
    
    //constructor takes numerator and denominator
    //if both values are negative, converts to positive
    //if denominator is negative, the negative is moved to numerator
    //check for divide by 0
    public Fraction(int numerator, int denominator){
        
        this.numerator = numerator;
        this.denominator = denominator;
        
        if(denominator == 0){
            throw new ArithmeticException("You can't divide by 0");
        }
        if(numerator < 0 && denominator < 0){
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);            
        }
        if(numerator > 0 && denominator < 0){            
            this.numerator = (-1) * numerator;
            this.denominator = Math.abs(denominator);            
        }
    }
    //constructor initializes based on numerator/1
    public Fraction(int numer){
        
        this.numerator = numer;
        this.denominator = 1;
        
    }
    //constructor initializes to 0, so 0/x
    public Fraction(){
        
        this.numerator = 0;
        this.denominator = 1;
        
    }
    //returns numerator
    public int getNumerator(){
        
        return numerator;
    }
    //returns denominator
    public int getDenominator(){
        
        return denominator;
    }
    //prints the fraction as a string
    public String toString(){
        
        
        return numerator + "/" + denominator;
    }
    //prints the fraction as a double
    public double toDouble(){
        
        return numerator/denominator;
    }
    //adds a new fraction in 
    public Fraction add(Fraction other){
        Fraction result = new Fraction();
        if(other.denominator == this.denominator){
            result.numerator = this.numerator + other.getNumerator();
            result.denominator = other.denominator;
       
        }else{
            int tempnum;
            tempnum = other.getNumerator() * this.denominator;
            result.numerator = this.numerator * other.getDenominator();
            result.denominator = this.denominator * other.getDenominator();
            result.numerator = result.numerator + tempnum;            
            
        }
        int gcd = gcd(result.numerator, result.denominator);
        result.numerator = result.numerator/gcd;
        result.denominator = result.denominator/gcd;
        
        return result;
    }
    //subtracts one fraction from another
    public Fraction subtract(Fraction other){
        
        Fraction result = new Fraction();
        if(this.denominator == 0){
            throw new ArithmeticException("You can't divide by 0");
        }
        //if the fractions have the same denominator
        if(other.denominator == this.denominator){
            result.numerator = this.numerator - other.getNumerator();
            result.denominator = other.denominator;
        }else{
            int tempnum;
            tempnum = other.getNumerator() * this.denominator;
            result.numerator = this.numerator * other.getDenominator();
            result.denominator = this.denominator * other.getDenominator();
            result.numerator = result.numerator - tempnum;             
               
        }
        if(!(result.numerator == 0)){
            int gcd = gcd(result.numerator, result.denominator);
            result.numerator = result.numerator/gcd;
            result.denominator = result.denominator/gcd;
        }
        return result;
    }
    //multiplies one fraction with another
    public Fraction multiply(Fraction other){
        Fraction result = new Fraction();
        result.numerator = this.numerator * other.getNumerator();
        result.denominator = this.denominator * other.getDenominator();
        
        //other.numerator = this.numerator;
        //other.denominator = this.denominator;
        
        int gcd = gcd(result.numerator, result.denominator);
        result.numerator = result.numerator/gcd;
        result.denominator = result.denominator/gcd;
        
        return result;
    }
    //divides one fraction from another
    public Fraction divide(Fraction other){
        Fraction result = new Fraction();
        if(other.denominator == 0 || this.denominator == 0 || other.numerator == 0){
            throw new IllegalArgumentException("Can't divide by 0");
        }else{
            result.numerator = this.numerator * other.getDenominator();
            result.denominator = this.denominator * other.getNumerator();
        
            //other.numerator = this.numerator;
            //other.denominator = this.denominator;
        }
        
        int gcd = gcd(result.numerator, result.denominator);
        result.numerator = result.numerator/gcd;
        result.denominator = result.denominator/gcd;
        return result;
    }
    //returns true or false if 2 fractions are equal or not
    @Override
    public boolean equals(Object other){
        
        String fraction;
        int num,den,num1,den1,gcd1,gcd2;
        Fraction myFraction = (Fraction) other;
        if(other instanceof Fraction){
            
            
            num = myFraction.numerator;
            den = myFraction.denominator;
            gcd1 = gcd(num, den);
            num = num / gcd1;
            den = den / gcd1;
            myFraction.numerator = num;
            myFraction.denominator = den;
            
            gcd2 = gcd(this.numerator, this.denominator);
            this.numerator = this.numerator / gcd2;
            this.denominator = this.denominator / gcd2;
               
            if(this.numerator == num && this.denominator == den){
                return true;
            }else{
                return false;
            }
            
        }else{
            
            System.out.println("Input is not a fraction.");
        }
        
        return false;
        }
    //reduces fraction 
    public void toLowestTerms(){
        
        
    }
    //finds GCD of numerator and denominator
    public static int gcd(int numerator, int denominator){
        int remainder = 0;
        while (numerator != 0 && denominator != 0){
        
            remainder = numerator % denominator;
            numerator = denominator;
            denominator = remainder;
        }
        
        return numerator;
    }
}
