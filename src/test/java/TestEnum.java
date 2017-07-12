import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 05.07.2017.
 */
public class TestEnum {
    @Test
    public void azaza(){



        ERROR invalidEmail = ERROR.INVALID_EMAIL_ERROR;
        System.out.println(invalidEmail.getMessage());
    }
}
