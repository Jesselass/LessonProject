package lesson14;


import core.BrowserFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class ScreenShotExample extends BrowserFactory {
    @Test
    public void testTakeScreen () throws IOException{
        driver.get("https://google.com");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:/Desktop/12345.png"));

    }
}
