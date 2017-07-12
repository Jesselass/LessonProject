package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import trelloApi.TrelloApiClient;
import trelloApi.models.Board;
import trelloApi.models.TrelloList;

import java.io.IOException;

import static org.openqa.selenium.Keys.*;

/**
 * Created by Dell-SSD on 03.07.2017.
 */
public class TheGame2048 extends BrowserFactory {
    public String getResult() {
        Elem result = new Elem(By.cssSelector(".score-container"), "Result bar");
        String finalScore = result.getText();
        return finalScore;

    }

    @Test
    public void gameResult() throws IOException {
        driver().get("http://2048game.com/ru/");
        Elem result = new Elem(By.cssSelector(".score-container"), "Result bar");
        WebElement body = driver().findElement(By.cssSelector(".game-container"));
        Actions builder = new Actions(driver());


        while (driver().findElements(By.cssSelector(".twitter-share-button")).isEmpty()) {

            for (int i = 0; i < 10 ; i++) {
                builder.sendKeys(ARROW_UP).perform();
                builder.sendKeys(ARROW_RIGHT).perform();
                if(i==9){
                    builder.sendKeys(ARROW_LEFT);
                }

            }




            }
        String finalScore = getResult();
        System.out.println(finalScore);
        TrelloApiClient apiClient = new TrelloApiClient();
        Board board = apiClient.getBoard();
        String idList = "595a8418aafa45255a425900";
        apiClient.createCard(finalScore,idList);


        }
    }
