package dam.dual;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;

public class AESFileEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Chave AES (deve ter 16, 24 ou 32 bytes)
        String keyString = "minhaChaveSecreta123"; // 16 bytes (128 bits)
        byte[] keyBytes = keyString.getBytes();
        Key secretKey = new SecretKeySpec(keyBytes, "AES");

        // Arquivo de entrada (dados originais)
        File inputFile = new File("arquivo_original.txt");
        // Arquivo criptografado
        File encryptedFile = new File("arquivo_criptografado.aes");
        // Arquivo descriptografado
        File decryptedFile = new File("arquivo_descriptografado.txt");

        // Criptografar o arquivo
        encryptFile(inputFile, encryptedFile, secretKey);
        System.out.println("Arquivo criptografado com sucesso!");

        // Descriptografar o arquivo
        decryptFile(encryptedFile, decryptedFile, secretKey);
        System.out.println("Arquivo descriptografado com sucesso!");
    }

    // Método para criptografar um arquivo
    public static void encryptFile(File inputFile, File outputFile, Key secretKey) throws Exception {
        // Inicializar o Cipher para criptografia
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Método para descriptografar um arquivo
    public static void decryptFile(File inputFile, File outputFile, Key secretKey) throws Exception {
        // Inicializar o Cipher para descriptografia
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
