package domain.organizacion.org;

import domain.organizacion.Sector;
import domain.organizacion.clasificacionOrganizacion.ClasificacionOrg;
import domain.organizacion.persona.Persona;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;
import java.io.File;
import java.util.Scanner;
import domain.cargaEmisionesExcel.*;
import java.util.List;
import java.util.UUID;

public class Organizacion {
    private UUID id;
    private String razonSocial;
    private ClasificacionOrg clasificacion;
    private List<Sector> sectores;
    private TipoOrganizacion tipoOrganizacion;
    private UbicacionGeografica ubicacion;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    private List<Actividad> actividades;

    public Organizacion (String razonSocial, ClasificacionOrg clasificacion, TipoOrganizacion tipoOrganizacion, UbicacionGeografica ubicacion) {
        this.razonSocial = razonSocial;
        this.clasificacion = clasificacion;
        this.tipoOrganizacion = tipoOrganizacion;
        this.ubicacion = ubicacion;
        this.id = java.util.UUID.randomUUID();
    }

    public List<Sector> getSectores() {
        return sectores;
    }
    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public List<Persona> getMiembros() {
        List<Persona> miembros = null;
        
        for (Sector s : sectores ) {
            miembros.addAll(s.getMiembros());
        }
        
        return miembros;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public ClasificacionOrg getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ClasificacionOrg clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    public TipoOrganizacion getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public UbicacionGeografica getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionGeografica ubicacion) {
        this.ubicacion = ubicacion;
    }

    public static void cargaEmisiones(String[] args){
        String archivo = "";
        System.out.println("Ingrese el PATH completo del archivo:");
        Scanner archivoScanner = new Scanner (System.in); //Creación de un objeto Scanner
        archivo = archivoScanner.nextLine(); //Invocamos un método sobre un objeto Scanner
        File f=new File(archivo);
        if (f.exists()){
            LeerArchivoExcel.EjecutarLectura(f);
        }
    }

}
