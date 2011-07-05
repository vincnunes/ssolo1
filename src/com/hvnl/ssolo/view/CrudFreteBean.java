/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudFreteFacade;
import com.hvnl.ssolo.model.Frete;

/**
 * Bean do caso de uso cadastrar {@link Frete}.
 * @author vinicius
 */
public class CrudFreteBean extends CrudBeanGenerico<Frete, CrudFreteFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_FRETE;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
