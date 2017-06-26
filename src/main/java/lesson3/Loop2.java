package lesson3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 10.04.2017.
 */
public class Loop2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Petya");
        names.add("Kolya");
        for (String name : names){
            System.out.println(name);
        }
    }
}
