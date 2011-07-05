/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudEstadoFacade;
import com.hvnl.ssolo.model.Estado;

/**
 * Bean do caso de uso cadastrar {@link Estado}.
 * @author vinicius
 */
public class CrudEstadoBean extends CrudBeanGenerico<Estado, CrudEstadoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_ESTADO;
	}

}
