package lesson4HomeWork;

import java.util.Arrays;

/**
 * Created by Dell-SSD on 14.04.2017.
 */
public class Array135 {
    public static void main(String[] args) {
        int[] Array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        //String s = Arrays.toString(Array);
        //System.out.println(s);
        for (int i = 0; i <= Array.length - 1; i++) {
            if (i < Array.length - 1) {
                System.out.print(Array[i] + ",");
            } else {
                System.out.println(Array[i]);
            }

        }


    }
}

