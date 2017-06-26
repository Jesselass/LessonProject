import core.EmailUtils;
import org.apache.commons.mail.EmailException;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 02.06.2017.
 */
public class TestEmail extends EmailUtils {
    @Test
    public void testEmail () throws EmailException {

        sendEmail("Test mail","azaza", "krav@onthe.io") ;
    }
}
