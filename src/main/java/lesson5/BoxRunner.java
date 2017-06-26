package lesson5;

/**
 * Created by Dell-SSD on 19.04.2017.
 */
public class BoxRunner {
    public static void main(String[] args) {
        Box mybox = new Box(); // создание обьекта mybox класса Box
        Box cube = new Box();  // создать обьект cube класса Box
        Box parallelepiped = new Box(); // создать обьект ...

        cube.depth = 10;
        cube.height = 10;
        cube.width = 10;

        parallelepiped.width = 10;
        parallelepiped.height = 20;
        parallelepiped.depth = 15;


        cube.volume();
        parallelepiped.volume();
    }
}
