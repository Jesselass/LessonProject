package lesson2;

import java.util.Scanner;
import java.util.Stack;

import static java.awt.SystemColor.text;


/**
 * Created by Dell-SSD on 10.04.2017.
 */
public class Polendrom1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //String x = new StringBuffer().reverse().toString();
        StringBuilder x = new StringBuilder(s);
        // System.out.println("1) " + x.reverse());
        //char[] m = s.toCharArray();
        String n = x.reverse().toString();
       // char[] v = n.toCharArray();

        // String x = m.toString();


        if (n.equals(s) ) {
            System.out.println("Слово " + s + " является палиндромом!!!");
        } else if (!n.equals(s)) {

            System.out.println("Слово " + s + " не является палиндромом!!!!");


            // }

        }
    }
}
