package domain.transporte.publico;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Linea {
    private String nombre;
    private ArrayList<Parada> paradas;
    private ArrayList<Double> distancias;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

   public void agregarParada(Parada ... parada){
        paradas.addAll(Arrays.asList(parada));
   }

   public double calcularDistanciaEntreParadas(Parada paradaInicio, Parada paradaFin){
       Integer indiceParadaInicial = paradas.stream().map(parada -> parada.getParada()).collect(Collectors.toList()).indexOf(paradaInicio.getParada());
       Integer indiceParadaFin = paradas.stream().map(parada -> parada.getParada()).collect(Collectors.toList()).indexOf(paradaFin.getParada());

       double distancia = 0;

       while(indiceParadaInicial < indiceParadaFin){
           distancia+= distancias.get(indiceParadaInicial);
           indiceParadaInicial ++;
       }

       return distancia;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<Parada> paradas) {
        this.paradas = paradas;
    }

    public ArrayList<Double> getDistancias() {
        return distancias;
    }

    public void setDistancias(ArrayList<Double> distancias) {
        this.distancias = distancias;
    }
}
