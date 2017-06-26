package core;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by Dell-SSD on 02.06.2017.
 */
public class EmailUtils {
    private static final String HOST_NAME = "smtp.googlemail.com";
    private static final int SMTP_PORT = 465;
    private static final DefaultAuthenticator DEFAULT_AUTHENTICATOR = new DefaultAuthenticator("krav@onthe.io", "qi2d1gQI");
    private static final String DEFAULT_FROM = "krav@onthe.io";


    public void sendEmail(String subject, String text, String ... recipients) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(HOST_NAME);
        email.setSmtpPort(SMTP_PORT);
        email.setAuthenticator(DEFAULT_AUTHENTICATOR);
        email.setSSLOnConnect(true);
        email.setFrom(DEFAULT_FROM);
        email.setSubject(subject);
        email.setMsg(text);
        email.addTo(recipients);
        email.send();
    }
}