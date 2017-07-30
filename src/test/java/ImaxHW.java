import core.AllureUtils;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.TestCaseResult;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Dell-SSD on 30.07.2017.
 */
public class ImaxHW extends BrowserFactory {
    @Test
    public void iMax(){
        get("https://planetakino.ua/showtimes/");
        driver().findElement(By.cssSelector(".filters-block__technology [href*='4dx']")).click();
        driver().findElement(By.cssSelector(".filters-block__technology [href*='relux']")).click();
        driver().findElement(By.cssSelector(".filters-block__technology [href*='cinetech']")).click();
       List<WebElement> times = driver().findElements(By.cssSelector(".p-one-day .t-imax .time "));
       WebElement element = times.get(times.size()-1);
       element.click();
       List<WebElement>freeSeat = driver().findElements(By.cssSelector(".g-element.hs-image-0000000001"));
       List<WebElement>soldSeat = driver().findElements(By.cssSelector(".g-element.hs-image-0000000005"));
       int allPlaces = freeSeat.size() + soldSeat.size();
        System.out.println(allPlaces);
        System.out.println(soldSeat.size());
        int percentOfSold = soldSeat.size()/allPlaces*100;
        System.out.println(percentOfSold);

        AllureUtils.fireAllureParameter("AllSeats", String.valueOf(allPlaces));
        AllureUtils.fireAllureParameter("PercentOfSold",String.valueOf(percentOfSold));
        Assert.assertTrue(percentOfSold>50,"SOLD OUT BIATCH");
    }
}
