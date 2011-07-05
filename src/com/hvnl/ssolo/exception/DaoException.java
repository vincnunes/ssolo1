/*
 * 07/08/2009
 */
package com.hvnl.ssolo.exception;

import java.sql.SQLException;



/**
 * Mapeamento de exceções do DAO.
 * @author heber
 */
public class DaoException extends Exception {

    /**
     * Construtor.
     * @param e Exceção original
     */
    public DaoException(SQLException e) {
        super(e);
    }

    /**
     * Construtor.
     * @param message Mensagem de erro
     */
    public DaoException(String message) {
        super(message);
    }
}
