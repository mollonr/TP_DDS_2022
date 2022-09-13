package domain.organizacion.persona;

import domain.organizacion.org.Organizacion;
import domain.organizacion.persona.documento.Documento;
import domain.organizacion.Sector;
import domain.trayecto.Trayecto;

import java.util.Collection;
import java.util.List;

public class Persona {
    private String apellido;
    private String nombre;
    private Documento documento;
    private List<Sector> sectores;
    private List<Trayecto> trayectos;

    public Persona(String apellido, String nombre, Documento documento) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
    }

    public Collection<Sector> getSectores() {
        return sectores;
    }

    public List<Organizacion> getOrganizaciones() {
        List<Organizacion> organizaciones = null;

        for (Sector s : sectores ) {
            organizaciones.add(s.getOrganizacion());
        }

        return organizaciones;
    }

    public void unirseASector(Sector sector) {
        sectores.add(sector);
        sector.agregarMiembro(this);
    }

    public void nuevoTrayecto(Trayecto trayecto) {
        trayectos.add(trayecto);
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Collection<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public void setSectores(Collection<Sector> sectores) {
        this.sectores = sectores;
    }

    public void setTrayectos(Collection<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }
}
