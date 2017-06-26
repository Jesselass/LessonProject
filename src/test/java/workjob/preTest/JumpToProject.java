package workjob.preTest;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class JumpToProject extends BrowserFactory {
        @Test
        public void tryToGetSearch () {
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.urlToBe("https://onthe.io/projects"));
            System.out.println(driver.getCurrentUrl());
            driver.get("https://nt.onthe.io/IaviRtTRdnBqxEo8ao58iKV6arzuXvuF");
            System.out.println(driver.getCurrentUrl());
            driver.findElement(By.cssSelector("[data-title='Site search']")).click();
            System.out.println(driver.getTitle());
        }
}
