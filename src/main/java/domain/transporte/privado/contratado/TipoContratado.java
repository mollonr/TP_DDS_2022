package domain.transporte.privado.contratado;

public class TipoContratado {
    private String nombreTipo;

    public TipoContratado(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
