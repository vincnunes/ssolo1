package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.dao.UsuarioDao;
import com.hvnl.ssolo.model.Usuario;

/**
 * Implementacao da camada de negocio [{@link usuario}.
 *
 * @author Ferreira
 *
 */
@Component("usuarioBusiness")
public class UsuarioBusinessImpl extends BusinessGenerico<Usuario, UsuarioDao> 
		implements UsuarioBusiness {

    @Override
    public Usuario getUsuario(String usuario, String senha) {
    	return getDao().getUsuario(usuario, senha);
    }

    @Override
    @Autowired
    public void setDao(@Qualifier("usuarioDao") UsuarioDao dao) {
    	super.setDao(dao);
    }
}
