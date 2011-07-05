/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudVernizFacade;
import com.hvnl.ssolo.model.Verniz;

/**
 * Bean do caso de uso cadastrar {@link Verniz}.
 * @author vinicius
 */
public class CrudVernizBean extends CrudBeanGenerico<Verniz, CrudVernizFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_VERNIZ;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
