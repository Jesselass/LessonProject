package lesson10;

/**
 * Created by Dell-SSD on 17.05.2017.
 */
public class ExceptionsStyle {
    public static void main(String[] args) {
        int result = 5;

        try {
            System.out.println(result/0);
        } catch (ArithmeticException e){
            System.out.println("Cant calculate this form");
            System.out.println(e.getMessage());
        }
    }
}
