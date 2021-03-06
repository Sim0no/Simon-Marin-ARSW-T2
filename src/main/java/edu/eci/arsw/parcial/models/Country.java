package edu.eci.arsw.parcial.models;

import org.json.JSONObject;

/**
 * Clase que representa las estadisticas por pais.
 */
public class Country {
    private JSONObject jsonObject;
    private int deaths;
    private int recovered;
    private int confirmed;

    public Country(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        deaths = Integer.parseInt(jsonObject.get("deaths").toString());
        recovered = Integer.parseInt(jsonObject.get("recovered").toString());
        confirmed = Integer.parseInt(jsonObject.get("confirmed").toString());
    }

    public void sumarJSON(JSONObject jsonObject){
        deaths += Integer.parseInt(jsonObject.get("deaths").toString());
        recovered += Integer.parseInt(jsonObject.get("recovered").toString());
        confirmed += Integer.parseInt(jsonObject.get("confirmed").toString());
    }

    public JSONObject getJsonObject(){
        jsonObject.put("deaths",deaths);
        jsonObject.put("confirmed",confirmed);
        jsonObject.put("recovered",recovered);
        return jsonObject;
    }

}
