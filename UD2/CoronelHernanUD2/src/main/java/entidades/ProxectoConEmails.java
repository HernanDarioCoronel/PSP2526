package entidades;

import lombok.*;

import java.util.List;

/**
 * Clase para enviar un proxecto
 * con los emails de las persoas_empregadas
 * para favilitar su envío
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProxectoConEmails {
    private Proxecto proxecto;
    private List<String> emails;
}
