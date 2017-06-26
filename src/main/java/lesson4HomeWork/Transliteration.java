package lesson4HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dell-SSD on 16.04.2017.
 */
public class Transliteration {
    public static void main(String[] args) {
       String [] ru  = {"а","б","в","г","д","е","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ы","ь","э","ю","я"};
       String [] en  = {"a","b","v","g","d","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","kh","ts","ch","sh","shch","y","'","ye","yu","ya"};

        String slovo = "Привет";
        String translit = "";
         char[] rus = slovo.toCharArray();
       // char[] eng = en.toCharArray();

        //Scanner ch = new Scanner(System.in);
        //String ch1 = ch.nextLine();
        //System.out.println(ch1);
        for (int i = 0; i<ru.length; i ++){
          //  if (rus[i].equals(ru[i])){
               translit = translit + en[i];
            }
        }
       // System.out.println(translit);
        //  Arrays.equals(rus , eng);

      }









