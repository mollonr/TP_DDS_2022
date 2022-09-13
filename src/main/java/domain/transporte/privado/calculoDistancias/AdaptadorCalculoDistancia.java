package domain.transporte.privado.calculoDistancias;

import domain.transporte.privado.TransporteConDir;

import java.io.IOException;

public interface AdaptadorCalculoDistancia {
    public double calculadorDistancias(TransporteConDir direcciones) throws IOException;
}
