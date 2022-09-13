package domain.transporte.calculoHC;

import domain.transporte.TipoTransporte;

import java.util.Collection;
import java.util.List;

public class RelacionesConsumoTipo {
    private static Collection<ConsumoPorTipoTransporte> consumosPorTipo;

    public static void AgregarConsumo(ConsumoPorTipoTransporte consumo){
        consumosPorTipo.removeIf(c -> c.getTipoTransporte() == consumo.getTipoTransporte());
        consumosPorTipo.add(consumo);
    }

    public static ConsumoPorTipoTransporte ObtenerConsumoPorTipo(TipoTransporte tipo){
        return consumosPorTipo.stream()
                .filter(consumoPorTipo -> consumoPorTipo.getTipoTransporte() == tipo)
                .findFirst()
                .orElse(null);
    }
}
