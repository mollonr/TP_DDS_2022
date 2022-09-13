package domain.cargaEmisionesExcel.Unidades;

import domain.calculoHuellaCarbono.TiposDeConsumo;

import java.util.Arrays;
import java.util.List;

public class RelacionesUnidadTipoConsumo {
    public static List<UnidadPorTipoConsumo> relacionesUnidadTipoConsumo = Arrays.asList(
            new UnidadPorTipoConsumo(TiposDeConsumo.GasNatural, Unidades.MetrosCubicos),
            new UnidadPorTipoConsumo(TiposDeConsumo.DieselGasoil, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.Kerosene, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.FuelOil, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.Nafta, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.Carbon, Unidades.Kilogramos),
            new UnidadPorTipoConsumo(TiposDeConsumo.CarbonDeLenia, Unidades.Kilogramos),
            new UnidadPorTipoConsumo(TiposDeConsumo.Lenia, Unidades.Kilogramos),
            new UnidadPorTipoConsumo(TiposDeConsumo.CombustibleConsumidoGasoil, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.CombustibleConsumidoGNC, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.CombustibleConsumidoNafta, Unidades.Litros),
            new UnidadPorTipoConsumo(TiposDeConsumo.Electricidad, Unidades.KiloWattHora),
            new UnidadPorTipoConsumo(TiposDeConsumo.DistanciaMediaRecorrida, Unidades.Kilometros),
            new UnidadPorTipoConsumo(TiposDeConsumo.PesoTotalTransportado, Unidades.Kilogramos)
    );
}
