/*
 * 22/09/2009
 */
package com.hvnl.ssolo.view.util;

import java.lang.reflect.Field;

/**
 * Classe para auxiliar nas validacoes de numeros (CPF, CNPJ, Dígito Verificador etc).
 * @author heber
 */
public final class ValidaHelper {

    /**
     * Tudo estático.
     */
    private ValidaHelper() { }

    /**
     * Verifica se o dígito está correto.
     *
     * @param str texto a ser validado
     * @param peso para o calculo do dígito
     * @return dígito calculado
     */
    public static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        int digito = 0;
        for (int indice = str.length() - 1; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    /**
     * Verifica se o CPF é válido.
     *
     * @param cpf cpf a ser validado
     * @return true se for válido
     */
    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString()
                + digito2.toString());
    }

    /**
     * Verifica se o CNPJ é válido.
     *
     * @param cnpj cnpj a ser validado
     * @return true se for válido
     */
    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString()
                + digito2.toString());
    }

    /**
     * verifica se o digito verificador do processo SPU é valido.
     *
     * @param numero do processo
     * @return verdadeiro ou false
     */
    public static boolean calculaDV(String numero) {

        /*
         * o parametro numero é o código sem pontos e sem o digito verificador (ex:
         * "010101001")
         */
        if (numero == null) {

            return false;
        }

        char[] codigo = numero.toCharArray();

        int y = 9;
        int soma = 0;
        for (int c : codigo) {
            soma += (c - '0') * y--;
        }
        /*for (int i = 1; i < codigo.length; i++) {
            soma += (codigo[i] - '0') * y--;
        }*/
        int resto = soma % 11;

        return resto > 1;
    }

    /**
     * Verifica se os objetos estão vazios.
     * @param object objeto que será avaliado
     * @return true se for tudo vazio
     */
    public static Boolean isEmpty(Object object) {
        Class<?> c = object.getClass();
        for (Field field : c.getDeclaredFields()) {
            if (!isNull(field, object)) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    /**
     * Verifica se o valor do atributo é nulo.
     *
     * @param field Atributo a ser lido
     * @param instance objeto a ser lido
     * @return <code>true</code> para nulo
     */
    public static Boolean isNull(Field field, Object instance) {

        Object o = getValue(field, instance);

        if (o == null) {
            return true;
        }

        if (o instanceof String) {
            return ((String) o).trim().equals("");
        }
        /* else if (o instanceof Number) {
            return ((Number) o).doubleValue() == 0.0;
        }*/

        return false;
    }

    /**
     * Pega o valor de um atributo de um objeto.
     *
     * @param field atributo a ser lido
     * @param instance objeto que contêm o atributo
     * @return valor do atributo
     */
    public static Object getValue(Field field, Object instance) {

        field.setAccessible(true);

        try {
            return field.get(instance);
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
