package pageObject;

import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public class LogInFormMain extends LoginForm {
   private Elem emailFld = new Elem(By.cssSelector("#user-email"),"Email field");
   private Elem pwFld = new Elem(By.cssSelector("#user-password"),"Password field");
   private Elem submitBtn = new Elem(By.cssSelector("#sign-in-form .submit"),"Submit button");

    @Override
    protected void typeLogin(String login) {
        emailFld.type(login);
    }

    @Override
    protected void typePassword(String password) {
        pwFld.type(password);
    }

    @Override
    protected void clickSubmit() {
        submitBtn.click();
    }
}
