package domain.transporte.privado.contratado;


import domain.transporte.privado.TransporteConDir;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;

public class Contratado extends TransporteConDir {
    private TipoContratado tipoContratado;

    public Contratado(UbicacionGeografica puntoLlegada, UbicacionGeografica puntoPartida, TipoContratado tipoContratado) {
        super(puntoLlegada, puntoPartida);
        this.tipoContratado = tipoContratado;
    }
    @Override
    public void transportar() {

    }

    public TipoContratado getTipoContratado() {
        return tipoContratado;
    }

    public void setTipoContratado(TipoContratado tipoContratado) {
        this.tipoContratado = tipoContratado;
    }
}
