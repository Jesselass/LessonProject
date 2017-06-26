package lessson9HomeWork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dell-SSD on 17.05.2017.
 */
public class CatDogSolution {

    public static void main(String[] args) {

        Set<Cat> cats = createCats();

        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);

        removeCats(pets, cats);


        printPets(pets);

    }


    public static Set<Cat> createCats() {
        //Ваш код
        Set<Cat> catList = new HashSet<>();
        Cat cat1 = new Cat("Johny");
        catList.add(cat1);
        Cat cat2 = new Cat("Billy");
        catList.add(cat2);
        Cat cat3 = new Cat("Barkley");
        catList.add(cat3);
        Cat cat4 = new Cat("Krista");
        catList.add(cat4);



        return catList;


    }

    public static Set<Dog> createDogs() {
        //Ваш код
        Set<Dog> dogList = new HashSet<>();
        Dog dog1 = new Dog ("Colly");
        dogList.add(dog1);
        Dog dog2 = new Dog ("Sandy");
        dogList.add(dog2);
        Dog  dog3 = new Dog ("Mikey");
        dogList.add(dog3);

        return dogList;
    }

        public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
            //Ваш код
            Set<Object> allPets = new HashSet<Object>();
            allPets.addAll(cats);
            allPets.addAll(dogs);
            return allPets;

        }

       public static void removeCats(Set<Object> pets, Set<Cat> cats) {
            //Ваш код
           pets.removeAll(cats);

        }

       public static void printPets(Set<Object> pets) {
            //Ваш код
           ArrayList<Object> printVersion = new ArrayList<Object>();
           printVersion.addAll(pets);
           Object [] printed = printVersion.toArray();
           for (int i = 0; i < printed.length; i++) {
               System.out.println(printed[i]);
           }

           }






    public  static class Cat {
        String name;

        Cat(String n) {
            name = n;
        }

        @Override
        public String toString() {
            return "Car{" +
                    name +
                    '}';


        }
    }
        public static class Dog {
            String name;

            Dog(String n) {
                name = n;
            }

            @Override
            public String toString() {
                return "Dog{" +
                        name +
                        '}';


            }

        }


    }