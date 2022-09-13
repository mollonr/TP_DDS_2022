package domain.transporte.privado.calculoDistancias;

import domain.transporte.privado.TransporteConDir;

import java.io.IOException;


public interface EstrategiaCalculadorDistancias {
    public double calculadorDistancias(TransporteConDir direcciones) throws IOException;
}
