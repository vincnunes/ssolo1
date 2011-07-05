/*
 * 18/02/2010
 */
package com.hvnl.ssolo.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Classe responsável por fazer transformações e formatações em números decimais.
 * @author heber
 */
public final class CurrencyHelper {

    /**
     * Formatador numérico.
     */
    private static DecimalFormat currencyFormatter =
        new DecimalFormat("R$ ###,###,##0.00",
                new DecimalFormatSymbols(new Locale("pt", "BR")));

    /**
     * Formatador decimal.
     */
    private static DecimalFormat decimalFormatter =
        new DecimalFormat("###,###,##0.00",
                new DecimalFormatSymbols(new Locale("pt", "BR")));

    /**
     * Privatização do construtor.
     */
    private CurrencyHelper() { }

    /**
     * Transforma uma String em BigDecimal.
     * @param value que será convertida
     * @return valor BigDecimal
     */
    public static BigDecimal getDecimal(String value) {
        String result = getSomenteDigitosPonto(value);

        while (result.indexOf(".") != -1) {
            result = result.replace(".", "");
        }

        result = result.replace(",", ".");

        try {
            return new BigDecimal(result).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        return new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    /**
     * Converte um object em uma String em formato decimal.
     * @param numero a ser convertido
     * @return valor no formato decimal. Se valor for <code>null</code> o resultado é
     * <i>0,00</i>
     */
    public static String getDecimalFormat(Object numero) {
        if (numero == null) {
            return "0,00";
        }

        if (numero instanceof Number) {
            return decimalFormatter.format(((Number) numero).doubleValue());
        }

        return format(numero).replaceAll("R$", "").trim();
    }

    /**
     * Pega somente dígitos, pontos, vírgulas e sinal negativo da String.
     * @param valor que será lido
     * @return somente dígitos, pontos, vírgulas e sinal negativo da String
     */
    public static String getSomenteDigitosPonto(String valor) {

        char [] cs = valor.toCharArray();

        String result = "";

        for (char c : cs) {
            if (Character.isDigit(c) || c == '.' || c == ',' || c == '-') {
                result += c;
            }
        }

        return result;
    }

    /**
     * Converte um object em uma String na máscara moeda.
     * @param numero a ser convertido
     * @return valor na máscara de moeda. Se valor for <code>null</code> o resultado é
     * <i>R$ 0,00</i>
     */
    public static String getCurrencyFormat(Object numero) {

        if (numero == null) {
            return "R$ 0,00";
        }

        if (numero instanceof Number) {
            return currencyFormatter.format(((Number) numero).doubleValue());
        }

        return format(numero);
    }

    /**
     * Formata um objeto para dinheiro.
     * @param numero que será formatado
     * @return objeto.toString() formatado
     */
    public static String format(Object numero) {

        Object value = numero;

        Boolean isNegative = false;
        if (numero instanceof BigDecimal) {
            value = ((BigDecimal) numero).setScale(2, BigDecimal.ROUND_HALF_DOWN);
            isNegative = ((BigDecimal) numero).doubleValue() < 0;
        }

        String ns = "" + value;
        StringTokenizer partes = new StringTokenizer(ns.replace("-", ""), ".");
        String inteiro = partes.nextToken();

        String resultado = getParteInteiraFormatada(inteiro);

        String decimal = "";
        if (partes.hasMoreTokens()) {
            decimal = partes.nextToken();
        }

        return getMask(resultado + "," + adicionaZeros(decimal, 2), isNegative);
    }

    /**
     * Formata a parte inteira do número, separando com pontos cada três dígitos.
     * @param value aonde será aplicada a formatação
     * @return value formatado
     */
    private static String getParteInteiraFormatada(String value) {
        // Pega os primeiros números da sentença, que deve ter apenas 1 ou 2 posições
        String inicio = getInicioNumero(value);
        // Tamanho da primeira sentença
        int tamanho = inicio.length();
        // Separa o restante do valor a partir da posição que já foi contada
        String restante = getNumeroSeparados(value.substring(tamanho));

        // Concatena ambas as partes.
        String resultado = inicio;
        // Verifica se é necessário concatenar um ponto entre as duas partes
        if (tamanho > 0 && !restante.equals("")) {
            resultado += ".";
        }
        // Concatena o restante da String
        resultado += restante;

        return resultado;
    }

    /**
     * Pega a primeira parte do número inteiro.
     * @param valor que será lido e cortado
     * @return String com 1 ou duas posições somente
     */
    private static  String getInicioNumero(String valor) {
        int comeco = valor.length() % 3;
        if (comeco > 0) {
            return valor.substring(0, comeco);
        }

        return "";
    }

    /**
     * Separa os números por "." a cada três posições.
     * @param valor que será dividido
     * @return valor dividido
     */
    private static String getNumeroSeparados(String valor) {

        String resultado = "";

        if (valor.length() >= 3) {
            for (int i = 0; i < valor.length(); i += 3) {

                if (!resultado.equals("")) {
                    resultado += ".";
                }

                resultado += valor.substring(i, i + 3);
            }
        }

        return resultado;
    }

    /**
     * Adiciona 'R$' e o sinal de negativo.
     * @param valor a ser adicionado na máscara
     * @param isNegative se o valor é ou não negativo
     * @return valor transformado
     */
    private static String getMask(String valor, boolean isNegative) {
        return "R$ " + (isNegative ? "-" : "") + valor;
    }

    /**
     * Adiciona ZEROS no número.
     * @param valor onde serão adicionados os ZEROS
     * @param quantidade quantidade que o número deve ter no final.
     * @return número com zeros adicionados
     */
    private static String adicionaZeros(String valor, int quantidade) {
        String result = valor == null ? "" : valor;
        while (result.length() < quantidade) {
            result += "0";
        }
        return result;
    }

    /*
     * Método principal para teste.
     * @param args argumentos
     *
    public static void main(String[] args) {

        for (double i = 0; i < 10000000000L;) {
            System.out.println(CurrencyHelper.getCurrencyFormat(new BigDecimal(i)));

            i = (i + 1) * 10.2;
        }

        System.exit(0);
    }*/

}
