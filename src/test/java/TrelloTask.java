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
import trelloApi.TrelloApiClient;
import trelloApi.models.Board;
import trelloApi.models.TrelloCard;

import java.io.IOException;
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
       WebElement element = driver().findElement(By.cssSelector(".js-save-edit"));
        wait.until(ExpectedConditions.stalenessOf(element));
        element.click();
        String check = driver().findElement(By.cssSelector("[aria-label=NewList]")).getText();

        Assert.assertTrue(check.equals("NewList"),"LIST CREATION FAILED");

    }

    @Test (dependsOnMethods = "createList")
    public void createCard(){
        driver().findElement(By.cssSelector(".open-card-composer")).click();
        driver().findElement(By.cssSelector(".js-card-title")).sendKeys("azaza karto4ka");
        driver().findElement(By.cssSelector(".js-add-card")).click();
        String check = driver().findElement(By.cssSelector(".list-card-title")).getText();
        Assert.assertTrue(check.equals("azaza karto4ka"),"CARD CREATION FAILED");
    }
    @Test(dependsOnMethods = "createCard")
    public void commentCard(){
        driver().findElement(By.cssSelector(".list-card-details")).click();
        driver().findElement(By.cssSelector(".comment-box-input")).sendKeys("TOP COMMENT EVER");
        driver().findElement(By.cssSelector(".js-add-comment")).click();
        driver().findElement(By.cssSelector(".js-close-window")).click();
        String check = driver().findElement(By.cssSelector(".badge-text")).getText();

        Assert.assertTrue(check.equals("1"));
    }

    @Test (dependsOnMethods = "commentCard")
    public void deleteCard() throws IOException {
        driver().findElement(By.cssSelector(".ui-droppable .js-card-menu")).click();
        List<WebElement> cardText = driver().findElements(By.cssSelector(".quick-card-editor-buttons-item-text"));
        for (WebElement text:cardText ) {
            if (text.getText().equals("Архивировать")){
                text.click();
            }
        }
        String boardId = "pYbUadku";
        String idList = "59453dfb8b7226ede631b2a1";
        TrelloApiClient trelloApiClient = new TrelloApiClient();
        List<TrelloCard> checkeer = trelloApiClient.getAllCards(idList);
        System.out.println(checkeer.size());
        Assert.assertTrue(checkeer.size()==0,"ALL CARDS REMOVED");
    }
}
