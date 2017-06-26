package lesson9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dell-SSD on 15.05.2017.
 */
public class MovieRun {
    public static void main(String[] args) {
        List<Movie>list = new ArrayList<>();
        list.add(new Movie("A film",2.4));
        list.add(new Movie("B film", 2.1));
        //list add(.....)
       // Collections.sort(list);
       // System.out.println(list);
       /* Collections.sort(list, new MovieTitleComparator());
        System.out.println(list);*/ //По названию
        Collections.sort(list,new MovieScoreComparator());
        System.out.println(list); //По оценке9
    }
}
