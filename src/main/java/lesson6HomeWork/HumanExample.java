package lesson6HomeWork;

/**
 * Created by Dell-SSD on 02.05.2017.
 */
public class HumanExample {
    private String name;
    private String surname ;
    private int age ;
    private String gender;

    public void setName(String name) {
        this.name = name;

    }
    public String getName (String name){

        return name;
    }
    public   String human (String name, String surname, int age, String gender) {

        return "Имя " + name + " Фамилия " + surname + " Возраст " + age + " Пол " + gender;
    }




    }



