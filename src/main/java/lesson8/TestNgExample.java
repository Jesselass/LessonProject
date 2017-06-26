package lesson8;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static lesson1.SearchGoogle.driver;

/**
 * Created by Dell-SSD on 10.05.2017.
 */
public class TestNgExample {
     @BeforeTest
    public void beforeTest(){
       driver  = new ChromeDriver();
       driver.manage().window().maximize();
     }
    @Test
    public void aTest(){
        System.out.println("RESULT OF A");
        //This is a Test method
    }
    public  void bTest(){
        //This is not a Test method
    }
    @Test
    public void cTest(){
        System.out.println("C test");
        driver.get("http://www.cskashop.ru/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void dTest(){
        System.out.println("d test result");
        driver.get("http://www.niceprice62.ru/");
        System.out.println(driver.getTitle());

    }
    @AfterTest
    public void affterTest(){
        driver.quit();
    }
}
