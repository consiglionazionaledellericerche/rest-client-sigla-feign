package it.cnr.si.dto.docamm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class FatturaAttivaRigaDTO {
    private java.lang.Boolean fl_iva_forzata;
    private String cd_voce;
    private String cd_tariffario;
    private String cd_voce_iva;
    private java.math.BigDecimal prezzo_unitario;
    private java.math.BigDecimal im_iva;
    private java.math.BigDecimal quantita;
    private Integer esercizio_contratto;
    private Long pg_contratto;
    private String stato_contratto;
    private String ds_riga_fattura;
    private Long pg_fattura_assncna_fin;
    private Integer esercizio_assncna_fin;
    private Long pg_riga_assncna_fin;
    private Long progressivo_riga;
    private String ds_accertamento;
    private String ds_obbligazione;
    private List<FatturaAttivaScadDTO> righescadvoc;
    private Long pg_obbligazione_scadenzario;
    private Long pg_obbligazione;
    private Long pg_accertamento_scadenzario;
    private Long pg_accertamento;
    private String motivazione;
    private LocalDateTime dt_scadenza;
    private String cd_bene_servizio;

}
