/*
 * 11/09/2009
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.PegaUsuarioFacade;
import com.hvnl.ssolo.model.Usuario;

/**
 * Bean para mostrar usuário.
 * @author heber
 */
public class PegaUsuarioBean {

    /**
     * Fachada para obter usuário.
     */
    private PegaUsuarioFacade facade;

    public void setFacade(PegaUsuarioFacade facade) {
        this.facade = facade;
    }

    public Usuario getUsuario() {
        return facade.getUsuarioLogado();
    }
}
