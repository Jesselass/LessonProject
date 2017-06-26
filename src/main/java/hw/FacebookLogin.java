package hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by 1 on 04.04.2017.
 */
public class FacebookLogin {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@id='email']")).clear();
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("gendolf2007@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='pass']")).clear();
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("qi2d1gjess");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@data-testid='royal_login_button']")).click();


        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.quit();




    }

}
