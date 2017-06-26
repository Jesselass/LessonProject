package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Adm on 03.04.2017.
 */
public class SearchGoogle {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://google.com.ua");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("Hello, world!");
        driver.findElement(By.cssSelector("button.sbico-c")).click();
        driver.findElement(By.cssSelector(".g h3 a[href]")).click();


        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.quit();




    }

}
