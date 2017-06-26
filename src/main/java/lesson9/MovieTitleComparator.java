package lesson9;

import java.util.Comparator;

/**
 * Created by Dell-SSD on 15.05.2017.
 */
public class MovieTitleComparator implements Comparator<Movie>{
    @Override
    public int compare (Movie o1, Movie o2){
        return o1.name.compareTo(o2.name);
    }
}
