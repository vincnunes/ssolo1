/**
 * 
 */
package com.hvnl.ssolo.view;

import java.util.List;

import com.hvnl.ssolo.facade.IndexFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Verniz;

/**
 * Bean do caso de uso cadastrar {@link Verniz}.
 * @author vinicius
 */
public class IndexBean {
	/**
	 * Fachada do index.
	 */
	private IndexFacade indexFacade;
	
	/**
	 * Permissões do usuário.
	 */
	private PermissoesBean permissoes;
	
	/**
	 * Lista de Clientes Inadimplentes do usuário logado.
	 */
	private List<Cliente> listaClientesInadinplentes;
	
	/**
	 * Lista de Agencias Inadimplentes do usuário logado.
	 */
	private List<AgenciaPublicitaria> listaAgenciasInadinplentes;
	
	public List<Cliente> getListaClientesInadimplentes() {
		if(listaClientesInadinplentes == null) {
			listaClientesInadinplentes = indexFacade.listarClientesInadimplentes();
		}
		
		return listaClientesInadinplentes;
	}
	
	public List<AgenciaPublicitaria> getListaAgenciasInadimplentes() {
		if(listaAgenciasInadinplentes == null) {
			listaAgenciasInadinplentes = indexFacade.listarAgenciasInadimplentes();
		}
		
		return listaAgenciasInadinplentes;
	}
	
	public void setIndexFacade(IndexFacade indexFacade) {
		this.indexFacade = indexFacade;
	}
	
	public void setPermissoes(PermissoesBean permissoes) {
		this.permissoes = permissoes;
	}
	
	public Boolean getPermissaoCliente() {
		if(!getListaClientesInadimplentes().isEmpty() && permissoes.getListaInadimplentes().getVer()) {
			return true;
		}
		
		return false;
	}
	
	public Boolean getPermissaoAgencia() {
		if(!getListaAgenciasInadimplentes().isEmpty() && permissoes.getListaInadimplentes().getVer()) {
			return true;
		}
		
		return false;
	}
}
