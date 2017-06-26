import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dell-SSD on 24.05.2017.
 */
public class KinopoiskSearchPage implements SearchPage {
    private WebDriver driver;
    public KinopoiskSearchPage(WebDriver driver){
        this.driver = driver;
    }


    @Override
    public void inputText(String text) {
        driver.findElement(By.cssSelector("#search_input")).clear();
        driver.findElement(By.cssSelector("#search_input")).sendKeys(text);


    }

    @Override
    public void submit() {
        driver.findElement(By.cssSelector(".searchButton2")).click();
        System.out.println(driver.getTitle());


    }

    @Override
    public void open() {
        driver.get("http://www.kinopoisk.ru");
    }
}


