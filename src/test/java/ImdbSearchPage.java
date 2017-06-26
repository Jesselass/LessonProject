import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dell-SSD on 24.05.2017.
 */
public class ImdbSearchPage implements SearchPage {
   private WebDriver driver;
   public ImdbSearchPage(WebDriver driver){
       this.driver = driver;
   }

    @Override
    public void inputText(String text) {
       driver.findElement(By.cssSelector("#navbar-query")).clear();
       driver.findElement(By.cssSelector("#navbar-query")).sendKeys(text);


    }

    @Override
    public void submit() {
       driver.findElement(By.cssSelector("#navbar-submit-button")).click();
        System.out.println(driver.getTitle());

    }

    @Override
    public void open() {
        driver.get("http://www.imdb.com");
    }
}
