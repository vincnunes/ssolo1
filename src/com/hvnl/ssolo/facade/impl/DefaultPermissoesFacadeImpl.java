/*
 * 04/12/2009
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.facade.PermissoesFacade;
import com.hvnl.ssolo.model.Usuario;

/**
 * Implementação default da fachada PermissoesFacade.
 * @author heber
 */
@Component("defaultPermissoesFacade")
public class DefaultPermissoesFacadeImpl implements PermissoesFacade {

    /**
     * Business de usuário.
     */
    @Autowired
    @Qualifier("usuarioLogadoBusiness")
    private UsuarioLogadoBusiness usuarioBusiness;

    /** {@inheritDoc} */
    public Usuario getUsuarioLogado() {
        return usuarioBusiness.getUsuarioLogado();
    }

    public void setUsuarioBusiness(UsuarioLogadoBusiness usuarioBusiness) {
        this.usuarioBusiness = usuarioBusiness;
    }
}
