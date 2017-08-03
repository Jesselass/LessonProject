package finalTest;

import core.BrowserFactory;
import core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Dell-SSD on 02.08.2017.
 */
public class PDfiller extends BrowserFactory {
    List<WebElement> fileNames = new ArrayList<>();
    public String check ="";
    @Test
    @Parameters({"email", "pass"})
    @Stories("logInStory")
    public void logIn(String email, String pass) {
        get("https://www.pdffiller.com/");
        driver().manage().window().maximize();
        driver().findElement(By.cssSelector("[href='/en/login.htm']")).click();
        driver().findElement(By.cssSelector("#form-login-email")).clear();
        driver().findElement(By.cssSelector("#form-login-email")).sendKeys(email);
        driver().findElement(By.cssSelector("#form-login-password")).clear();
        driver().findElement(By.cssSelector("#form-login-password")).sendKeys(pass);
        driver().findElement(By.cssSelector("#form-login-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mf-icon-mybox")));
        Assert.assertTrue(driver().getCurrentUrl().equals("https://www.pdffiller.com/en/forms.htm"));
    }

    @Test(dependsOnMethods = "logIn")
    public void copyFile() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mf-doc__item .checkbox")));
        Actions actions = new Actions(driver());
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".g-ibtn.i-copy.tooltipstered")));
        WebElement copyIcon = driver().findElement(By.cssSelector(".g-ibtn.i-copy.tooltipstered"));
        actions.moveToElement(copyIcon).click().perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[placeholder='Form Name']")));
        driver().findElement(By.cssSelector("[placeholder='Form Name']")).clear();
        driver().findElement(By.cssSelector("[placeholder='Form Name']")).sendKeys("CopyFile");
        driver().findElement(By.cssSelector("div >.btn.-sm.-orange")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mf-info-banner__button")));
        fileNames = driver().findElements(By.cssSelector(".mf-doc__name span"));

        for (WebElement name : fileNames) {
            if (name.getText().equals("CopyFile")) {
                check = name.getText();
            }
        }
        Assert.assertTrue(check.equals("CopyFile"));
    }

    @Test(dependsOnMethods = "copyFile")
    public void deleteFile() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".g-ibtn.i-trash-bin.tooltipstered")));
        Actions actions = new Actions(driver());
        WebElement deleteIcon = driver().findElement(By.cssSelector(".g-ibtn.i-trash-bin.tooltipstered"));
        actions.moveToElement(deleteIcon).click().perform();
        wait.until(visibilityOfElementLocated(By.cssSelector(".notification.notification-success")));
        driver().findElement(By.cssSelector(".notification.notification-success")).click();
        /* try{
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("mf-info-banner__close")));
        }catch (Exception e) {
            System.out.println(e);
        }
*/
        fileNames = driver().findElements(By.cssSelector(".mf-doc__name span"));
        for (WebElement name : fileNames) {
            if (name.getText().equals(check)) {
                check = "Element is here";
                System.out.println(check);
            }
        }

       Assert.assertFalse(check.equals("Element is here"));

    }
    @Test(dependsOnMethods = "deleteFile")
    public void logOut(){
        WebDriverWait wait = new WebDriverWait(driver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".h-ac__toggle")));
        driver().findElement(By.cssSelector(".h-ac__toggle")).click();
        driver().findElement(By.cssSelector("[href='/en/logout.htm']")).click();
        Assert.assertTrue(driver().getCurrentUrl().equals("https://www.pdffiller.com/en/login.htm?msg=logout"));
    }
}