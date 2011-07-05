/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudServicoFacade;
import com.hvnl.ssolo.model.Servico;

/**
 * Bean do caso de uso cadastrar {@link Servico}.
 * @author vinicius
 */
public class CrudServicoBean extends CrudBeanGenerico<Servico, CrudServicoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_SERVICO;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
