package domain.transporte.privado.ecologico;

import domain.transporte.privado.TransporteConDir;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;

public class Ecologico extends TransporteConDir {

    public Ecologico(UbicacionGeografica puntoLlegada, UbicacionGeografica puntoPartida) {
       super(puntoLlegada, puntoPartida);
    }
    @Override
    public void transportar() {
        return ;
    }
}
