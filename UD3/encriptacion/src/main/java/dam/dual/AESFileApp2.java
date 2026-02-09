package dam.dual;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public class AESFileApp2 {

    private static final int IV_SIZE = 16;
    private static final String FILE_NAME = "aesfile.key";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        try {
//            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
//            SecretKey secretKey = keyGenerator.generateKey();
//            System.out.println(new String(Base64.getEncoder().encode(secretKey.getEncoded())));
//            Files.write(Path.of(FILE_NAME), secretKey.getEncoded());

            byte[] keyBuffer = Files.readAllBytes(Path.of(FILE_NAME));
            SecretKey key = new SecretKeySpec(keyBuffer, ALGORITHM);
            System.out.println(new String(Base64.getEncoder().encode(key.getEncoded())));

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            byte [] bytes = new byte[IV_SIZE];
            new SecureRandom().nextBytes(bytes);
            IvParameterSpec iv = new IvParameterSpec(bytes);

            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte [] cipherText = cipher.doFinal("este texto encríptase con AES".getBytes(StandardCharsets.UTF_8));
            System.out.println(new String(Base64.getEncoder().encode(cipherText)));

            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            System.out.println(new String(cipher.doFinal(cipherText)));


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }
}
