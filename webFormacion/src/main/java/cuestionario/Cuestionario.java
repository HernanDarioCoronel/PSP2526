package cuestionario;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Cuestionario {
    private ArrayList<Pregunta> preguntas;
    private final boolean[] correctas;

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public boolean[] getCorrectas() {
        return correctas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Cuestionario(int cantidad, Pregunta[] preguntas) throws InstanceAlreadyExistsException, ArrayIndexOutOfBoundsException {
        this.preguntas = new ArrayList<>();
        if (cantidad > BancoPreguntas.obtenerPreguntas().length) {
            throw new ArrayIndexOutOfBoundsException("No Existen tantas preguntas");
        }
        this.correctas = new boolean[cantidad];
        Random rnd = new Random();
        do {
            try {
                this.addPregunta(preguntas[rnd.nextInt(0, preguntas.length)]);
            } catch (InstanceAlreadyExistsException _) {
            }
        } while (this.preguntas.size() < cantidad);
    }

    private void addPregunta(Pregunta pregunta) throws InstanceAlreadyExistsException {
        if (!this.preguntas.contains(pregunta)) {
            this.preguntas.add(pregunta);
        } else {
            throw new InstanceAlreadyExistsException("Pregunta repetida");
        }
    }

    public boolean resultado() {
        int count = 0;
        for (int i = 0; i < preguntas.size(); i++) {
            if (correctas[i]) {
                count++;
            }
        }
        return count >= (preguntas.size() / 2);
    }

    public void comenzar() {
        System.out.println("CUESTIONARIO!\n\n");
        try (Scanner sc = new Scanner(System.in)) {
            AtomicInteger count = new AtomicInteger(1);
            preguntas.forEach(pregunta -> {
                System.out.println(count + "º PREGUNTA:\n");
                System.out.println(pregunta.getPregunta());
                System.out.println("\t" + pregunta.getPosiblesRespuestas()[0]);
                System.out.println("\t" + pregunta.getPosiblesRespuestas()[1]);
                System.out.println("\t" + pregunta.getPosiblesRespuestas()[2]);
                System.out.println("\t" + pregunta.getPosiblesRespuestas()[3]);
                if (pregunta.responder(sc.next().toUpperCase().charAt(0))) {
                    correctas[count.get() - 1] = true;
                    System.out.println("CORRECTO");
                } else {
                    correctas[count.get() - 1] = false;
                    System.out.println("INCORRECTO");
                }
                count.getAndIncrement();
            });
        }
    }
}
