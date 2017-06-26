package lesson4;

/**
 * Created by Dell-SSD on 12.04.2017.
 */
public class ReturnEx {
    public static int sum(int a, int b) {
        int result = a+b;
        return result;
    }

    public static void main(String[] args) {
        int sum = sum(4,5);
        System.out.println(sum);
    }
}
