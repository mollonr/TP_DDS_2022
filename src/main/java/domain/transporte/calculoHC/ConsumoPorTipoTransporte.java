package domain.transporte.calculoHC;

import domain.transporte.TipoTransporte;

public class ConsumoPorTipoTransporte {
    private TipoTransporte tipoTransporte;
    private Double constanteConsumo;

    public ConsumoPorTipoTransporte(TipoTransporte tipoTransporte, Double constanteConsumo) {
        this.tipoTransporte = tipoTransporte;
        this.constanteConsumo = constanteConsumo;
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Double getConstanteConsumo() {
        return constanteConsumo;
    }

    public void setConstanteConsumo(Double constanteConsumo) {
        this.constanteConsumo = constanteConsumo;
    }
}
