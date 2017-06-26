package workjob;

import core.BrowserFactory;
import core.EmailUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
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
                {"CAEFKY2omgw5T5cHhK8Bw08mBg9L_87C"},
                {"KsXvozgJ491bUrTgILJhCetzQGoKj0N3"},
                {"Ig847cVwntJUvoV6AVxxjwwmZsmNQYNy"},
                {"3O9eoyOyIcg9GCr_sLwtwjTFHQdrS51W"},
                {"KFneCjMVSaPSkFXpNFBgVO_rao3BSEaB"},
                {"dGDhKt4wfJcDOhylW1V70HmOrEAaYfbb"},
                {"QP2pQhg77i2k4e2TOqHjk84WwL3plGqb"},
        };
    }

    @Test(priority = 1, dataProvider = "projectHashes")

    public void tryToGetSearch(String hash) throws EmailException {


        driver.get("https://devt.onthe.io/" + hash);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("[data-title='Site search']")).click();
        System.out.println(driver.getTitle());
        // }
        //   @Test (priority = 2)
        // public void searchParse () {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".table_report_slice"), 3));
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
            emailUtils.sendEmail("Ошибка в поисках " + driver.getTitle(), e.getMessage(), "krav@onthe.io", "vadim@onthe.io");
        }


    }
}

