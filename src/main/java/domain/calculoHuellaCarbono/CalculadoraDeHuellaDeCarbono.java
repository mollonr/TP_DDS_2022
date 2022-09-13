package domain.calculoHuellaCarbono;

import domain.cargaEmisionesExcel.Actividad;
import domain.cargaEmisionesExcel.Periodicidad;
import domain.organizacion.Sector;
import domain.organizacion.org.Organizacion;
import domain.organizacion.persona.Persona;
import domain.transporte.Transportable;
import domain.transporte.calculoHC.ConsumoPorTipoTransporte;
import domain.transporte.calculoHC.RelacionesConsumoTipo;
import domain.transporte.privado.TransporteConDir;
import domain.transporte.privado.calculoDistancias.CalcularDistancia;
import domain.transporte.privado.calculoDistancias.ServicioApiExterno;
import domain.transporte.privado.contratado.Contratado;
import domain.transporte.privado.ecologico.Ecologico;
import domain.transporte.privado.particular.Particular;
import domain.transporte.privado.particular.TipoVehiculo;
import domain.transporte.publico.TransportePublico;
import domain.trayecto.Tramo;
import domain.trayecto.Trayecto;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculadoraDeHuellaDeCarbono {

    private static final CalcularDistancia calculadoraDeDistancias = new CalcularDistancia(new ServicioApiExterno());
    private static final Integer cantDiasAnio = 300;
    private static final Integer cantDiasMes = 25;
    public static Double ObtenerHuellaDeCarbonoAnual(Organizacion organizacion, String anio) {
        List<Actividad> actividadesFiltradas = organizacion.getActividades()
                .stream()
                .filter(actividad -> ActividadPerteneceAlAnio(actividad, anio))
                .collect(Collectors.toList());
        Double huellaDeCarbonoOrganizacional = actividadesFiltradas.stream()
                .mapToDouble(actividad -> CalcularHCPorActividad(actividad))
                .sum();
        Double huellaDeCarbonoDeEmpleadosAnual = ObtenerHuellaDeCarbonoDeTodosLosEmpleados(organizacion.getMiembros(), organizacion.getId()) * cantDiasAnio;
        return huellaDeCarbonoOrganizacional + huellaDeCarbonoDeEmpleadosAnual;

    }

    public static Double ObtenerHuellaDeCarbonoTotal(Organizacion organizacion) {
        List<Actividad> actividadesFiltradas = organizacion.getActividades()
                .stream()
                .filter(actividad -> (actividad == actividad))
                .collect(Collectors.toList());
        Double huellaDeCarbonoOrganizacional = actividadesFiltradas.stream()
                .mapToDouble(actividad -> CalcularHCPorActividad(actividad))
                .sum();
        Double huellaDeCarbonoDeEmpleadosAnual = ObtenerHuellaDeCarbonoDeTodosLosEmpleados(organizacion.getMiembros(), organizacion.getId()) * cantDiasAnio;
        return huellaDeCarbonoOrganizacional + huellaDeCarbonoDeEmpleadosAnual;

    }
    public static Double ObtenerHuellaDeCarbonoMensual(Organizacion organizacion, String periodo) {
        List<Actividad> actividadesFiltradas = organizacion.getActividades()
                .stream()
                .filter(actividad -> actividad.getPeriodicidad() == Periodicidad.MENSUAL && actividad.getPeriodoImputacion().equals(periodo))
                .collect(Collectors.toList());

        Double huellaDeCarbonoOrganizacional = actividadesFiltradas.stream()
                .mapToDouble(actividad -> CalcularHCPorActividad(actividad))
                .sum();
        Double huellaDeCarbonoDeEmpleadosMensual = ObtenerHuellaDeCarbonoDeTodosLosEmpleados(organizacion.getMiembros(), organizacion.getId()) * cantDiasMes;

        return huellaDeCarbonoOrganizacional + huellaDeCarbonoDeEmpleadosMensual;
    }

    public static Double ObtenerHuellaDeCarbonoDeTodosLosEmpleados(List<Persona> personas, UUID organizacionId){
        Stream<Trayecto> trayectosTotales = personas.stream().flatMap(p -> p.getTrayectos().stream()).filter(t -> t.getOrganizacionId() == organizacionId);
        return CalcularHCPorTrayectos(trayectosTotales.distinct().collect(Collectors.toList()));
    }

    public static Double ObtenerHuellaDeCarbonoPorEmpleado(Persona persona, UUID OrganizacionId){
        List<Trayecto> trayectosDeLaOrganizacion = persona
                .getTrayectos()
                .stream()
                .filter(trayecto -> trayecto.getOrganizacionId() == OrganizacionId)
                .collect(Collectors.toList());

        return CalcularHCPorTrayectos(trayectosDeLaOrganizacion);
    }

    public static Double ImpactoSobreTotalOrganizacion(Persona persona, Organizacion organizacion, Periodicidad periodicidad, String periodo){
        if(periodicidad == Periodicidad.ANUAL) {
            return cantDiasAnio * ObtenerHuellaDeCarbonoPorEmpleado(persona, organizacion.getId()) / ObtenerHuellaDeCarbonoAnual(organizacion, periodo);
        }else {
            return cantDiasMes * ObtenerHuellaDeCarbonoPorEmpleado(persona, organizacion.getId()) / ObtenerHuellaDeCarbonoMensual(organizacion, periodo);
        }
    }

    public static Double ObtenerHCPorEmpleadoPorSectorAnual(Sector sector) {
        return ObtenerHCPorEmpleadoPorSector(sector, cantDiasAnio);
    }

    public static Double ObtenerHCPorEmpleadoPorSectorMensual(Sector sector) {
        return ObtenerHCPorEmpleadoPorSector(sector, cantDiasMes);
    }

    private static Double ObtenerHCPorEmpleadoPorSector(Sector sector, Integer multiplicador) {
        List<Trayecto> trayectosFiltrados = sector.getMiembros()
                .stream().flatMap(m -> m.getTrayectos().stream())
                .filter(t -> t.getOrganizacionId() == sector.getOrganizacion().getId())
                .distinct()
                .collect(Collectors.toList());

        return CalcularHCPorTrayectos(trayectosFiltrados) * multiplicador / sector.getMiembros().size();
    }

    private static Double CalcularHCPorTrayectos(List<Trayecto> trayectos){
        List<Tramo> tramosTotales = trayectos.stream()
                .flatMap(trayecto -> trayecto.getTramos().stream())
                .collect(Collectors.toList());

        return tramosTotales.stream().mapToDouble(t -> {
            try {
                return CalcularHCPorTramo(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();
    }
    }

    private static boolean ActividadPerteneceAlAnio(Actividad actividad, String anio){
        return (actividad.getPeriodicidad() == Periodicidad.ANUAL && actividad.getPeriodoImputacion().equals(anio))
                || (actividad.getPeriodicidad() == Periodicidad.MENSUAL && actividad.getPeriodoImputacion().substring(3).equals(anio));
    }

    private static Double CalcularHCPorActividad(Actividad actividad){
        return actividad.getValor() * FactoresDeEmision.obtenerFactorDeEmisionPorTipoActividad(actividad.getunidadPorTipoConsumo().getTipoConsumo()).getValor();
    }

    private static Double CalcularHCPorTramo(Tramo tramo) throws IOException {
        Transportable medioDeTransporte = tramo.getMedioDeTransporte();
        if(medioDeTransporte instanceof TransportePublico){
            double distanciaViajada = ((TransportePublico) medioDeTransporte).getLinea().calcularDistanciaEntreParadas(((TransportePublico) medioDeTransporte).getParadaInicio(), ((TransportePublico) medioDeTransporte).getParadaFin());

            return distanciaViajada *
                    RelacionesConsumoTipo.ObtenerConsumoPorTipo(((TransportePublico) medioDeTransporte).getTipoPublico()).getConstanteConsumo() *
                    FactoresDeEmision.obtenerFactorDeEmisionPorTipoActividad(TiposDeConsumo.getTipoConsumoPorTipoTransportePublico(((TransportePublico) medioDeTransporte).getTipoPublico())).getValor();
        }
        else {
            if(medioDeTransporte instanceof Ecologico){
                return 0.0;
            }
            else{
                double distanciaViajada = calculadoraDeDistancias.calculadorDistancias((TransporteConDir) medioDeTransporte);
                if(medioDeTransporte instanceof Contratado){
                    return distanciaViajada *
                            RelacionesConsumoTipo.ObtenerConsumoPorTipo(TipoVehiculo.AUTO).getConstanteConsumo() *
                            FactoresDeEmision.obtenerFactorDeEmisionPorTipoActividad(TiposDeConsumo.CombustibleConsumidoNafta).getValor();
                }
                else if(medioDeTransporte instanceof Particular) {
                    return distanciaViajada *
                            RelacionesConsumoTipo.ObtenerConsumoPorTipo(((Particular) medioDeTransporte).getTipoVehiculo()).getConstanteConsumo() *
                            FactoresDeEmision.obtenerFactorDeEmisionPorTipoActividad(TiposDeConsumo.getTipoConsumoPorTipoCombustible(((Particular) medioDeTransporte).getTipoCombustible())).getValor();
                }
            }

        }


    }
}
