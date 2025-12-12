package pasd;

import java.io.*;

public class MyWriter {
    public static void main(String[] args) {
        String outputFileName = "personas.bin";
        try (ObjectInputStream ois = new ObjectInputStream(System.in)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFileName))) {
                while (true) {
                    try {
                        Persona persona = (Persona) ois.readObject();
                        oos.writeObject(persona);
                    } catch (EOFException e) {
                        break;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
