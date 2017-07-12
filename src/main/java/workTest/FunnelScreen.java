package workTest;

import core.EmailUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 04.07.2017.
 */
public class FunnelScreen extends hw.LogIn{


    @Test(enabled = false)
    @DataProvider(name = "projectHashes")
    public static Object[][] projectHashes() {
    return new Object[][]{
          {"GYet4MWSoD6oaVtatcEl7gWYjpgV944P"},

          };



    }
@Test( priority = 1, dataProvider = "projectHashes")
    public void getFunnelShots(String hash) throws IOException, InterruptedException {
        driver().get("https://nt.onthe.io/"+hash);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-title='products_funnel']")));
    driver().findElement(By.cssSelector("[data-title='products_funnel']")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(".table"))));


    List<WebElement> elements = driver().findElements(By.cssSelector(".slices_groups_container ul li"));
    List<String> valuesOfAttr = new ArrayList<>();
    for (WebElement element : elements ) {
        String attr = element.getAttribute("data-group");
        valuesOfAttr.add(attr);
    }
    System.out.println(valuesOfAttr);

   Actions actions = new Actions(driver());
    for (String value :valuesOfAttr) {
        WebElement table = driver().findElement(By.cssSelector(".table"));
        driver().findElement(By.cssSelector(".slices_groups_container")).click();
        WebElement element = driver().findElement(By.cssSelector("[data-group="+value+"]"));
        actions.moveToElement(element).click().perform();
        wait.until(ExpectedConditions.stalenessOf(table));

        File screen = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File("C:\\Users\\Dell-SSD\\Desktop\\ScreenFun\\"+value+".png"));

    }


}


}
