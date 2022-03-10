package it.cnr.si.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import it.cnr.si.service.PropertiesService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

public class BasicRequestInterceptor implements RequestInterceptor {

    private final String username = PropertiesService.getProp("sigla.username");
    private final String password = PropertiesService.getProp("sigla.password");

    private final String cds = PropertiesService.getProp("sigla.cds");
    private final String uo = PropertiesService.getProp("sigla.uo");
    private final String cdr = PropertiesService.getProp("sigla.cdr");

    public BasicRequestInterceptor() {
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization",
                "Basic " + Base64.getEncoder().encodeToString(
                        username.concat(":").concat(password).getBytes(StandardCharsets.UTF_8))
        );
        requestTemplate.header("X-sigla-cd-cds", cds);
        requestTemplate.header("X-sigla-cd-unita-organizzativa", uo);
        requestTemplate.header("X-sigla-cd-cdr", cdr);
    }
}
