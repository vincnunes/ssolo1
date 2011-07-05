/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudCorteFacade;
import com.hvnl.ssolo.model.Corte;

/**
 * Bean do caso de uso cadastrar {@link Corte}.
 * @author vinicius
 */
public class CrudCorteBean extends CrudBeanGenerico<Corte, CrudCorteFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_CORTE;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
