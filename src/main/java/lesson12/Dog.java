package lesson12;

/**
 * Created by Dell-SSD on 24.05.2017.
 */

    public class Dog extends Pet {
        @Override
        public void voice(){
            System.out.println("Woof Woof");
            isHungry = true;
        }
        @Override
        public void move(){
            if(isHungry){
                System.out.println("I need food");
                return;
            }
            System.out.println("OK I will walk a little");
        }
    public static void main(String[] args) {
        Pet myPuppy = new Dog();
        myPuppy.move();
    }
    }

