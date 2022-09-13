package notificaciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;

public class InvocadorNotificaciones {
    private Collection<ComandoNotificador> comandos = new ArrayList<ComandoNotificador>();

    public void agregarComando(ComandoNotificador comando) {
        comandos.add(comando);
    }
    public void invocar() {
        this.agregarComando(new EnviadorDeMail());
        this.agregarComando(new EnviadorDeWpp());
        for(ComandoNotificador comando : comandos) {
            Timer t = new Timer();
            t.scheduleAtFixedRate(comando, 0, 60000);
        }
    }

}
