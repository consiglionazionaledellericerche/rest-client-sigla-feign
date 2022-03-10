package it.cnr.si.config;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import it.cnr.si.dto.docamm.FatturaAttivaDTO;

import java.util.List;

@Headers({"Content-Type: application/json"})
public interface Sigla {

    @RequestLine("GET /fatturaattiva?esercizio={esercizio}&pg={pg}")
    FatturaAttivaDTO getFatturaByProgressivo(@Param("esercizio") Integer esercizio, @Param("pg") Long pg);

    @RequestLine("POST /fatturaattiva")
    List<FatturaAttivaDTO> inserisciFatture(List<FatturaAttivaDTO> fatture);

    @RequestLine("POST /fatturaattiva/inserisciDatiPerStampa?esercizio={esercizio}&pg={pg}")
    Long inserisciDatiPerStampa(@Param("esercizio") Integer esercizio, @Param("pg") Long pg);

    @RequestLine("GET /fatturaattiva/print?pgStampa={pgStampa}")
    byte[] stampaFattura(@Param("pgStampa") Long pgStampa);

}
