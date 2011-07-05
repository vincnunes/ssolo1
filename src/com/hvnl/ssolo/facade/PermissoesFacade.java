/*
 * 11/11/2009
 */
package com.hvnl.ssolo.facade;

import com.hvnl.ssolo.model.Usuario;

/**
 * Modelo da fachada de permissões.
 * @author heber
 *
 */
public interface PermissoesFacade {

    /**
     * Pega o usuario logado.
     * @return usuario
     */
    Usuario getUsuarioLogado();
}
