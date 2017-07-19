import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Dell-SSD on 19.07.2017.
 */
public class Test1 {
    @Test
    public void azaza(){
        sendEmail();
        logIn();
        sendEmail();
        logIn();

    }
    @Test
    public void atata(){
        logIn();
        sendEmail();
        Assert.assertTrue(false,"VSIO PROPALO");
    }
    @Step("Почта")
    public void sendEmail(){

    }

    @Step ("LogIn")
    public void logIn(){


    }
}
