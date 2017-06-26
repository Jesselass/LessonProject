package lesson4HomeWork;

import java.util.Arrays;

/**
 * Created by Dell-SSD on 14.04.2017.
 */
public class ZamenaMinNaMax {
    public static void main(String[] args) {
        int[] minmax = {-8, 38, -1, 56, 54};
        int min = minmax[0];
        int max = minmax[0];
        int imin = 0;
        int imax = 0;
        int temp  ;

         for (int i = 0; i < minmax.length; i++) {

            if (minmax[i] < min) {
                min = minmax[i];
                imin = i;
            }
         }
         for (int i = 0; i < minmax.length; i++) {
                if (minmax[i] > max) {
                    max = minmax[i];
                    imax = i;
                }
         }

        //min = minmax[imin];
        //max = minmax[imax];
        temp = minmax[imin];
        minmax[imin] = minmax[imax];
        minmax[imax] = temp;
             //imin=minmax[3];
        String s = Arrays.toString(minmax);
        System.out.println(s);

       /*System.out.println(min);
        System.out.println(max);
        System.out.println(imax);
        System.out.println(imin);*/



    }
}

