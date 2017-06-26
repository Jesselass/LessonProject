import core.BrowserFactory;
import core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static core.ReadAFile.fileData;
import static core.ReadAFile.getDataFromTxt;
import static core.ReadAFile.listToDataProvider;


/**
 * Created by Dell-SSD on 10.06.2017.
 */
public class ImdbHomeWork extends BrowserFactory{

    Map<String,String> starParty = new HashMap<String,String>();




    @DataProvider(name = "starsNames")
    public static Object[][] starsNames() {
        getDataFromTxt("C:/StarNames.txt");
       return listToDataProvider(fileData);

    }

    @Test (dataProvider = "starsNames", priority = 1)
   public void homeWork(String starName){
        get("http://imdb.com");
       Elem searchBar = new Elem(By.cssSelector("#navbar-query"),"Поиск");
       Elem finder = new Elem(By.cssSelector("#navbar-submit-button"),"Кнопка поиска");
       Elem starInfo = new Elem(By.cssSelector(".result_text > a[href*='name']"),"Найти страницу актера");
       Elem setInput = new Elem(By.cssSelector("[name = movie]"),"Список фильмов");
       Elem ratingScore = new Elem(By.cssSelector("[name=ir][data-value]"),"Оценка");

       searchBar.type(starName);
       finder.click();

        System.out.println(starInfo.getText());
        starInfo.click();
        Select goToFilm = new Select(driver().findElement(By.cssSelector("[name = 'sort']")));
        goToFilm.selectByVisibleText("Rating »");
        setInput.click();
        getWebDriverWait(15).until(ExpectedConditions.textToBePresentInElement(By.cssSelector(".header"),"Feature Film"));

        List<Double> scores = new ArrayList<>();
        List<WebElement> eleme = driver().findElements((By.cssSelector("[name=ir]")));
        for (WebElement elem : eleme) {

            double d = Double.valueOf(elem.getAttribute("data-value").replace(",","."));
            scores.add(d);

        }
        System.out.println(scores);

        System.out.println("Кол-во фильмов c оценками : " + scores.size());
        double sum = 0;
        double average;
        for (Double score : scores) {
            sum = sum + score;
        }
        average = sum/scores.size();
        String formatedDouble = String.format("%.2f", average).replace(",",".");
        System.out.println(formatedDouble);
        starParty.put(starName,formatedDouble);



    }
    @Test(dependsOnMethods = { "homeWork" })
    public void whoIsTopActor (){
        System.out.println(starParty);
        starParty.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                .forEach(System.out::println);

    }
    }
