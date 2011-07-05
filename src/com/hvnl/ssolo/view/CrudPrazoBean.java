/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudPrazoFacade;
import com.hvnl.ssolo.model.Prazo;

/**
 * Bean do caso de uso cadastrar {@link Prazo}.
 * @author vinicius
 */
public class CrudPrazoBean extends CrudBeanGenerico<Prazo, CrudPrazoFacade> {
	/**
	 * Usuário do sistema.
	 */
	private String usuario;
	
	/**
	 * Senha do usuário.
	 */
	private String senha;
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
	
	public String logar() {
		return "sucesso";
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PRAZO;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
