package lesson4HomeWork;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Dell-SSD on 16.04.2017.
 */
public class MassivN {
    public static void main(String[] args) {
        int[] narr = new int[14];

        for (int i = 0; i < narr.length; i++) {
            narr[i] = (int) Math.round((Math.random() * 30));


        }
        int min = narr[0];
        int max = narr[0];

        for (int i = 0; i < narr.length; i++) {
            if (narr[i] < min) {
                min = narr[i];
            }
            if (narr[i]>max){
                max = narr[i];
            }
        }
        int number = 0;
        for (int i = 0; i <narr.length; i++){
            if (min == narr[i]) {
                number++;
            }
    }

            System.out.println("Массив " + Arrays.toString(narr));
            System.out.println("Минимальное значение " + min);
            System.out.println("Количество повторяющихся минимальных значений " + number);
            System.out.println("Максимальное значение " + max);


    }
    }
