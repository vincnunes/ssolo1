/*
 * 11/09/2009
 */
package com.hvnl.ssolo.facade;

import com.hvnl.ssolo.model.Usuario;

/**
 * Controle do usuário no sistema.
 * @author heber
 */
public interface PegaUsuarioFacade {

    /**
     * Pega o usuário logado no sistema.
     * @return usuário que está no sistema
     */
    Usuario getUsuarioLogado();
}
