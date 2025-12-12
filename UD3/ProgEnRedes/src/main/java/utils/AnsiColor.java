package utils;

public enum AnsiColor {
    // Definiciones de colores de primer plano (texto)
    ROJO("\u001B[31m"),
    VERDE("\u001B[32m"),
    AMARILLO("\u001B[33m"),
    AZUL("\u001B[34m"),
    CIAN("\u001B[36m"),
    MAGENTA("\u001B[35m"),
    BLANCO("\u001B[37m"),
    NEGRO("\u001B[30m"),

    // Códigos especiales
    RESET("\u001B[0m");

    private final String code;

    AnsiColor(String code) {
        this.code = code;
    }

    // Método para obtener el código ANSI real
    public String getCode() {
        return code;
    }
}