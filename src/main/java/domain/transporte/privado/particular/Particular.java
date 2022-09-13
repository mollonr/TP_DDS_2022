package domain.transporte.privado.particular;

import domain.transporte.privado.TransporteConDir;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;

public class Particular extends TransporteConDir {
    private TipoCombustible tipoCombustible;
    private TipoVehiculo tipoVehiculo;

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Particular(UbicacionGeografica puntoLlegada, UbicacionGeografica puntoPartida) {
        super(puntoLlegada, puntoPartida);
    }
}
