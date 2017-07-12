package workjob;

import core.BrowserFactory;
import core.EmailUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import workTest.SearchInfo;
import workjob.preTest.JumpToProject;
import workjob.preTest.LogIn;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class SearchTest extends hw.LogIn {

    @Test(enabled = false)
    @DataProvider(name = "projectHashes")
    public static Object[][] projectHashes() {
        return new Object[][]{
                {"_rIinXgxjuddAUKNK74nw2ae5gHSoXuo"},

        };
    }

    @Test(priority = 1, dataProvider = "projectHashes")

    public void tryToGetSearch(String hash) throws EmailException, InterruptedException {


        driver.get("https://devt.onthe.io/" + hash);

        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("[data-title='Site search']")).click();
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td  [data-name = search_items_null_number]")));
        driver.findElement(By.cssSelector("td  [data-name = search_items_null_number]")).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".table_report_slice"))));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".table_report_slice"), 6));

        List<WebElement> elements = driver.findElements(By.cssSelector(".table_report_slice"));
        List<SearchInfo> searchResults = new ArrayList<>();

        for (WebElement element : elements) {

            element.findElement(By.cssSelector("td:nth-child(4)")).getText();

            SearchInfo searchInfo = new SearchInfo();
            searchInfo.title = element.getAttribute("data-title");
            searchInfo.nullSearchValue = Integer.valueOf(element.findElement(By.cssSelector("td:nth-child(4)")).getText().replace(" ", ""));
            searchInfo.transitionsToPage = Integer.valueOf(element.findElement(By.cssSelector("td:nth-child(6)")).getText().replace(" ", ""));
            searchInfo.addToBasket = Integer.valueOf(element.findElement(By.cssSelector("td:nth-child(7)")).getText().replace(" ", ""));

            if (!searchInfo.title.equals("Summary")) {
                searchResults.add(searchInfo);
            }
        }
        for (SearchInfo searchResult : searchResults) {
            System.out.println(searchResult);
            System.out.println("");
        }
        SoftAssert softAssert = new SoftAssert();

        for (SearchInfo searchResult : searchResults) {
            if (searchResult.getNullSearchValue() > 0) {
                softAssert.assertEquals(searchResult.getTransitionsToPage(), 0,
                        "В отчете ошибка, поисковой запрос " + searchResult.getTitle() + " является нулевым, но имеет выдачу");
                softAssert.assertEquals(searchResult.getAddToBasket(),
                        0, "В отчете ошибка, поисковой запрос " + searchResult.getTitle() + " является нулевым, но имеет добавления в корзину");
            }
            //softAssert.assertAll();
        }
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            EmailUtils emailUtils = new EmailUtils();
            emailUtils.sendEmail("Ошибка в поисках " + driver.getTitle(), e.getMessage(), "krav@onthe.io");
        }


    }
}

