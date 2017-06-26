package lesson9;

/**
 * Created by Dell-SSD on 15.05.2017.
 */
public class Movie implements Comparable  {
    public Movie (String name, double score){
        this.score = score;
        this.name = name;
    }
    public double score;

    @Override
    public String toString() {
        return "Movie{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    public String name;
    @Override
    public int compareTo(Object o){
        Movie m =(Movie)o;
        return (score<m.score)?-1:(score==m.score)?0:1;
    }

}
