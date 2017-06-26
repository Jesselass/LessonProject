package lesson11;

import core.BrowserFactory;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 22.05.2017.
 */
public class NavigationExample extends BrowserFactory {
    @Test
    public void testBrowserNavigation(){
        driver.get("http://google.com");
        driver.get("http://facebook.com");
        System.out.println("CURRENT URL: "+  driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("AFTER.back()URL: " + driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("AFTER .forward() URL : " + driver.getCurrentUrl());
    }
}