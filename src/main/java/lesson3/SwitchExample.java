package lesson3;

/**
 * Created by Dell-SSD on 10.04.2017.
 */
public class SwitchExample {
    public static void main(String[] args) {
        int i =2;
        switch (i){
            case 1:
                System.out.println("This is one!");
                break;
            case 2:
                System.out.println("This is two!");
                break;
                default:
                    System.out.println("This not one,not two!!");
        }
    }
}
