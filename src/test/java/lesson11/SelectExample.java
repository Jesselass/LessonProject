package lesson11;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 22.05.2017.
 */
public class SelectExample extends BrowserFactory{

    @Test
    public void testSelect() throws InterruptedException{
        driver.get("http://www.imdb.com/chart/top");
        Select select = new Select(driver.findElement(By.cssSelector(".lister-sort-by")));
        select.selectByIndex(2);

    }
    @Test
    public void testElemInteraction(){
        driver.get("http://www.imdb.com/chart/top");
        WebElement searchField = driver.findElement(By.cssSelector("#navbar-query"));
        searchField.clear();
        searchField.sendKeys("Побег из Шоушенка");
        WebElement searchBtn = driver.findElement(By.cssSelector(""));

    }
}
