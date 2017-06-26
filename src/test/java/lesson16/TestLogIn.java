package lesson16;

import core.BrowserFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MainPage;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public class TestLogIn extends BrowserFactory {

    MainPage mainPage = new MainPage();

    @Test
    public void tryToLogIn(){

    mainPage.open();
    mainPage.loginForm.login("gendolf2008@gmail.com","qi2d1g");

}

}
