/*
 * 07/08/2009
 */
package com.hvnl.ssolo.exception;



/**
 * Mapeamento de exceções do DAO.
 * @author heber
 */
public class FacadeException extends Exception {

    /**
     * Construtor.
     * @param e Exceção original
     */
    public FacadeException(Exception e) {
        super(e);
    }

    /**
     * Construtor.
     * @param e Exceção do Business
     */
    public FacadeException(BusinessException e) {
        super(e);
    }

    /**
     * Construtor.
     * @param message Mensagem de erro
     */
    public FacadeException(String message) {
        super(message);
    }
}
