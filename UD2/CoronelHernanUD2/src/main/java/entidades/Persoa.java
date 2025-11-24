package entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persoa {
    private Integer idPersoa;
    private String email;
    private int nivel;
}