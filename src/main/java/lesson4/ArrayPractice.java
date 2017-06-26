package lesson4;

/**
 * Created by Dell-SSD on 12.04.2017.
 */
public class ArrayPractice {
    public static void main(String[] args) {
        int ar[] = {2, 3, -1, 6, 6};
        int max = 0;
        int min = 0;
        for (int i = ar[0]; i < ar.length; i++) {
            if (i > max) {
                max = ar[i];
            }
            for (int x = ar[0]; i < ar.length; i++) {
                if (x < min) {
                    min = ar[i];
                }
                System.out.println(max);
                System.out.println(min);
            }
        }
    }
}

