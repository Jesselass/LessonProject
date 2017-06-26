package lesson10;

/**
 * Created by Dell-SSD on 17.05.2017.
 */
public class FinallyExample {
    public static void procA(){
        try{
            System.out.println("Inside procA");
            throw new RuntimeException("demo");

        }finally {
            System.out.println("procA's finally");
        }
    }

    public static void main(String[] args) {
        procA();
    }
}

