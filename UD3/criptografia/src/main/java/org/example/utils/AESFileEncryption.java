package org.example.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

public class AESFileEncryption {
    private static final String ALGORITMO = "AES";

    private static final byte[] keyBytes = new byte[16];

    static {
        new SecureRandom().nextBytes(keyBytes);
    }

    public static byte[] cifrar(byte[] data) throws Exception {
        Key key = new SecretKeySpec(keyBytes, ALGORITMO);
        Cipher c = Cipher.getInstance(ALGORITMO);
        c.init(Cipher.ENCRYPT_MODE, key);
        return c.doFinal(data);
    }

}
