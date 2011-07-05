/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudCidadeFacade;
import com.hvnl.ssolo.model.Cidade;

/**
 * Bean do caso de uso cadastrar {@link Cidade}.
 * @author vinicius
 */
public class CrudCidadeBean extends
		CrudBeanGenerico<Cidade, CrudCidadeFacade> {
	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_CIDADE;
	}
}
