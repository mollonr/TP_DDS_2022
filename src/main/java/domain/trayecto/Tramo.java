package domain.trayecto;

import domain.transporte.Transportable;
import org.apache.poi.hpsf.GUID;

public class Tramo {
    private Transportable medioDeTransporte;

    public Tramo(Transportable medioDeTransporte) {
        this.medioDeTransporte = medioDeTransporte;
    }

    public Transportable getMedioDeTransporte() {
        return medioDeTransporte;
    }

    public void setMedioDeTransporte(Transportable medioDeTransporte) {
        this.medioDeTransporte = medioDeTransporte;
    }
}
