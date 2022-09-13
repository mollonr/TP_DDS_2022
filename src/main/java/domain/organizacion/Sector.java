package domain.organizacion;

import domain.organizacion.org.Organizacion;
import domain.organizacion.persona.Persona;

import java.util.Collection;

public class Sector {
    private String nombre;
    private Organizacion organizacion;
    private Collection<Persona> miembros;

    public Sector(String nombre) {
        this.nombre = nombre;
    }

    public void orgContenedora(Organizacion organizacion) {
        this.organizacion = organizacion;
        this.organizacion.agregarSector(this);
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void agregarMiembro(Persona miembro) {
        miembros.add(miembro);
    }

    public Collection<Persona> getMiembros() {
        return miembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public void setMiembros(Collection<Persona> miembros) {
        this.miembros = miembros;
    }
}
