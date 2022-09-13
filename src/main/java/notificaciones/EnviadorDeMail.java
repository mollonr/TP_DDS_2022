package notificaciones;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviadorDeMail extends ComandoNotificador{
    private Properties setMailServerProperties()
    {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        return properties;
    }

    private Session doAuth() {
        Session session = Session.getInstance(setMailServerProperties(), new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("MAIL", "CLAVE");
            }
        });
        session.setDebug(false);
        return session;
    }

    private MimeMessage createMessage() throws MessagingException {
        String to = "lucas.ezequiel001@gmail.com";
        String from = "lcampi@frba.utn.edu.ar";
        MimeMessage message = new MimeMessage(doAuth());
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(String.valueOf(new Date()));
        message.setContent("Prueba de email <b>Se le puede agregar <h1>HTML</h1></b>.", "text/html");
        return message;
    }
    @Override
    public void run() {
        try {
            System.out.println("sending...");
            Transport.send(createMessage());
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}