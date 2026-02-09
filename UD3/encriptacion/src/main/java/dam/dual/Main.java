package dam.dual;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPair keyPair = generateRSAKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Generate AES key
        SecretKey aesKey = generateAESKey();

        // Encrypt a file
        String inputFile = "plaintext.txt";
        String encryptedFile = "encrypted.txt";
        encryptFile(inputFile, encryptedFile, aesKey);

        // Encrypt the AES key with RSA public key
        byte[] encryptedAESKey = encryptAESKey(aesKey, publicKey);

        // In a real scenario, you would send the encryptedFile and encryptedAESKey to the recipient

        // Decrypt the AES key with RSA private key
        SecretKey decryptedAESKey = decryptAESKey(encryptedAESKey, privateKey);

        // Decrypt the file
        String decryptedFile = "decrypted.txt";
        decryptFile(encryptedFile, decryptedFile, decryptedAESKey);

        System.out.println("File encryption and decryption completed successfully.");
    }

    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public static void encryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, read);
            }
        }
    }

    public static void decryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
        }
    }

    public static byte[] encryptAESKey(SecretKey aesKey, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(aesKey.getEncoded());
    }

    public static SecretKey decryptAESKey(byte[] encryptedAESKey, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedKeyBytes = cipher.doFinal(encryptedAESKey);
        return new SecretKeySpec(decryptedKeyBytes, "AES");
    }
}
