/*
 * 28/10/2009
 */
package com.hvnl.ssolo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.catalina.util.Base64;

/**
 * Classe util de criptografia.
 * @author heber
 */
public final class Crypter {

    /**
     * Construtor.
     */
    private Crypter() { }

    /**
     * Encriptografa a senha.
     * @param senha que será transformada
     * @return senha criptografada
     * @throws NoSuchAlgorithmException caso dê problemas com o algoritmo
     */
    public static String encrypt(String senha) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(senha.getBytes());

        return new String(Base64.encode(digest.digest()));

        /*BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(digest.digest());*/
    }

}
