/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudImpressaoFacade;
import com.hvnl.ssolo.model.Impressao;

/**
 * Bean do caso de uso cadastrar {@link Impressao}.
 * @author vinicius
 */
public class CrudImpressaoBean extends CrudBeanGenerico<Impressao, CrudImpressaoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_IMPRESSAO;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
