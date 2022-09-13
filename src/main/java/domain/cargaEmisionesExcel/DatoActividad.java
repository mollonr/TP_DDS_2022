package domain.cargaEmisionesExcel;

public class DatoActividad {
    private Actividad actividad;
    private Double valor;
    private Periodicidad periodicidad;
    private String periodoImputacion;

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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

