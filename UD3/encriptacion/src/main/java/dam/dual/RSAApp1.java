package dam.dual;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RSAApp1 {

    public static void main(String[] args) {

        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair secretKey = keyPairGenerator.generateKeyPair();
            System.out.println(new String(Base64.getEncoder().encode(secretKey.getPrivate().getEncoded())));
            System.out.println(new String(Base64.getEncoder().encode(secretKey.getPublic().getEncoded())));
            String text = "María deu coa lingua nos dentes";

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey.getPublic());
            byte[] cipherText = cipher.doFinal(text.getBytes(), 0, text.getBytes().length);
            System.out.println("Texto en claro");
            System.out.println(text);
            System.out.println("Texto cifrado");
            System.out.println(new String(Base64.getEncoder().encode(cipherText)));

            cipher.init(Cipher.DECRYPT_MODE, secretKey.getPrivate());
            byte[] decipherText = cipher.doFinal(cipherText, 0, cipherText.length);
            System.out.println(new String(decipherText, 0, decipherText.length));

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
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        System.out.println(keyPair);
    }
}