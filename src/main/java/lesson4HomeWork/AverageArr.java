package lesson4HomeWork;

/**
 * Created by Dell-SSD on 14.04.2017.
 */
public class AverageArr {
    public static void main(String[] args) {
        int [] average = {34,2,43,1,52,-4,6};
        int sum = 0;
        int aver  ;
        for (int i=0; i<average.length; i++){
           if (i<average.length){
               sum = sum + average[i];
           }
        }
        int sr = sum/average.length;
        int src = sum%average.length;
        System.out.println(sum);

        System.out.print(sr + "." + src);

    }
}
