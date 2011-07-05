package com.hvnl.ssolo.business;

import com.hvnl.ssolo.model.Usuario;

/**
 * Interface de negocio de {@link Usuario}.
 *
 * @author Ferreira
 *
 */
public interface UsuarioBusiness extends Business<Usuario> {

    /**
     * Usuario que pretende se logar. 
     * @param usuario
     * @param senha
     * @return usuario se os dados forem corretos.
     */
	Usuario getUsuario(String usuario, String senha);
}
