/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudEmpresaFacade;
import com.hvnl.ssolo.model.Empresa;

/**
 * Bean do caso de uso cadastrar {@link Empresa}.
 * @author vinicius
 */
public class CrudEmpresaBean extends CrudBeanGenerico<Empresa, CrudEmpresaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_EMPRESA;
	}

}
