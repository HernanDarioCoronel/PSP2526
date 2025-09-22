import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Calculadora: ");
        String input = scanner.nextLine();
        if (!input.matches("[0-9+\\-*/().^% ]+")) {
            System.out.println("Entrada inválida. Solo se permiten números y símbolos matemáticos.");
            scanner.close();
            return;
        }
        ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-Command", input);

        Process process = processBuilder.start();

        process.getInputStream().transferTo(System.out);
        process.getErrorStream().transferTo(System.err);

        process.waitFor();
        scanner.close();
    }
}
