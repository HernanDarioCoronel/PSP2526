import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Artigo implements Serializable {

    public UUID idArtigo;
    public Date dataPublicacion;
    public String texto;
    public String autora;
    public String tema;

    public Artigo(Date dataPublicacion, String texto, String autora, String tema) {
        this.idArtigo = UUID.randomUUID();
        this.dataPublicacion = dataPublicacion;
        this.texto = texto;
        this.autora = autora;
        this.tema = tema;
    }

    public String toString() {
        return "Artigo [idArtigo=" + idArtigo.toString().substring(0, 6) + ", dataPublicacion=" + dataPublicacion
                + ", texto=" + texto
                + ", persoa autora=" + autora + ", tema=" + tema + "]";
    }

}