package lesson6;

/**
 * Created by Dell-SSD on 24.04.2017.
 */
public class TaskFirst{
    public static void main(String[] args) {
        String s = "huuh";
        char [] m = s.toCharArray();
        String reversed = "";
        for (int i = m.length-1; i>=0; i--){
            reversed = reversed + m[i];
        }
        if (reversed.equals(s)) {
            System.out.println("Cлово палиндром");
        }
         else {
            System.out.println("Cлово не палиндром");
        }
    }
}
