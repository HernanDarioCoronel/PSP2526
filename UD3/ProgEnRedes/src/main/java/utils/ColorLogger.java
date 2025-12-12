package utils;

public class ColorLogger {

    /**
     * Imprime un mensaje en la consola con el color especificado,
     * seguido de un reseteo de color automático.
     * @param color El color (de utils.AnsiColor enum) que se aplicará al texto.
     * @param message El texto que se va a imprimir.
     */
    public static void printLine(AnsiColor color, String message) {
        // Concatenamos: [CÓDIGO DE COLOR] + [MENSAJE] + [CÓDIGO DE RESET]
        String coloredMessage = color.getCode() + message + AnsiColor.RESET.getCode();

        System.out.println(coloredMessage);
    }

    /**
     * Opcional: Una sobrecarga para imprimir sin salto de línea.
     */
    public static void print(AnsiColor color, String message) {
        String coloredMessage = color.getCode() + message + AnsiColor.RESET.getCode();

        System.out.print(coloredMessage);
    }
}