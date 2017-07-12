package hw;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class LogIn extends BrowserFactory {

@Test
    public  void tryToLogIn() {
        driver.get("https://nt.onthe.io");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div>a[href*='auth']")));
        driver.findElement(By.cssSelector("div>a[href*='auth']")).click();
        driver.findElement(By.cssSelector("[name=email]")).clear();
        driver.findElement(By.cssSelector("[name=email]")).sendKeys("krav@onthe.io");
        driver.findElement(By.cssSelector("[name=pwd]")).clear();
        driver.findElement(By.cssSelector("[name=pwd]")).sendKeys("qi2d1gQI");
        driver.findElement(By.cssSelector("[style='display:inline-block;'")).click();
        //WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlToBe("https://onthe.io/projects"));
        System.out.println(driver.getCurrentUrl());
        return ;

          /*  */
    }
}
