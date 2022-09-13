package domain.transporte.privado.calculoDistancias;

import domain.transporte.privado.TransporteConDir;

import java.io.IOException;

public class CalcularDistancia implements EstrategiaCalculadorDistancias {
    private AdaptadorCalculoDistancia adaptador;

    public CalcularDistancia(AdaptadorCalculoDistancia adaptador) {
        this.adaptador = adaptador;
    }

    public double calculadorDistancias(TransporteConDir direcciones) throws IOException {
        return adaptador.calculadorDistancias(direcciones);
    }
}
