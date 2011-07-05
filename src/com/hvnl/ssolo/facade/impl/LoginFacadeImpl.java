/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.facade.LoginFacade;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.util.Constants;

/**
 * @author rnunes
 *
 */
@Component("loginFacade")
public class LoginFacadeImpl implements LoginFacade {
	private UsuarioBusiness usuarioBusiness;
	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.LoginFacade#logar(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean logar(String usuario, String senha) {
		Usuario usuarioLogado = usuarioBusiness.getUsuario(usuario, senha);
		FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            return false;
        }
        if (usuarioLogado != null) {
	        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	        session.setAttribute(Constants.USUARIO_LOGADO_DO_SISTEMA, usuarioLogado);
	        return true;
        }
		return false;
	}
	
	@Autowired
	public void setUsuarioBusiness(@Qualifier("usuarioBusiness")UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}
}
