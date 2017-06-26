package lesson14;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class ListenerExample extends BrowserFactory {

   @Test

    public void testIt(){
       driver.get("https://google.com");
       driver.findElement(By.cssSelector("html body"));
   }



}
