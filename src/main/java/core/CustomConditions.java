package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by Dell-SSD on 07.06.2017.
 */
public class CustomConditions {


    public static ExpectedCondition pageLoaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return JsExecutor.executeScript("return document.readyState").equals("complete");
            }

        };
    }
}