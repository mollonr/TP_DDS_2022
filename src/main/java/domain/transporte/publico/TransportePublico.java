package domain.transporte.publico;

import domain.transporte.Transportable;

public class TransportePublico implements Transportable {
    private Linea linea;
    private Parada paradaFin;
    private Parada paradaInicio;
    private TipoPublico tipoPublico;

    public TransportePublico(Linea linea, Parada paradaFin, Parada paradaInicio, TipoPublico tipoPublico) {
        this.linea = linea;
        this.paradaFin = paradaFin;
        this.paradaInicio = paradaInicio;
        this.tipoPublico =  tipoPublico;
    }
    @Override
    public void transportar() {

    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public Parada getParadaFin() {
        return paradaFin;
    }

    public void setParadaFin(Parada paradaFin) {
        this.paradaFin = paradaFin;
    }

    public Parada getParadaInicio() {
        return paradaInicio;
    }

    public void setParadaInicio(Parada paradaInicio) {
        this.paradaInicio = paradaInicio;
    }

    public TipoPublico getTipoPublico() {
        return tipoPublico;
    }

    public void setTipoPublico(TipoPublico tipoPublico) {
        this.tipoPublico = tipoPublico;
    }
}
