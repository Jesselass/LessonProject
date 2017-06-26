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
        List<String> list = new ArrayList<>();
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");
        list.add("BD-12345");


        List<Long>list2 = new ArrayList<>();
        for (String s:list) {
            list2.add(Long.parseLong(s.replaceAll("\\D","")));
        }
        System.out.println(list2);
        }
}
