package domain.services.geodds;

import domain.services.geodds.entities.*;
import domain.transporte.ubicacionGeografica.UbicacionGeografica;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

    public class ServicioGeodds {
        private static ServicioGeodds instancia = null;
    private static final String urlAPI = "https://ddstpa.com.ar/api/";
    private static final String authorizationToken = "Bearer uR0SavGM3cZ4QkYHPfU5GT+s0IC/XD4x3JtlPdvbLnY=";
    private static final String paisCalculo = "Argentina";
    private Retrofit retrofit;

    public static ServicioGeodds getInstancia() {
        if(instancia == null) {
            instancia = new ServicioGeodds();
        }
        return instancia;
    }

    private ServicioGeodds() {
    this.retrofit = new Retrofit.Builder()
            .baseUrl(urlAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public List<Pais> listadoDePaises() throws IOException {
        GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
        Call<List<Pais>> requestPaises = geoddsService.paises(authorizationToken, 1);
        Response<List<Pais>> responsePaises = requestPaises.execute();
        return responsePaises.body();
    }

    public List<Provincia> listadoDeProvincias(int paisId) throws IOException {
        GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
        Call<List<Provincia>> requestProvincias = geoddsService.provincias(authorizationToken, 1, paisId);
        Response<List<Provincia>> responseProvincias = requestProvincias.execute();
        return responseProvincias.body();
    }

    public List<Municipio> listadoDeMunicipios(int provinciaId) throws IOException {
        GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
        Call<List<Municipio>> requestMunicipios = geoddsService.municipios(authorizationToken, 1, provinciaId);
        Response<List<Municipio>> responseMunicipios = requestMunicipios.execute();
        return responseMunicipios.body();
    }

    public List<Localidad> listadoDeLocalidades(int municipioId) throws IOException {
        GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
        Call<List<Localidad>> requestLocalidades = geoddsService.localidades(authorizationToken, 1, municipioId);
        Response<List<Localidad>> responseLocalidades = requestLocalidades.execute();
        return responseLocalidades.body();
    }

    public Distancia calcularDistancia(UbicacionGeografica ubicacionOrigen, UbicacionGeografica ubicacionDestino) throws IOException {
        GeoddsService geoddsService = this.retrofit.create(GeoddsService.class);
        //Busco el id correspondiente a Argentina
        int paisId = this.listadoDePaises().stream()
                        .filter(pais -> pais.nombre.toLowerCase() == paisCalculo.toLowerCase())
                        .findFirst().orElse(null).id;

        //Busco el listado de provincias argentinas (Se hace de esta manera para reducir la cantidad de llamados a la api)
        List<Provincia> provinciasArgentinas = this.listadoDeProvincias(paisId);

        //Busco el id de la localidad de la ubicación de origen
        int localidadOrigenId = this.obtenerLocalidadIdPorUbicacion(ubicacionOrigen, provinciasArgentinas);

        //Busco el id de la localidad de la ubicación de destino
        int localidadDestinoId = this.obtenerLocalidadIdPorUbicacion(ubicacionDestino, provinciasArgentinas);

        //Obtengo la distancia
        Call<Distancia> requestDistancia = geoddsService.distancia(authorizationToken, localidadOrigenId, ubicacionOrigen.getCalle(), ubicacionOrigen.getAltura().intValue(), localidadDestinoId, ubicacionDestino.getCalle(), ubicacionDestino.getAltura().intValue());
        Response<Distancia> responseDistancia = requestDistancia.execute();
        return responseDistancia.body();
    }

    private int obtenerLocalidadIdPorUbicacion(UbicacionGeografica ubicacionGeografica, List<Provincia> provinciasArgentinas) throws IOException {
        //Busco la provincia correspondiente a la ubicación
        int provinciaId = Objects.requireNonNull(provinciasArgentinas.stream()
                .filter(provincia -> provincia.nombre.toLowerCase() == ubicacionGeografica.getProvincia().toLowerCase())
                .findFirst().orElse(null)).id;
        //Busco el municipio correspondiente a la ubicación y provincia
        int municipioId = this.listadoDeMunicipios(provinciaId).stream()
                .filter(municipio -> municipio.nombre.toLowerCase() == ubicacionGeografica.getMunicipio().toLowerCase())
                .findFirst().orElse(null).id;
        //Busco la localidad correspondiente a la ubicación y municipio
        int localidadId = this.listadoDeLocalidades(municipioId).stream()
                .filter(localidad -> localidad.nombre.toLowerCase() == ubicacionGeografica.getLocalidad().toLowerCase())
                .findFirst().orElse(null).id;

        return localidadId;
    }


}
