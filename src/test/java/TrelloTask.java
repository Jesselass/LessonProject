import core.AllureUtils;
import core.BrowserFactory;
import core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trelloApi.TrelloApiClient;
import trelloApi.models.Board;
import trelloApi.models.TrelloCard;
import trelloApi.models.TrelloList;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dell-SSD on 31.07.2017.
 */
public class TrelloTask extends BrowserFactory {
   public String boardId = "pYbUadku";
    public String listId = "";
    public TrelloApiClient trelloApiClient = new TrelloApiClient();



    @Test
    @Parameters({"email", "pass"})
    public void logIn(String userEmail,String pass)  {
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        get("https://trello.com/");
        driver().findElement(By.cssSelector(".global-header-section-button")).click();
        driver().findElement(By.cssSelector("#user")).clear();
        driver().findElement(By.cssSelector("#user")).sendKeys(userEmail);
        driver().findElement(By.cssSelector("#password")).clear();
        driver().findElement(By.cssSelector("#password")).sendKeys(pass);
        driver().findElement(By.cssSelector(".button-green")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".member-avatar")));

        Assert.assertTrue(driver().findElement(By.cssSelector(".member-avatar")).isDisplayed(),"LogIn DONE");
    }
    @Test (dependsOnMethods = "logIn")
    public void createList (){
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        List<WebElement> boards = driver().findElements(By.cssSelector(".board-tile-details-name"));
        for (WebElement board:boards) {
            if(board.getText().equals("TestBoard")){
                board.click();
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-open-add-list")));

        driver().findElement(By.cssSelector(".js-open-add-list")).click();
        driver().findElement(By.cssSelector(".list-name-input")).sendKeys("NewList");
        driver().findElement(By.cssSelector(".js-save-edit")).click();

        String check = driver().findElement(By.cssSelector("[aria-label=NewList]")).getText();

        Assert.assertTrue(check.equals("NewList"),"LIST CREATION FAILED");

    }

    @Test (dependsOnMethods = "createList")
    public void createCard() throws IOException {
        driver().findElement(By.cssSelector(".open-card-composer")).click();
        driver().findElement(By.cssSelector(".js-card-title")).sendKeys("azaza karto4ka");
        driver().findElement(By.cssSelector(".js-add-card")).click();
        String check = driver().findElement(By.cssSelector(".list-card-title")).getText();
        List<TrelloList> resp = trelloApiClient.getBoardLists(boardId);
        listId = resp.get(0).id;

        Assert.assertTrue(check.equals("azaza karto4ka"),"CARD CREATION FAILED");
    }
    @Test(dependsOnMethods = "createCard")
    public void commentCard(){
        driver().findElement(By.cssSelector(".list-card-details")).click();
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-new-comment-input")));

        driver().findElement(By.cssSelector(".js-new-comment-input")).sendKeys("TOP COMMENT EVER");
        driver().findElement(By.cssSelector(".js-add-comment")).click();
        driver().findElement(By.cssSelector(".js-close-window")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".badge-text")));
        String check = driver().findElement(By.cssSelector(".badge-text")).getText();

        Assert.assertTrue(check.equals("1"));
    }

    @Test (dependsOnMethods = "commentCard")
    public void deleteCard() throws IOException{
        Actions actions = new Actions(driver());
        WebElement cardBlock = driver().findElement(By.cssSelector(".ui-droppable"));
        WebElement menuBlock = driver().findElement(By.cssSelector(".icon-edit"));
        actions.moveToElement(cardBlock).moveToElement(menuBlock).click().perform();
       // driver().findElement(By.cssSelector(".ui-droppable.js-card-menu")).click();
        List<WebElement> cardText = driver().findElements(By.cssSelector(".quick-card-editor-buttons-item-text"));
        for (WebElement text:cardText ) {
            if (text.getText().equals("Архивировать")){
                text.click();
            }
        }

        List<TrelloCard> checkeer = trelloApiClient.getAllCards(listId);

        Assert.assertTrue(checkeer.isEmpty(),"ALL CARDS REMOVED");
    }
}
