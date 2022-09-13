package domain.calculoHuellaCarbono;

public class FactorDeEmision {
    private String tipoConsumo;
    private Double valor;
    private String unidad;

    public FactorDeEmision(String tipoConsumo, Double valor, String unidad) {
        this.tipoConsumo = tipoConsumo;
        this.valor = valor;
        this.unidad = unidad;
    }

    public String getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
