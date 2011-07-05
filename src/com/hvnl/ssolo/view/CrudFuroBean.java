/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudFuroFacade;
import com.hvnl.ssolo.model.Furo;

/**
 * Bean do caso de uso cadastrar {@link Furo}.
 * @author vinicius
 */
public class CrudFuroBean extends CrudBeanGenerico<Furo, CrudFuroFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_FURO;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
