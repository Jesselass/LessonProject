package headfirst;

/**
 * Created by Dell-SSD on 26.05.2017.
 */
public class PoolPuzzleOne {
    public static void main(String[] args) {
        int x = 0;
        while (x < 4 ){
            //
            if (x<1){
                System.out.print("a ");
                x= x+2;
            }
            if (x>3){
                System.out.print("an");
                System.out.print(" oyster");
                x=x-2;

            }
            if (x==1){
                System.out.print("annoys");
                x=x+1;
            }
            if (x>0 ){
                System.out.print("noise");
                x = x-1;


            }
            System.out.println("");
        }
    }
}

//a noise nextline annoys nextline an oyster