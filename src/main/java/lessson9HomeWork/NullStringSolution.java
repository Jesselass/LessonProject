package lessson9HomeWork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 21.05.2017.
 */
public class NullStringSolution {
    /*
Задача: Вводить с клавиатуры строки до тех пор пока не будет введена пустая строка, после чего вывести строки в отсортированном порядке (алфавитном)
*/

        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            List<String> list = new ArrayList<>();
            String a ;
            a = "";

            String s = "";
            while (true) {
                s = reader.readLine();
                //  a = a + reader.readLine() + ",";
                if (s.isEmpty()) {
                    break;
                }
                list.add(s);
                // a = a;

            }

            System.out.println(list);


            //заполните список строками при помощи reader.readLine();

           // sort(list); //метод для сортировки списка

            //вывести список в отсортированном порядке
        }

       /* public static void sort(List<String> list) {
            //реализуйте свой алгоритм сортировки списка при помощи  метода isGreaterThan(String a, String b)
        }

        //Метод для сравнения строк: 'а' больше чем 'b'
        public static boolean isGreaterThan(String a, String b)
        {
            return a.compareTo(b) > 0;
        }*/
    }

