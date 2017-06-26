package lesson5HomeWork;

import java.util.Scanner;

/**
 * Created by Dell-SSD on 02.05.2017.
 */
public class StringCompare {
    public static void main(String[] args) {
        System.out.println("1.Cравнить строки на равенство");
        System.out.println("2.Сравнить строки без учета регистра");
        System.out.println("3.Сравнить строки без учета пробелов между буквами|словами");
        Scanner choise = new Scanner(System.in);
        String choi = choise.nextLine();
        int num = Integer.valueOf(choi);
        System.out.println("Введите 1 строку");
        Scanner str1 = new Scanner(System.in);
        String str = str1.nextLine();
        System.out.println("Введите 2 строку");
        Scanner str2 = new Scanner(System.in);
        String strN = str2.nextLine();
        if (num == 1) {
            if (str.equals(strN)){
                System.out.println("Cтроки равны");
            }
            else {
                System.out.println("Строки не равны");
            }
        }
        else if (num == 2){
            if (str.equalsIgnoreCase(strN)){
                System.out.println("Строки равны");
            }
            else {
                System.out.println("Строки не равны");
            }
        }
       else if (num == 3) {
            str = str.replace(" ","");
            strN = strN.replace(" ","");
            if (str.equals(strN)){
                System.out.println("Cтроки равны");
            }
            else {
                System.out.println("Строки не равны");
            }
        }
    }
}
