package lesson3;

/**
 * Created by Dell-SSD on 12.04.2017.
 */
public class Seasons {
    public static void main(String[] args) {
        int i;
        for (i=1; i<=12; i++  ){
            if (i<=2 || i == 12){
                System.out.println( i + " месяц отсносится зиме");
            }else if (i>=3 && i<=5  ){
                System.out.println( i + " месяц относится к весне");
            }else if (i>=6 && i<=8 ){
                System.out.println( i + " месяц относится к лету");
            }else {
                System.out.println( i + " месяц относится к осени");
            }

            }
        }
    }

