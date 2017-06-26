package lesson5;

/**
 * Created by Dell-SSD on 19.04.2017.
 */
public class StringIsImmutable {
    public static void main(String[] args) {
        String myString = "JACK";
        myString.concat(" SPARROW"); // JACK + SPARROW
        System.out.println(myString); // JACK

        myString = myString.concat(" SPARROW"); // myString = "JACK" + "SPARROW"
        System.out.println(myString);
    }
}
