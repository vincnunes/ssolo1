/*
 * 06/11/2009
 */
package com.hvnl.ssolo.util;

import java.text.Normalizer;
import java.util.StringTokenizer;

/**
 * Funcionalidades comuns para Strings.
 * @author heber
 */
public final class StringHelper {

    /**
     * Private.
     */
    private StringHelper() { }

    /**
     * Formata um nome próprio.
     * @param nome nome a ser formatado
     * @return novo formato
     */
    public static String formataNome(String nome) {
        // Pega a String que sera transformada
        String old = nome;
        // Variavel que apontara para a String que serah formada
        String nov = "";
        // Divide a String em Tokens divididos por ' ' (espaco)
        for (StringTokenizer token = new StringTokenizer(old, " ");
                token.hasMoreTokens();) {
            // Pega o Token em letras minusculas
            String temp = token.nextToken().toLowerCase();
            // Insere um espaco se nao estiver vazio
            if (!nov.trim().equals("")) {
                nov += " ";
            }

            String first = temp.substring(0, 1);

            // Verifica se a String tem mais de tres caracteres
            if (temp.length() > 3) {
                nov += first.toUpperCase() + temp.substring(1);
            // Caso seja apenas uma letra
            } else if (first.length() == 1) {
                nov += temp;
            // Verifica se a String tem dois caracteres e nao comeca com 'd' ou 'e'
            } else if (!first.equals("d") && !first.equals("e")) {
                nov += first.toUpperCase() + temp.substring(1);
            // Coloca a String do jeito que eh
            } else {
                nov += temp;
            }
        }

        return nov;
    }

    /**
     * Executa o {@link Normalizer#normalize(CharSequence, java.text.Normalizer.Form)}, e
     * depois executa {@link String#replaceAll(String, String)} com '[^\\p{ASCII}]'.
     * @param text texto a ser modificado
     * @return String normalizada
     */
    public static String normalizar(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Compara duas Strings.
     * @param s1 primeira
     * @param s2 segunda
     * @return 1 se s1 for maior
     */
    public static int compare(String s1, String s2) {
        int result = 0;

        if (s1 != null) {
            if (s2 != null) {
                result = normalizar(s1).compareToIgnoreCase(normalizar(s2));
            } else {
                result = 1;
            }
        } else if (s2 != null) {
            result = -1;
        }

        return result;
    }
}
