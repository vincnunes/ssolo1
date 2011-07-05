/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudEnderecoFacade;
import com.hvnl.ssolo.model.Endereco;

/**
 * Bean do caso de uso cadastrar {@link Endereco}.
 * @author vinicius
 */
public class CrudEnderecoBean extends CrudBeanGenerico<Endereco, CrudEnderecoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_ENDERECO;
	}

}
