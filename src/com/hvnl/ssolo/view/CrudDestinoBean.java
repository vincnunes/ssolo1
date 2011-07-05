/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudDestinoFacade;
import com.hvnl.ssolo.model.Destino;

/**
 * Bean do caso de uso cadastrar {@link Destino}.
 * @author vinicius
 */
public class CrudDestinoBean extends CrudBeanGenerico<Destino, CrudDestinoFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_DESTINO;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
