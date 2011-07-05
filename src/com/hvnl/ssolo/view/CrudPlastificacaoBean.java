/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudPlastificacaoFacade;
import com.hvnl.ssolo.model.Plastificacao;

/**
 * Bean do caso de uso cadastrar {@link Plastificacao}.
 * @author vinicius
 */
public class CrudPlastificacaoBean extends CrudBeanGenerico<Plastificacao, CrudPlastificacaoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PLASTIFICACAO;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
