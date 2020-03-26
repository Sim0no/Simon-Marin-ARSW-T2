package edu.eci.arsw.parcial.persistence;

import java.time.LocalDateTime;

/**
 * Clase para manejar cache
 */
public class CountryCache {
    private String valor;
    public LocalDateTime creacion;

    public CountryCache(String data){
        this.valor = data;
        creacion = LocalDateTime.now();
    }

    public String getData() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }



}
