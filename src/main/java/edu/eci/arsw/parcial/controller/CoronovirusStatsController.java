package edu.eci.arsw.parcial.controller;

import edu.eci.arsw.parcial.CoronovirusApiMain;
import edu.eci.arsw.parcial.persistence.CoronavirusStatsException;
import edu.eci.arsw.parcial.service.CoronavirusStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Controlador de estadisticas del covid19
 */
@RestController
@RequestMapping("/covid19")
public class CoronovirusStatsController {
    @Autowired
    CoronavirusStatsService statsService;

    /**
     *
     * @param pais El pais por el cual se desea consultar acerca del Covid19
     * @return Respuesta HTTP
     */
    @RequestMapping(value = "/getCasesByCountry/{pais}",method = RequestMethod.GET)
    public ResponseEntity<?> getCasesByCountry(@PathVariable String pais){

        try {
            String stats = statsService.getCovidStatsByName(pais);
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (CoronavirusStatsException e) {
            Logger.getLogger(CoronovirusApiMain.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    /**
     *
     * @return Respuesta HTTP
     */
    @RequestMapping(value="/getAllCases")
    public ResponseEntity<?> getAllCases(){
        try {
            String stats = statsService.getCovidStatsAll();
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (CoronavirusStatsException e) {
            Logger.getLogger(CoronovirusApiMain.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
