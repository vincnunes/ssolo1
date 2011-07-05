/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudGrampoFacade;
import com.hvnl.ssolo.model.Grampo;

/**
 * Bean do caso de uso cadastrar {@link Grampo}.
 * @author vinicius
 */
public class CrudGrampoBean extends CrudBeanGenerico<Grampo, CrudGrampoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_GRAMPO;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
