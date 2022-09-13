package domain.cargaEmisionesExcel.Unidades;

public class UnidadPorTipoConsumo {
    private String tipoConsumo;
    private String unidad;

    public UnidadPorTipoConsumo(String tipoConsumo, String unidad) {
        this.tipoConsumo = tipoConsumo;
        this.unidad = unidad;
    }

    public String getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
