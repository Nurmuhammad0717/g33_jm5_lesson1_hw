import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MessagingException {

        Properties props = new Properties();

        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.ssl.enable", "false");
        props.put("mail.smpt.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new  PasswordAuthentication("545f2b4a73a6fb","8c33d675b89940");
            }
        };

        Scanner scanner = new Scanner(System.in);

        Session session = Session.getInstance(props, authenticator);
        MimeMessage message =new MimeMessage(session);

        System.out.println("\t Welcome to our mailing service ");

        System.out.print("Enter your username :");
        String sender = scanner.nextLine();
        System.out.print("Enter the recipients username :");
        String recipient = scanner.nextLine();
        System.out.print("Enter the subject of topic :");
        String subject = scanner.nextLine();
        System.out.print("Enter the text :");
        String text = scanner.nextLine();

        SmtpModel smtpModel = new SmtpModel(sender,recipient,subject,text);
        MailingService mailingService = new MailingService();

        mailingService.Messaging(message,smtpModel);


    }
}