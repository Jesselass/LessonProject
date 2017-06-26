import core.BrowserFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Dell-SSD on 31.05.2017.
 */
public class PageLoadStrategyExample extends BrowserFactory {
    public void setCap() {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY , options);
        capabilities.setCapability("pageLoadStrategy", "none");
        driver = new ChromeDriver(capabilities);
    }
}
