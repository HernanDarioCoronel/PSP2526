package cuestionario;

public class Pregunta {
    private String pregunta;
    private String[] posiblesRespuestas;
    private char respuestaCorrecta;

    public Pregunta(String pregunta, String[] posiblesRespuestas, char respuestaCorrecta) {
        this.pregunta = pregunta;
        this.posiblesRespuestas = posiblesRespuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String[] getPosiblesRespuestas() {
        return posiblesRespuestas;
    }

    public void setPosiblesRespuestas(String[] posiblesRespuestas) {
        this.posiblesRespuestas = posiblesRespuestas;
    }

    public char getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(char respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public boolean responder(char rta) {
        return rta == this.respuestaCorrecta;
    }
}
