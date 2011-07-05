/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudPagamentoFacade;
import com.hvnl.ssolo.model.Pagamento;

/**
 * Bean do caso de uso cadastrar {@link Pagamento}.
 * @author vinicius
 */
public class CrudPagamentoBean extends CrudBeanGenerico<Pagamento, CrudPagamentoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PAGAMENTO;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
