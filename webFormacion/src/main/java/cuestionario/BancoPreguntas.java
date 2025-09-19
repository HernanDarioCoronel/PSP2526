package cuestionario;

public class BancoPreguntas {
    public static Pregunta[] obtenerPreguntas() {
        Pregunta[] preguntas = new Pregunta[20];

        preguntas[0] = new Pregunta(
                "¿Cuál es el planeta más cercano al Sol?",
                new String[]{"A) Venus", "B) Mercurio", "C) Marte", "D) Júpiter"},
                'B'
        );

        preguntas[1] = new Pregunta(
                "¿Cuántos continentes hay en el mundo?",
                new String[]{"A) 5", "B) 6", "C) 7", "D) 8"},
                'C'
        );

        preguntas[2] = new Pregunta(
                "¿Cuál es el océano más grande?",
                new String[]{"A) Atlántico", "B) Pacífico", "C) Índico", "D) Ártico"},
                'B'
        );

        preguntas[3] = new Pregunta(
                "¿En qué continente está Egipto?",
                new String[]{"A) Asia", "B) África", "C) Europa", "D) Oceanía"},
                'B'
        );

        preguntas[4] = new Pregunta(
                "¿Qué gas necesitamos para respirar?",
                new String[]{"A) Dióxido de carbono", "B) Oxígeno", "C) Nitrógeno", "D) Helio"},
                'B'
        );

        preguntas[5] = new Pregunta(
                "¿Qué animal es conocido como el rey de la selva?",
                new String[]{"A) Tigre", "B) León", "C) Elefante", "D) Gorila"},
                'B'
        );

        preguntas[6] = new Pregunta(
                "¿De qué color es la sangre?",
                new String[]{"A) Azul", "B) Roja", "C) Verde", "D) Negra"},
                'B'
        );

        preguntas[7] = new Pregunta(
                "¿Cuál es la capital de Francia?",
                new String[]{"A) Roma", "B) Berlín", "C) París", "D) Madrid"},
                'C'
        );

        preguntas[8] = new Pregunta(
                "¿Qué día viene después del lunes?",
                new String[]{"A) Miércoles", "B) Martes", "C) Domingo", "D) Viernes"},
                'B'
        );

        preguntas[9] = new Pregunta(
                "¿Cuántos minutos tiene una hora?",
                new String[]{"A) 30", "B) 60", "C) 90", "D) 120"},
                'B'
        );

        preguntas[10] = new Pregunta(
                "¿Cuál es el río más largo del mundo?",
                new String[]{"A) Amazonas", "B) Nilo", "C) Misisipi", "D) Yangtsé"},
                'A'
        );

        preguntas[11] = new Pregunta(
                "¿Cuántas patas tiene una araña?",
                new String[]{"A) 6", "B) 8", "C) 10", "D) 12"},
                'B'
        );

        preguntas[12] = new Pregunta(
                "¿Cuál es el idioma más hablado en el mundo?",
                new String[]{"A) Inglés", "B) Español", "C) Chino mandarín", "D) Árabe"},
                'C'
        );

        preguntas[13] = new Pregunta(
                "¿Qué moneda se usa en Estados Unidos?",
                new String[]{"A) Peso", "B) Euro", "C) Dólar", "D) Libra"},
                'C'
        );

        preguntas[14] = new Pregunta(
                "¿Quién pintó la Mona Lisa?",
                new String[]{"A) Leonardo da Vinci", "B) Picasso", "C) Miguel Ángel", "D) Van Gogh"},
                'A'
        );

        preguntas[15] = new Pregunta(
                "¿Cuántos días tiene un año normal?",
                new String[]{"A) 364", "B) 365", "C) 366", "D) 360"},
                'B'
        );

        preguntas[16] = new Pregunta(
                "¿Cuál es el país más grande del mundo?",
                new String[]{"A) China", "B) Rusia", "C) Canadá", "D) Estados Unidos"},
                'B'
        );

        preguntas[17] = new Pregunta(
                "¿Qué planeta es conocido como el planeta rojo?",
                new String[]{"A) Marte", "B) Venus", "C) Saturno", "D) Júpiter"},
                'A'
        );

        preguntas[18] = new Pregunta(
                "¿Cuál es el metal principal de las monedas de 1 y 2 euros?",
                new String[]{"A) Oro", "B) Plata", "C) Níquel", "D) Cobre"},
                'C'
        );

        preguntas[19] = new Pregunta(
                "¿Qué instrumento tiene teclas blancas y negras?",
                new String[]{"A) Guitarra", "B) Piano", "C) Violín", "D) Flauta"},
                'B'
        );

        return preguntas;
    }
}
