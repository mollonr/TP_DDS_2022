package domain.cargaEmisionesExcel;

import domain.cargaEmisionesExcel.Unidades.UnidadPorTipoConsumo;

public class Actividad {

    private TipoActividad tipoActividad;
    private Alcance alcance;
    private Double valor;
    private UnidadPorTipoConsumo unidadPorTipoConsumo;
    private Periodicidad periodicidad;
    private String periodoImputacion;

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Alcance getAlcance() {
        return alcance;
    }

    public void setAlcance(Alcance alcance) {
        this.alcance = alcance;
    }

    public Double getValor() {
        return valor;
    }

    public UnidadPorTipoConsumo getunidadPorTipoConsumo() {
        return unidadPorTipoConsumo;
    }

    public void setUnidadPorTipoConsumo(UnidadPorTipoConsumo unidad) {
        this.unidadPorTipoConsumo = unidad;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getPeriodoImputacion() {
        return periodoImputacion;
    }

    public void setPeriodoImputacion(String periodoImputacion) {
        this.periodoImputacion = periodoImputacion;
    }
}
