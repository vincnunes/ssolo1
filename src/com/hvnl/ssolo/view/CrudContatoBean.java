/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudContatoFacade;
import com.hvnl.ssolo.model.Contato;

/**
 * Bean do caso de uso cadastrar {@link Contato}.
 * @author vinicius
 */
public class CrudContatoBean extends CrudBeanGenerico<Contato, CrudContatoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_CONTATO;
	}

}
