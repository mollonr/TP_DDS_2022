package domain.trayecto;

import domain.transporte.ubicacionGeografica.UbicacionGeografica;

import java.util.List;
import java.util.UUID;

public class Trayecto {
    private UUID identificadorUnico;
    private UUID organizacionId;
    private UbicacionGeografica puntoLlegada;
    private UbicacionGeografica puntoPartida;
    private List<Tramo> tramos;

    public Trayecto(UbicacionGeografica puntoLlegada, UbicacionGeografica puntoPartida) {
        this.puntoLlegada = puntoLlegada;
        this.puntoPartida = puntoPartida;
        this.identificadorUnico = java.util.UUID.randomUUID();
    }

    public UUID getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(UUID organizacionId) {
        this.organizacionId = organizacionId;
    }

    public UUID getIdentificadorUnico() {
        return identificadorUnico;
    }

    public void setIdentificadorUnico(UUID identificadorUnico) {
        this.identificadorUnico = identificadorUnico;
    }

    public void agregarTramo(Tramo tramo) {
        tramos.add(tramo);
    }

    public void removerUltimoTramo() {
        tramos.remove(tramos.size() - 1);
    }

    public UbicacionGeografica getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(UbicacionGeografica puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public UbicacionGeografica getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(UbicacionGeografica puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public List<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(List<Tramo> tramos) {
        this.tramos = tramos;
    }
}
