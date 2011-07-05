/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.LoginFacade;
import com.hvnl.ssolo.model.Verniz;

/**
 * Bean do caso de uso cadastrar {@link Verniz}.
 * @author vinicius
 */
public class LoginBean extends BaseBean {
	private LoginFacade loginFacade;
	
	/**
	 * Usuário do sistema.
	 */
	private String usuario;
	
	/**
	 * Senha do usuário.
	 */
	private String senha;
	
	public String logar() {
		if (loginFacade.logar(usuario, senha)) {
			return Outcome.SUCCESS;
		}
		return Outcome.ERROR;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setLoginFacade(LoginFacade loginFacade) {
		this.loginFacade = loginFacade;
	}

	@Override
	public String iniciar() {
		return "login";
	}
}
