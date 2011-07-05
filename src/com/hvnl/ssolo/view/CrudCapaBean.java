/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudCapaFacade;
import com.hvnl.ssolo.model.Capa;

/**
 * Bean do caso de uso cadastrar {@link Capa}.
 * @author vinicius
 */
public class CrudCapaBean extends CrudBeanGenerico<Capa, CrudCapaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_CAPA;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
