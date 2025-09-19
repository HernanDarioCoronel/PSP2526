package cuestionario;

import javax.management.InstanceAlreadyExistsException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Cuantas preguntas desea responder? (MAX 20)");
            Cuestionario cuestionario = new Cuestionario(sc.nextInt(), BancoPreguntas.obtenerPreguntas());

            cuestionario.comenzar();
            if (cuestionario.resultado()) {
                System.out.println("FELICIDADES!!");
            } else {
                System.out.println("INSACTISFACTORIO");
            }
        } catch (InstanceAlreadyExistsException _) {
        }
        catch (InputMismatchException ex){
            System.out.println("ESO NO ES UN NÚMERO");
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
}
