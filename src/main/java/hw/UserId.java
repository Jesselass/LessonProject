package hw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 05.06.2017.
 */
public class UserId {
    public String userId;

    @Override
    public String toString() {
        return "UserId{" +
                "userId='" + userId + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String x = "%20AZAZA%20";
        String s = "AZAZATOVAR";
       String z = x.replaceAll("[^%]","");
        if (z.length()>1) {
            System.out.println(z);
            System.out.println("ENCODE");
            List<String>azaza = new ArrayList<>();
            azaza.add("asdsad");
            azaza.add("sdsdssd");
            azaza.add("sdsdsdsd");
            System.out.println(azaza.toString().substring(1,azaza.toString().length()-1));

        }
    }
}
