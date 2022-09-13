package domain.transporte.privado.calculoDistancias;

import domain.services.geodds.ServicioGeodds;
import domain.transporte.privado.TransporteConDir;

import java.io.IOException;

public class ServicioApiExterno implements AdaptadorCalculoDistancia{
    private ServicioGeodds servicioGeodds;

    public ServicioApiExterno(){
        this.servicioGeodds = ServicioGeodds.getInstancia();
    }

    public double calculadorDistancias(TransporteConDir direcciones) throws IOException {
        return servicioGeodds.calcularDistancia(direcciones.getPuntoPartida(), direcciones.getPuntoLlegada()).valor;
    }
}
