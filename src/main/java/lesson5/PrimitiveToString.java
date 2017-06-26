package lesson5;

/**
 * Created by Dell-SSD on 19.04.2017.
 */
public class PrimitiveToString {
    public static void main(String[] args) {


        int i = 15;
        double d = 20.0034;
        long l = 1111111111;
        boolean b = true;
        String aInt = String.valueOf(i);
        String bLong = String.valueOf(l);
        String cDouble = String.valueOf(d);
        String dBool = String.valueOf(b);

        System.out.println(aInt);
        System.out.println(bLong);
        System.out.println(cDouble);
        System.out.println(dBool);

        int i2 = Integer.valueOf(aInt);
        double d2 = Double.parseDouble(cDouble);
        long l2 = Long.valueOf(bLong);
        boolean b2 = Boolean.parseBoolean(dBool);

        System.out.println(i2);
        System.out.println(d2);
        System.out.println(l2);
        System.out.println(b2);
    }
}
