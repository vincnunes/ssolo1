/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudContaFacade;
import com.hvnl.ssolo.model.Conta;

/**
 * Bean do caso de uso cadastrar {@link Conta}.
 * @author vinicius
 */
public class CrudContaBean extends CrudBeanGenerico<Conta, CrudContaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_CONTA;
	}

}
