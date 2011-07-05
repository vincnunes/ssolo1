/*
 * 03/08/2009
 */
package com.hvnl.ssolo.exception;

import java.util.ArrayList;
import java.util.List;

import com.hvnl.ssolo.validation.ValidacaoMensagem;


/**
 * Classe que representa um erro de validação do sistema.
 * @author heber
 */
public class ValidacaoException extends Exception {

    /**
     * Mensagens da exceção.
     */
    private List<ValidacaoMensagem> mensagens;

    /**
     * Construtor que já recebe a mensagem de erro.
     * @param mensagem mensagem da exceção
     */
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor que já recebe a mensagem de erro.
     * @param mensagem Mensagem da exceção
     */
    public ValidacaoException(ValidacaoMensagem mensagem) {
        List<ValidacaoMensagem> mensagens = new ArrayList<ValidacaoMensagem>();
        mensagens.add(mensagem);
        this.mensagens = mensagens;
    }

    /**
     * Construtor que já recebe a mensagem de erro.
     * @param mensagens Mensagens da exceção
     */
    public ValidacaoException(List<ValidacaoMensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<ValidacaoMensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<ValidacaoMensagem> mensagens) {
        this.mensagens = mensagens;
    }
}
