/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudStatusFacade;
import com.hvnl.ssolo.model.Status;

/**
 * Bean do caso de uso cadastrar {@link Status}.
 * @author vinicius
 */
public class CrudStatusBean extends CrudBeanGenerico<Status, CrudStatusFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_STATUS;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
