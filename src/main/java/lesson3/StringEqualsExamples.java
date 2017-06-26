package lesson3;

/**
 * Created by Dell-SSD on 10.04.2017.
 */
public class StringEqualsExamples {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String sameStr = str1;

        boolean b1 = str1==str2; //b1 - false;
        boolean b2 = str1.equals(str2); // b2 - true;
        boolean b3 = str1 == sameStr; // b3 - true;

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
