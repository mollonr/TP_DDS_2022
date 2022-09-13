package notificaciones;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import notificaciones.ComandoNotificador;

import java.net.URI;
import java.math.BigDecimal;

public class EnviadorDeWpp extends ComandoNotificador {
    public static final String ACCOUNT_SID = "AC580f8dc1cb28cdce2608db79d3ad841f";
    public static final String AUTH_TOKEN = "9a7721069cdcbba02f981a1449e51fc5";

    @Override
    public void run() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+5491159407475"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        "Hello! This is an editable text message. You are free to change it and write whatever you like.")
                .create();

        System.out.println(message.getSid());
    }
}