import core.AllureUtils;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
}
