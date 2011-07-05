/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudProvaFacade;
import com.hvnl.ssolo.model.Prova;

/**
 * Bean do caso de uso cadastrar {@link Prova}.
 * @author vinicius
 */
public class CrudProvaBean extends CrudBeanGenerico<Prova, CrudProvaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PROVA;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
