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
            System.out.println("Вы ввели число вне диапазона, будьте внимательны");
        }
        else if (player<0){
            System.out.println("Вы ввели число вне диапазона, будьте внимательны");
        }
        else if (play<comp){
            System.out.println("Player wins!!" + "Программа = " + programm + ", Игрок =  " + player + ", Компьютер 1 = " +computer);
        }
        else if (comp<play){
            System.out.println("Computer wins!!!" + "Программа = " + programm + ", Игрок =  " + player + ", Компьютер 1 = " +computer);
        }
        else {
            System.out.println("Draw" + "Программа = " + programm + ", Игрок =  " + player + ", Компьютер 1 " +computer);
        }

    }
}
