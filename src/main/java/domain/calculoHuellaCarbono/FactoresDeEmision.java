package domain.calculoHuellaCarbono;

import java.util.Collection;
import java.util.Optional;

public class FactoresDeEmision {
    private static Collection<FactorDeEmision> factoresDeEmision;

    public static FactorDeEmision obtenerFactorDeEmisionPorTipoActividad(String tipoDeConsumo){
        return factoresDeEmision.stream()
                .filter(factorDeEmision -> factorDeEmision.getTipoConsumo().equals(tipoDeConsumo))
                .findFirst()
                .orElse(null);
    }

    public static void AgregarOModificarFactorDeEmision(FactorDeEmision factorDeEmision){
        factoresDeEmision.removeIf(f -> f.getTipoConsumo().equals(factorDeEmision.getTipoConsumo()));
        factoresDeEmision.add(factorDeEmision);
    }
}
