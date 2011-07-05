/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudDobraFacade;
import com.hvnl.ssolo.model.Dobra;

/**
 * Bean do caso de uso cadastrar {@link Dobra}.
 * @author vinicius
 */
public class CrudDobraBean extends CrudBeanGenerico<Dobra, CrudDobraFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_DOBRA;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
