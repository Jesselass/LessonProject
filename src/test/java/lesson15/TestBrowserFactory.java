package lesson15;

import core.BrowserFactory;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 07.06.2017.
 */
public class TestBrowserFactory extends BrowserFactory {
    @Test
    public void azaza(){
        get("http://google.com");
    }
}
