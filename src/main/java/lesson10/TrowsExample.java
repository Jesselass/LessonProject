package lesson10;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dell-SSD on 17.05.2017.
 */
public class TrowsExample {
    public static void createFile() throws IOException{
        File file = new File ("\\/.sad\\ASD");
        file.createNewFile();
    }

    public static void main (String[] args) throws IOException {
        createFile();
    }
}
