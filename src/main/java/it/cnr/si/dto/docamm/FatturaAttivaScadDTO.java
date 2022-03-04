package it.cnr.si.dto.docamm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FatturaAttivaScadDTO {
    private java.math.BigDecimal im_voce;
    private String gae;
    private String cdr;
}
