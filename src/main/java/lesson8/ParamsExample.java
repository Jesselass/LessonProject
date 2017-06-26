package lesson8;

import core.BrowserFactory;
import hw.UserId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Dell-SSD on 10.05.2017.
 */

public class ParamsExample extends BrowserFactory {

    /*public  WebDriver kissmia ;
    @BeforeSuite
    public void beforeSuite(){
        kissmia = new ChromeDriver();
        kissmia.manage().window().maximize();
        kissmia.get("https://kismia.com");

    }*/

    @Test(priority = 1)
    @Parameters({"email", "pass"})
    public void paramsEx(String email, String pass) {
        driver.get("https://kismia.com");
        driver.findElement(By.xpath("//*[@id='user-email']")).clear();
        driver.findElement(By.xpath("//*[@id='user-email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='user-password']")).clear();
        driver.findElement(By.xpath("//*[@id='user-password']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@class='submit']")).click();


        System.out.println("EMAIL:" + email);
        System.out.println("PASS:" + pass);


    }

    @Test(priority = 2)
    @Parameters({"ageFrom", "ageTo"})
    public void ageParamSet(String ageFrom, String ageTo)  {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".new-header__photo")));
        driver.findElement(By.cssSelector(".new-header__photo")).click();
        driver.findElement(By.cssSelector("a[href*='settings']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name*='age_to']")));
        Select selectAgeFrom = new Select(driver.findElement(By.cssSelector("select[name*='age_from']")));
        selectAgeFrom.selectByVisibleText(ageFrom);
        Select selectAgeTo = new Select(driver.findElement(By.cssSelector("select[name*='age_to']")));
        selectAgeTo.selectByVisibleText(ageTo);

        //driver.findElement(By.cssSelector("select[name*='age_from']")).click();

       // driver.findElement(By.cssSelector("select[name*='age_from']")).sendKeys(ageFrom);
       // driver.findElement(By.cssSelector("select[name*='age_from']")).click();
       // driver.findElement(By.cssSelector("select[name*='age_to']")).click();
       // driver.findElement(By.cssSelector("select[name*='age_to']")).sendKeys(ageTo);
       // driver.findElement(By.cssSelector("select[name*='age_to']")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='flat-green js_save']")));
        driver.findElement(By.cssSelector("div.settings-path.active > div.settings-button-block.settings-button-block--blue.js_saveBlock > button")).click();

    }

    @Test(priority = 3)
    @Parameters({"likeAmount","ageFrom","ageTo"})
    public void acquaintanceGame(int likeAmount,int ageFrom, int ageTo) {
        driver.findElement(By.cssSelector("a[class*='new-header-main-nav__link new-header-main-nav__link--matches']")).click();
        List<String> userIds = new ArrayList<>();
        do {
            WebElement element = driver.findElement(By.cssSelector("input[name='user_id']"));
            String userId = "";
            userId = element.getAttribute("value");
            userIds.add(userId);

            driver.findElement(By.cssSelector("button[name='answer']")).click();

        } while (userIds.size() < likeAmount);
        System.out.println(userIds);
        Map <String,Integer> userMap = new LinkedHashMap<String,Integer>();
        Integer value = 1;
        for (String userId: userIds ) {
            userMap.put(userId,value);
        }
        System.out.println(userMap);
        //Set<String> uniqueUserIds = new HashSet<>();
        //uniqueUserIds.addAll(userIds);
        //System.out.println(uniqueUserIds);

        /*try{
        assertEquals(uniqueUserIds.size(),userIds.size(),"Повторы случаются");
        }catch (AssertionError e) {
            System.out.println(e.getMessage());
        }*/
        List<String>inAgeBorders = new ArrayList<>();
        List<String>outOfAgeBorders = new ArrayList<>();

        for (String userId :userIds ) {
            driver.get("http://kismia.com/u"+userId);
            String profileInfo = "";

            WebElement element = driver.findElement(By.cssSelector(".profile-page__user-short-info"));
            profileInfo = element.getText();
            profileInfo = profileInfo.trim();
            profileInfo = profileInfo.substring(0,2);
            int userAge = Integer.valueOf(profileInfo);
            System.out.println("Возраст пользователя " + userAge);
            if (userAge>=ageFrom && userAge<=ageTo){
                System.out.println("Возраст в рамках заданых параметров " + ageFrom + " - " + ageTo);
                inAgeBorders.add(userId);
            } else {
                System.out.println("Возраст вне заданных параметров " + ageFrom + " - " + ageTo);
                outOfAgeBorders.add(userId);
            }


        }
        System.out.println("Кол-во анкет с возрастом вне заданных параметров = " + outOfAgeBorders.size() );
        System.out.println("Кол-во анкет с возрастом в пределах заданных параметров = " + inAgeBorders.size());
     /*@Test(priority = 2)
    public void acquaintanceGame (){
        kissmia.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
        kissmia.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        kissmia.findElement(By.xpath("//*[@class='icon icon--header-sub']")).click();
        kissmia.findElement(By.xpath("//*[@href='/profile/settings']")).click();
         kissmia.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
         kissmia.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
         kissmia.findElement(By.xpath("//*[@class='settings-nav__elem js_settingsNav']")).click();
         kissmia.findElement(By.xpath("//*[@value='f']")).click();

        kissmia.findElement(By.xpath("//*[@class='button-FR settings__button button--flat-green js_save']")).click();
     }*/

    }
}
