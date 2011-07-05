/*
 * 11/09/2009
 */
package com.hvnl.ssolo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.facade.PegaUsuarioFacade;
import com.hvnl.ssolo.model.Usuario;

/**
 * Implementação da fachada para pegar usuário.
 * @author heber
 */
@Component("pegaUsuarioFacade")
public class PegaUsuarioFacadeImpl implements PegaUsuarioFacade {

    /**
     * Business do Usuário.
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
