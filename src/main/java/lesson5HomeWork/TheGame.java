package lesson5HomeWork;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dell-SSD on 02.05.2017.
 */
public class TheGame {
    public static void main(String[] args) {
        Random randNumber = new Random();
        int programm = randNumber.nextInt(101);
        System.out.println("Введите число от 0 до 100");
        Scanner number = new Scanner(System.in);
        String numb = number.nextLine();
        int player = Integer.valueOf(numb);
        int computer = randNumber.nextInt(101);
        int play = programm - player;
        int comp = programm - computer;
        play = Math.abs(play);
        comp = Math.abs(comp);
        if (player>100){

        }
        else if (player<0){

        }
        else if (play<comp){

        }
        else if (comp<play){

        }
        else {
           
        }

    }
}
