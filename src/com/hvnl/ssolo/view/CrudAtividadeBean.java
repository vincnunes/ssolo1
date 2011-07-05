/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudAtividadeFacade;
import com.hvnl.ssolo.model.Atividade;

/**
 * Bean do caso de uso cadastrar {@link Atividade}.
 * @author vinicius
 */
public class CrudAtividadeBean extends CrudBeanGenerico<Atividade, CrudAtividadeFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_ATIVIDADE;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
