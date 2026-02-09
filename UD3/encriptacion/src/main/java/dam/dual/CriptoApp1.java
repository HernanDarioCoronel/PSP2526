package dam.dual;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class CriptoApp1 {

    private static Logger logger = Logger.getLogger(CriptoApp1.class.getName());
    private static String WELCOME = "App de criptografia a correr";
    private static int KEY_LENGHT = 256;
    private static int T_LENGHT = 128;
    private static SecretKey key;

    public static void main(String[] args) {

        logger.info(WELCOME);
        try {
            byte[] iv = new byte[12];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);
            GCMParameterSpec spec = new GCMParameterSpec(T_LENGHT, iv);

            byte[] message = new byte[1024];
            final String msgStr = "Esta é a mensaxe que se vai encriptar co AES";
            logger.info(msgStr.concat(" \r\n").concat(new String(String.valueOf(msgStr.length()))));
            message = msgStr.getBytes(StandardCharsets.UTF_8);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(KEY_LENGHT);
            key = keyGenerator.generateKey();
            Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
            encryptionCipher.init(Cipher.ENCRYPT_MODE, key, spec);
            byte[] encryptedBytes = encryptionCipher.doFinal(message);

            logger.info(new String(encryptedBytes));
            encryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
            byte[] decryptedBytes = encryptionCipher.doFinal(encryptedBytes);
            logger.info(new String(decryptedBytes));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }
}
