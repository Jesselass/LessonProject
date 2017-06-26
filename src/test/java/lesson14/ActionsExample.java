package lesson14;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class ActionsExample extends BrowserFactory {
    @Test
    public void activnost() throws InterruptedException{
        driver.get("http://imdb.com");
        WebElement elem = driver.findElement(By.cssSelector("#consumer_main_nav #navTitleMenu"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).perform();
        Thread.sleep(4000);
    }
}
