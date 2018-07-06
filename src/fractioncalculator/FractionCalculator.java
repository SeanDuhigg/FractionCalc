package fractioncalculator;
import java.util.*;

public class FractionCalculator {
    public static Fraction fraction1 = new Fraction();
    public static Fraction fraction2 = new Fraction();
    public static Fraction result = new Fraction();
    public static void main(String[] args) {
        
        
        
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("----------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        
        
        while(!(scanner.equals("+") || scanner.equals("-") || scanner.equals("/") || scanner.equals("*") || scanner.equals("=") || scanner.equals("Q"))){
            String operation = getOperation(scanner);
            if(operation.equals("+")){
                fraction1 = getFraction(scanner);
                fraction2 = getFraction(scanner);
                result = fraction1.add(fraction2);
                if(result.getDenominator() == 1){
                    System.out.println(fraction1 + " + " + fraction2 + " = " + result.getNumerator());
                }else{
                    System.out.println(fraction1 + " + " + fraction2 + " = " + result);
                }
            }else if(operation.equals("-")){
                fraction1 = getFraction(scanner);
                fraction2 = getFraction(scanner);
                result = fraction1.subtract(fraction2);
                if(result.getNumerator() == 0){
                    System.out.println(fraction1 + " - " + fraction2 + " = " + result.getNumerator());
                }else if(result.getDenominator() == 1){
                    System.out.println(fraction1 + " - " + fraction2 + " = " + result.getNumerator());
                }else{
                    System.out.println(fraction1 + " - " + fraction2 + " = " + result);
                }
            }else if (operation.equals("*")){
                fraction1 = getFraction(scanner);
                fraction2 = getFraction(scanner);
                result = fraction1.multiply(fraction2);
                if(result.getNumerator() == 0){
                    System.out.println(fraction1 + " * " + fraction2 + " = " + "0");
                }else if(result.getDenominator() == 1){
                    System.out.println(fraction1 + " * " + fraction2 + " = " + result.getNumerator());
                }else{
                    System.out.println(fraction1 + " * " + fraction2 + " = " + result);
                }
            }else if (operation.equals("/")){
                fraction1 = getFraction(scanner);
                fraction2 = getFraction(scanner);
                result = fraction1.divide(fraction2);
                if(result.getNumerator() == 0){
                    System.out.println(fraction1 + " / " + fraction2 + " = " + "0");
                }else if(result.getDenominator() == 1){
                    System.out.println(fraction1 + " / " + fraction2 + " = " + result.getNumerator());
                }else{
                    System.out.println(fraction1 + " / " + fraction2 + " = " + result);
                }
            }else if (operation.equals("=")){
                fraction1 = getFraction(scanner);
                fraction2 = getFraction(scanner);
                System.out.println(fraction1 + " = " + fraction2 + " is " + fraction1.equals(fraction2));
            }else if (operation.equals("Q")){
                break;
            }else if (operation.equals("q")){
                break;
            }
        }
        
    }

    public static String getOperation(Scanner input){
        
        System.out.print("Please enter an operation (+, -, *, /, = or Q to quit):");
        String string = input.nextLine();
        
        while(!(string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*") || string.equals("=") || string.equals("Q"))){
            if(string.equals("Q")||string.equals("q")){
                break;
            }
            System.out.println("Invalid input (+, -, *, /, = or Q to quit):");
            string = input.nextLine();
        }
        
        
        
        return string;
    }
    
    private static boolean validFraction(String input){
        String sub1, sub2;
        int index;
        //get rid of a negative
        if(input.contains("-")){
            input = input.replace("-", "");
        }
        //check for division and split to substring
        if(input.contains("/")){
            
            index = input.indexOf("/");
            
            sub1 = input.substring(0, index);
            sub2 = input.substring(index+1, input.length());
            //see if input matches("[0-9]+") and length > 1)
            if(!(sub1.matches("[0-9]+") || sub1.length() > 1)){
                
                return false;
                //see if input matches("[0-9]+") and length > 1)
            }
            if(!(sub2.matches("[0-9]+") || sub2.length() > 1)){
                
                return false;
            }    
        }else if(!(input.matches("[0-9]+") || input.length() > 1)){
            
            return false;
        }
    return true;
    }
    public static Fraction getFraction(Scanner input){
        
        String sub1, sub2;
        int index, num, den;
        System.out.print("Please enter a fraction (a/b) or integer (a):");
        String string = input.nextLine();
        boolean bool = validFraction(string);
        while (bool == false){
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero:");
            string = input.nextLine();
            bool = validFraction(string);
        }
        if(string.contains("/")){
            index = string.indexOf("/");
            sub1 = string.substring(0, index);
            sub2 = string.substring(index+1, string.length());
            num = Integer.parseInt(sub1);
            den = Integer.parseInt(sub2);
            Fraction fraction = new Fraction(num, den);
            return fraction;
        }else{
            num = Integer.parseInt(string);
            Fraction fraction = new Fraction(num);
            return fraction;
        }
        
    }
}


