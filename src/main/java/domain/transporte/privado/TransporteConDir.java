package domain.transporte.privado;

import domain.transporte.Transportable;
import domain.transporte.publico.TransportePublico;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;

public abstract class TransporteConDir implements Transportable {
    private UbicacionGeografica puntoLlegada;
    private UbicacionGeografica puntoPartida;

    public TransporteConDir(UbicacionGeografica puntoLlegada, UbicacionGeografica puntoPartida) {
        this.puntoLlegada = puntoLlegada;
        this.puntoPartida = puntoPartida;
    }
    public UbicacionGeografica getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(UbicacionGeografica puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public UbicacionGeografica getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(UbicacionGeografica puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    @Override
    public void transportar() {

    }
}


