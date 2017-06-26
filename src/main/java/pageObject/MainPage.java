package pageObject;

import core.MethodsFactory;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public class MainPage extends MethodsFactory {

public LoginForm loginForm = new LogInFormMain();
public void open(){
    get("http://kismia.com");
}


}
