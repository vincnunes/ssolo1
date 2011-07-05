/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudLombadaFacade;
import com.hvnl.ssolo.model.Lombada;

/**
 * Bean do caso de uso cadastrar {@link Lombada}.
 * @author vinicius
 */
public class CrudLombadaBean extends CrudBeanGenerico<Lombada, CrudLombadaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_LOMBADA;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
