package domain.transporte.ubicacionGeografica;

public class UbicacionGeografica {
    private Integer altura;
    private String calle;
    private String provincia;
    private String municipio;
    private String localidad;

    public UbicacionGeografica(Integer altura, String calle, String provincia, String municipio, String localidad) {
        this.altura = altura;
        this.calle = calle;
        this.provincia = provincia;
        this.municipio = municipio;
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
