/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudOrcamentoFacade;
import com.hvnl.ssolo.model.Orcamento;

/**
 * Bean do caso de uso cadastrar {@link Orcamento}.
 * @author vinicius
 */
public class CrudOrcamentoBean extends CrudBeanGenerico<Orcamento, CrudOrcamentoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_ORCAMENTO;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
