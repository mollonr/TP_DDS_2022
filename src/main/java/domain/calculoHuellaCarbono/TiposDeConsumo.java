package domain.calculoHuellaCarbono;

import domain.transporte.privado.particular.TipoCombustible;
import domain.transporte.publico.TipoPublico;

public class TiposDeConsumo {
    public static final String GasNatural = "Gas Natural";
    public static final String DieselGasoil = "Diesel/Gasoil";
    public static final String Kerosene = "Kerosene";
    public static final String FuelOil = "Fuel Oil";
    public static final String Nafta = "Nafta";
    public static final String Carbon = "Carbón";
    public static final String CarbonDeLenia = "Carbón de leña";
    public static final String Lenia = "Leña";
    public static final String CombustibleConsumidoGasoil = "Combustible consumido - Gasoil";
    public static final String CombustibleConsumidoGNC = "Combustible consumido - GNC";
    public static final String CombustibleConsumidoNafta = "Combustible consumido - Nafta";
    public static final String Electricidad = "Electricidad";
    public static final String DistanciaMediaRecorrida = "Distancia media recorrida";
    public static final String PesoTotalTransportado = "Peso total transportado";

    public static String getTipoConsumoPorTipoCombustible(TipoCombustible tipoCombustible){
        switch(tipoCombustible){
            case NAFTA:
                return CombustibleConsumidoNafta;
            case GNC:
                return CombustibleConsumidoGNC;
            case GASOIL:
                return CombustibleConsumidoGasoil;
            case ELECTRICO:
                return Electricidad;
        }
        return null;
    }
    public static String getTipoConsumoPorTipoTransportePublico(TipoPublico tipo){
        switch(tipo){
            case TREN:
            case SUBTE:
                return Electricidad;
            case COLECTIVO:
                return CombustibleConsumidoNafta;
        }
        return null;
    }
}
