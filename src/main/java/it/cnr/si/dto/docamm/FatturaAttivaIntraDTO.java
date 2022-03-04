package it.cnr.si.dto.docamm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FatturaAttivaIntraDTO {
    private java.math.BigDecimal ammontare_euro;
    private String cod_incasso;
    private String cod_erogazione;
    private Long id_cpa;
    private Long pg_nazione;
    // variabili relative ai beni
    private Long id_nomenclatura_combinata;
    private Long id_natura_transazione;
    private String cd_provincia;
    private String cd_consegna;
    private String cd_trasporto;
    private java.math.BigDecimal Massa;
    private java.math.BigDecimal valore_statistico;
    private Long unita_supplementari;
}
