public class App {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe", "datos.txt");
        Process dir = pb.start();
        dir.getInputStream().transferTo(System.out);
        dir.waitFor();
        System.out.println("El proceso ha finalizado");
    }
}
