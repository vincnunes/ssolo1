/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudPaginaFacade;
import com.hvnl.ssolo.model.Pagina;

/**
 * Bean do caso de uso cadastrar {@link Pagina}.
 * @author vinicius
 */
public class CrudPaginaBean extends CrudBeanGenerico<Pagina, CrudPaginaFacade> {

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_PAGINA;
	}
	
	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }
}
