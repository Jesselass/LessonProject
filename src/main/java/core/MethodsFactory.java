package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dell-SSD on 07.06.2017.
 */
public class MethodsFactory {
    protected static WebDriver driver;

    public static WebDriver driver(){
        return driver;
    }

    protected WebDriverWait getWebDriverWait(long timeout){
        return new WebDriverWait(driver(),timeout);
    }
    public void get(String url){
        driver().get(url);
        getWebDriverWait(WaitTime.DEFAULT_ELEMENT_WAIT).until(CustomConditions.pageLoaded());
    }

    public void title(){
        System.out.println(driver.getTitle());

    }

}
