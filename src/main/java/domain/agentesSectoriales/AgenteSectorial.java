package domain.agentesSectoriales;

import domain.organizacion.org.Organizacion;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;

import java.util.List;
import java.util.stream.DoubleStream;

import static domain.calculoHuellaCarbono.CalculadoraDeHuellaDeCarbono.ObtenerHuellaDeCarbonoTotal;

public class AgenteSectorial {
    private UbicacionGeografica sectorTerritorial;

    public static DoubleStream calcularHCTerritorial(List<Organizacion> organizaciones){
        /* se hace recibir una lista con las organizaciones del sector, falta definir como se arma esa lista */
        return organizaciones.stream().mapToDouble(organizacion -> ObtenerHuellaDeCarbonoTotal(organizacion));
    }



}
