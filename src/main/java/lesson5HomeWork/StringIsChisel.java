package lesson5HomeWork;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell-SSD on 23.04.2017.
 */
public class StringIsChisel {
    public static void main(String[] args) {
        Scanner nums = new Scanner(System.in);
        String numbers = nums.nextLine();
        System.out.println(numbers);
        String [] nu = numbers.split(",");
        int sum = 0;
        for (int i = 0;i<nu.length; i++){
            sum = sum + Integer.valueOf(nu[i]);
        }
        System.out.println(sum);


        //char [] number = num.toCharArray();


    }
}
