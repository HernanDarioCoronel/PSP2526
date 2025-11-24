package entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para facilitar la devolución de los datos del total
 * de orzamentos y cantidad de proyectos en un estado especifico
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalOrzamento {
    private String estado;
    private int cantidad;
    private double orzamentoTotal;
}
