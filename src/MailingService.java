import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailingService {


    public void Messaging(MimeMessage message, SmtpModel model) throws MessagingException {
        message.setFrom(new InternetAddress(model.getSender()));
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(model.getRecipient()));
        message.setSubject(model.getSubject());
        message.setText(model.getText());
        Transport.send(message);
    }






}
