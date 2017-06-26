package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



/**
 * Created by Dell-SSD on 10.04.2017.
 */
public class Akinator {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("http://ru.akinator.com/");
        String start = driver.findElement(By.xpath("//*[@id='bulle-inner']")).getText();
        System.out.println(start);
        System.out.println("Введите Go, для того что бы начать игру");
        Scanner begin = new Scanner(System.in);
        String str1 = begin.nextLine();
        String str2 = "Go";
        if (str1.equals(str2)) {
            driver.findElement(By.xpath("//*[@class='rouge']")).click();
        } else {
            System.out.println("Мы так никогда не начнем играть!!! Следуй правилам!!!");
        }
        String age = driver.findElement(By.xpath("//*[@id='bulle-inner']")).getText();
        System.out.println(age);
        System.out.println("Введи свой возраст, реальный возраст:");
        Scanner step2 = new Scanner(System.in);
        String number = step2.nextLine();
        driver.findElement(By.xpath("//*[@id='elokence_sitebundle_identification_age']")).sendKeys(number);
        int value = Integer.valueOf(number);
        if (value <= 100) {
            System.out.println("Ты в самом расцвете сил!!!");
            driver.findElement(By.xpath("//*[@value='Играть']")).click();
        } else {
            System.out.println("Мелкий засранец!!! Люди столько не живут!!!");
        }

           while ( driver.findElements(By.xpath("//*[@id='validation-propose']")).size() ==0){
            //fString finito = driver.findElement(By.xpath("//*[@id='validation-propose']")).getText();


            String questionNumber = driver.findElement(By.xpath("//*[@id='questionNo']")).getText();
            String question = driver.findElement(By.xpath("//*[@id='bulle-inner']")).getText();
            System.out.println(questionNumber);
            System.out.println(question);
            System.out.println("Введи число от 1 до 5:");
            System.out.println("1 -'Да'");
            System.out.println("2 - 'Нет'");
            System.out.println("3 - 'Я не знаю'");
            System.out.println("4 -'Возможно частично'");
            System.out.println("5 - 'Скорее нет Не совсем'");
            Scanner step3 = new Scanner(System.in);
            String answer = step3.nextLine();
               int intAnswer = Integer.valueOf(answer);

            if (intAnswer == 1) {
                driver.findElement(By.xpath("//*[@id='reponse1']")).click();
            } else if (intAnswer == 2) {
                driver.findElement(By.xpath("//*[@id='reponse2']")).click();
            } else if (intAnswer == 3) {
                driver.findElement(By.xpath("//*[@id='reponse3']")).click();
            } else if (intAnswer == 4) {
                driver.findElement(By.xpath("//*[@id='reponse4']")).click();
            } else if (intAnswer == 5) {
                driver.findElement(By.xpath("//*[@id='reponse5']")).click();
            }
        }

                /*String finito = driver.findElement(By.xpath("//*[@id='validation-propose'")).getText();
                String person = driver.findElement(By.xpath("//*[@id='infos-perso-title']")).getText();
                String about = driver.findElement(By.xpath("//*[@id='description']")).getText();
                System.out.println(person + " " + about);
                System.out.println("Введите 1-Да; 2-Нет:") ;
                Scanner finish = new Scanner(System.in);
                String yes = finish.nextLine();
                String resultyes = "Да";
                String resultno = "Нет";*/




        //driver.findElement(By.xpath("//*[@id='validation-propose'"));

        //driver.findElement(By.xpath("//*[@id='pseudo_emetteur']")).getText();


        String person = driver.findElement(By.xpath("//*[@id='infos-perso-title']")).getText();
        String about = driver.findElement(By.xpath("//*[@id='description']")).getText();
        System.out.println(person + " " + about);
        System.out.println("Введите 1-Да; 2-Нет:");
        Scanner finish = new Scanner(System.in);
        String yes = finish.nextLine();
        String resultyes = "1";
        String resultno = "2";


        if ((resultyes.equals(yes))) {
            driver.findElement(By.xpath("//*[@id='yesLink']")).click();
            String akinatorWin = driver.findElement(By.xpath("//*[@id='bulle-inner']")).getText();
            System.out.println(akinatorWin);
        } else if (resultno.equals(yes)) {
            driver.findElement(By.xpath("//*[@id='noLink']")).click();
            System.out.println("Ты победил");
            }




            //driver.findElement(By.xpath("//*[@id='photo']")).getLocation();



    }


}