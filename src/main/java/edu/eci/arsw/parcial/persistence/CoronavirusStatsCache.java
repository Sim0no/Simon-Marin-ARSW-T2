package edu.eci.arsw.parcial.persistence;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Es una clase que ayudará a manejar el caché en el servidor
 */
@Service
public class CoronavirusStatsCache {
    ConcurrentHashMap<String,CountryCache> diccionario;

    public CoronavirusStatsCache(){

        diccionario = new ConcurrentHashMap<>();
    }
    /**
     *
     * @param llave Nombre del pais a encontrar en cache
     * @return Retorna si el aeropuerto ya se encuentra en caché
     */
    public boolean estaEnCache(String llave){
        CountryCache aux = diccionario.get(llave);
        if (aux!=null && LocalDateTime.now().isAfter(aux.creacion.plusMinutes(5))){
            diccionario.remove(llave);
        }
        return diccionario.get(llave)!=null;
    }

    /**
     *
     * @param llave Nombre del pais el cual que se almacenará en diccionario
     * @param valor Valor que se guardará en diccionario
     */
    public void cargarCache(String llave,String valor){
        CountryCache aux = new CountryCache(valor);
        diccionario.put(llave,aux);
    }

    /**
     *
     * @param llave Nombre del pais a buscar en diccionario.
     * @return Devuelve el objeto donde esta guardado el tiempo de creación en caché y el objeto JSON mapeado en un String
     */
    public CountryCache devolverCache(String llave){

        return diccionario.get(llave);
    }


}
