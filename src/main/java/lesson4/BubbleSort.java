package lesson4;

/**
 * Created by Dell-SSD on 12.04.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        boolean tmp = true;
        int tmpInt;
        int a [] = {24,15,36,23,76,54,21};
        while(tmp){
            tmp = false;
        for ( int i = 0; i <a.length-1 ; i++  ) {
            if (a[i] < a[i + 1]) {
                tmpInt = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmpInt;
                tmp = true;
            }
        }
         for (int item:a)
             System.out.println(item+" ");
            System.out.println();
            }
        }
    }

