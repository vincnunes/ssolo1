/*
 * 03/08/2009
 */
package com.hvnl.ssolo.validation;

import java.io.Serializable;

/**
 * Classe que representa uma mensagem de validação.
 * @author heber
 */
public class ValidacaoMensagem implements Serializable {

    /**
     * Mensagem da validação.
     */
    private String mensagem;

    /**
     * Expressão que será utilizada no arquivo properties.
     */
    private String expression;

    /**
     * Argumentos para expressão.
     */
    private String [] argumentos;

    /**
     * Construtor.
     * @param expression Expressão da mensagem
     * @param argumentos Argumentos para expressão
     */
    public ValidacaoMensagem(String expression, String ... argumentos) {
        this.expression = expression;
        this.argumentos = argumentos;
    }

    /**
     * Construtor básico.
     * @param mensagem valor da validação
     */
    public ValidacaoMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String[] getArgumentos() {
        return argumentos;
    }

    public String getExpression() {
        return expression;
    }
}
