package lesson6;

/**
 * Created by Dell-SSD on 24.04.2017.
 */
public class RecurseMethod {

        public static int fact ( int n){
            int result;
            if (n == 1) {
                return 1;
            }
            result = fact(n - 1) * n;
            return result;
        }

    public static void main(String[] args) {
        System.out.println(fact(10));
    }
    }
