package com.greensqa.model;

public class FlightData {

    private String origen;
    private String destino;

    public FlightData(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
}