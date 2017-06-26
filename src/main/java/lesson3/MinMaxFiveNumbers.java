package lesson3;

import javafx.collections.transformation.SortedList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dell-SSD on 11.04.2017.
 */
public class MinMaxFiveNumbers {
    public static void main(String[] args) {
        int [] intArray = {115,2,43,54,3};
        Arrays.sort(intArray);

        System.out.println("Минимум = " + intArray[0]);
        System.out.println("Максимум =" + intArray[4]);

    }

        /*if (x<c && x<z && x<v && x<b ) {
            System.out.println("Самое маленькое число " + x);
        }
        else if (c<x && c<z && c<v && c<b) {
            System.out.println("Самое маленькое число " + c);
        }
        else if (z<c && z<x && z<v && z<b) {
            System.out.println("Самое маленькое число " + z);
        }
        else if (v<c && v<z && v<x && v<b) {
            System.out.println("Самое маленькое число " + v);
        }
        else {
            System.out.println("Самое большое число " + b);
        }
        if (x>c && x>z && x>v && x>b ) {
            System.out.println("Самое большое число " + x);
        }
        else if (c>x && c>z && c>v && c>b) {
            System.out.println("Самое большое число " + c);
        }
        else if (z>c && z>x && z>v && z>b) {
            System.out.println("Самое большое число " + z);
        }
        else if (v>c && v>z && v>x && v>b) {
            System.out.println("Самое большое число " + v);
        }
        else {
            System.out.println("Самое большое число " + b);
        }*/
    }

