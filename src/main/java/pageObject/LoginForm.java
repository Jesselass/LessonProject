package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public abstract class LoginForm extends MethodsFactory {
    protected abstract void typeLogin(String login);
    protected abstract void typePassword(String password);
    protected abstract void clickSubmit();
    public void login(String login, String password){
        typeLogin(login);
        typePassword(password);
        clickSubmit();
        getWebDriverWait(10).until(ExpectedConditions.urlContains("com/u"));
    }
}
