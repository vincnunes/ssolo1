package com.hvnl.ssolo.dao;

import com.hvnl.ssolo.model.Usuario;
/**
 * Interface modelo de DAO {@link Usuario}.
 * @author Ferreira
 *
 */
public interface UsuarioDao extends Dao<Usuario> {

    /**
     * Pega um usuário de acordo com o login e senha informado.
     * @param login login do usuário
     * @param senha senha do usuário
     * @return Usuário selecionado
     */
    Usuario getUsuario(String login, String senha);
}
