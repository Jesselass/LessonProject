package lesson12;

/**
 * Created by Dell-SSD on 24.05.2017.
 */
    public abstract class Pet{
        protected boolean isHungry = false;
        public abstract void voice();
        public abstract void move();
        public boolean isHungry(){
            return isHungry;
        }
    }


