package domain.organizacion.persona.documento;

public class Documento {
    private String numero;
    private TipoDoc tipo;

    public Documento(String numero, TipoDoc tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDoc getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoc tipo) {
        this.tipo = tipo;
    }
}
