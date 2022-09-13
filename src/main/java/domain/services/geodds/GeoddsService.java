package domain.services.geodds;

import domain.services.geodds.entities.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;

public interface GeoddsService {
    @GET("paises")
    Call<List<Pais>> paises(@Header("Authorization") String authHeader, @Query("offset") int offset);

    @GET("provincias")
    Call<List<Provincia>> provincias(@Header("Authorization") String authHeader, @Query("offset") int offset, @Query("paisId") int paisId);

    @GET("municipios")
    Call<List<Municipio>> municipios(@Header("Authorization") String authHeader, @Query("offset") int offset, @Query("provinciaId") int provinciaId);

    @GET("localidades")
    Call<List<Localidad>> localidades(@Header("Authorization") String authHeader, @Query("offset") int offset, @Query("municipioId") int municipioId);

    @GET("distancia")
    Call<Distancia> distancia(@Header("Authorization") String authHeader, @Query("localidadOrigenId") int localidadOrigenId, @Query("calleOrigen") String calleOrigen, @Query("alturaOrigen") int alturaOrigen, @Query("localidadDestinoId") int localidadDestinoId, @Query("calleDestino") String calleDestino, @Query("alturaDestino") int alturaDestino);

}
