package entidades;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proxecto {
    private Integer idProxecto;
    private String denominacion;
    private Integer nivelMinimo;
    private Estado estado;
    private BigDecimal orzamento;

    public enum Estado {
        CREADO, INICIADO, FINALIZADO
    }
}
