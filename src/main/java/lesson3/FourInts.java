package lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dell-SSD on 12.04.2017.
 */
public class FourInts {
    public static void main(String[] args) {

        int[] next = {3, 8, 8, 8};
        Arrays.sort(next);
        System.out.println(next[0]);
        int number = 1;
        int max = next[next.length-1];

        for (int i = next.length-2; i>=0; i--) {
            if (max==next[i]){
                number++;
            }else {
                break;
            }
        }
        System.out.println(number);

    }
}





        /*int max;
        max = next[3];
        if (next[2]==max) {
            number++;
        }if (next[1]==max){
            number++;
        }if (next[0]==max){
            number++;
        }*/
        //System.out.println("Кол-во одинаковых максимальных чисел " + number);









