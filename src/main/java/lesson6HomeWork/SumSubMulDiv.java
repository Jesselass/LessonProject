package lesson6HomeWork;

import java.util.Scanner;

import static javax.print.attribute.standard.MediaSizeName.D;

/**
 * Created by Dell-SSD on 25.04.2017.
 */
public class SumSubMulDiv {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
       // System.out.println(expression);


        // System.out.println(firstNumber);
       // System.out.println(secondNumber);
       // String afterReplace = expression.replaceAll("[\\D]","");
        //System.out.println(afterReplace);
        boolean isContainsPlus = expression.contains("+");
        boolean isContainsMinus = expression.contains("-");
        boolean isContainsStar = expression.contains("*");
        boolean isContainsSlash = expression.contains("/");
        if (isContainsPlus){
            int place = expression.indexOf("+");
            String secondNumber = expression.substring(place+1);
            String firstNumber = expression.substring(0,place);
            int a = Integer.valueOf(firstNumber);
            int b = Integer.valueOf(secondNumber);
            System.out.println(Calculator.sum(a, b));
        }else if (isContainsMinus){
            int place = expression.indexOf("-");
            String secondNumber = expression.substring(place+1);
            String firstNumber = expression.substring(0,place);
            int a = Integer.valueOf(firstNumber);
            int b = Integer.valueOf(secondNumber);
            System.out.println(Calculator.subtrac(a, b));
        }else if (isContainsStar){
            int place = expression.indexOf("*");
            String secondNumber = expression.substring(place+1);
            String firstNumber = expression.substring(0,place);
            int a = Integer.valueOf(firstNumber);
            int b = Integer.valueOf(secondNumber);
            System.out.println(Calculator.multiplication(a, b));
        }else if (isContainsSlash){
            int place = expression.indexOf("/");
            String secondNumber = expression.substring(place+1);
            String firstNumber = expression.substring(0,place);
            int a = Integer.valueOf(firstNumber);
            int b = Integer.valueOf(secondNumber);
            System.out.println(Calculator.division(a, b));
        }


    }
}
