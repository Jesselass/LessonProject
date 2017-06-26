package lesson5HomeWork;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell-SSD on 23.04.2017.
 */
public class WordGetOut {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String s = myScanner.nextLine();
        int index = s.indexOf("new");
        String out = s.substring(index+3);
        System.out.println(out);

    }
}