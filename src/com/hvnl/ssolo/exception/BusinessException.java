/*
 * 07/08/2009
 */
package com.hvnl.ssolo.exception;



/**
 * Mapeamento de exceções do DAO.
 * @author heber
 */
public class BusinessException extends Exception {

    /**
     * Construtor.
     * @param e Exceção original
     */
    public BusinessException(Exception e) {
        super(e);
    }

    /**
     * Construtor.
     * @param e Exceção de Dao
     */
    public BusinessException(DaoException e) {
        super(e);
    }

    /**
     * Construtor.
     * @param message Mensagem de erro
     */
    public BusinessException(String message) {
        super(message);
    }
}
