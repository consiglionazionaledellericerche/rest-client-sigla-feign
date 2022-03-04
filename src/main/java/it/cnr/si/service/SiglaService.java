package it.cnr.si.service;

import com.google.gson.*;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import it.cnr.si.config.AuthenticationOnlyErrorDecoder;
import it.cnr.si.config.BasicRequestInterceptor;
import it.cnr.si.config.Sigla;
import it.cnr.si.dto.docamm.FatturaAttivaDTO;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class SiglaService {

    private final String baseUrl = PropertiesService.getProp("sigla.url");

    private final BasicRequestInterceptor basicRequestInterceptor;

    private final AuthenticationOnlyErrorDecoder authenticationOnlyErrorDecoder;

    private final Sigla sigla;

    private final Sigla siglaPrint;

    public SiglaService() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(json.getAsLong()), ZoneId.of("Europe/Rome"));
            }
        }).registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(ZonedDateTime.of(src, ZoneId.systemDefault()).toInstant().toEpochMilli());
            }
        }).create();

        basicRequestInterceptor = new BasicRequestInterceptor();
        authenticationOnlyErrorDecoder = new AuthenticationOnlyErrorDecoder();

        sigla = Feign.builder()
                .decoder(new GsonDecoder(gson))
                .encoder(new GsonEncoder(gson))
                .requestInterceptor(basicRequestInterceptor)
                .errorDecoder(authenticationOnlyErrorDecoder)
                .target(Sigla.class, baseUrl);

        siglaPrint = Feign.builder()
                .encoder(new GsonEncoder(gson))
                .requestInterceptor(basicRequestInterceptor)
                .errorDecoder(authenticationOnlyErrorDecoder)
                .target(Sigla.class, baseUrl);

    }

    public FatturaAttivaDTO getFatturaByProgressivo(Long pg) {
        return sigla.getFatturaByProgressivo(pg);
    }

    public List<FatturaAttivaDTO> inserisciFatture(List<FatturaAttivaDTO> fatture) {
        return sigla.inserisciFatture(fatture);
    }

    public Long inserisciDatiPerStampa(Long pgFattura) {
        return sigla.inserisciDatiPerStampa(pgFattura);
    }

    public byte[] stampaFattura(Long pgStampa) {
        return siglaPrint.stampaFattura(pgStampa);
    }

}
