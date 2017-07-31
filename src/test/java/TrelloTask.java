import core.AllureUtils;
import core.BrowserFactory;
import core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Dell-SSD on 31.07.2017.
 */
public class TrelloTask extends BrowserFactory {
    @Test
    @Parameters({"email", "pass"})
    public void logIn(String userEmail,String pass) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        get("https://trello.com/");
        driver().findElement(By.cssSelector(".global-header-section-button")).click();
        driver().findElement(By.cssSelector("#user")).clear();
        driver().findElement(By.cssSelector("#user")).sendKeys(userEmail);
        driver().findElement(By.cssSelector("#password")).clear();
        driver().findElement(By.cssSelector("#password")).sendKeys(pass);
        driver().findElement(By.cssSelector(".button-green")).click();
        wait.until(ExpectedConditions.urlToBe("https://trello.com/"));

        Assert.assertTrue(driver().getTitle().equals("* Доски | Trello"),"LogIn DONE");
    }
    @Test (dependsOnMethods = "logIn")
    public void createList (){
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        List<WebElement> boards = driver().findElements(By.cssSelector(".board-tile-details-name"));
        for (WebElement board:boards) {
            if(board.getText().equals("TestBoard")){
                board.click();
            }
        }
        wait.until(ExpectedConditions.urlToBe("https://trello.com/b/pYbUadku/testboard"));
        driver().findElement(By.cssSelector(".placeholder")).click();
        driver().findElement(By.cssSelector(".list-name-input")).sendKeys("NewList");
        String check = driver().findElement(By.cssSelector("[aria-label=NewList]")).getText();

        Assert.assertTrue(check.equals("NewList"));

    }

}
