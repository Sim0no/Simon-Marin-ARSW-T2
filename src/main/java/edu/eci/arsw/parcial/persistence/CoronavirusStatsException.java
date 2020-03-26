package edu.eci.arsw.parcial.persistence;
/**
 Clase para manejar excepciones
 **/
public class CoronavirusStatsException extends Exception {
    public final static String FALLO_EN_REQUEST = "It was't possible to carry out the request";
    public CoronavirusStatsException(String ex){

        super(ex);
    }
}
