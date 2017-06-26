package lesson4HomeWork;

import java.util.Arrays;



/**
 * Created by Dell-SSD on 16.04.2017.
 */
public class SortHype {
    public static void main(String[] args) {
        Integer [] arr = new Integer [26];
        for (int i = 0; i<arr.length; i++)
            arr[i]=(int)(Math.round(Math.random()*30));
       // System.out.println(Arrays.toString(arr));


        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static Comparable[] mergeSort(Comparable  [] list){
        Comparable[] first = new Comparable[list.length/2];
        Comparable[] second = new Comparable[list.length-first.length];
        System.arraycopy(list,0, first,0, first.length);
        System.arraycopy(list, first.length, second,0,second.length);
        mergeSort(first);
        mergeSort(second);
        merge(first,second,list);
        return list;

    }

    public static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;
        while (iFirst<first.length && iSecond<second.length){
            if (first[iFirst].compareTo(second[iSecond])<0)
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            }else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first,iFirst,result,iMerged,first.length - iFirst);
        System.arraycopy(second,iSecond,result,iMerged,second.length - iSecond);
    }
}

