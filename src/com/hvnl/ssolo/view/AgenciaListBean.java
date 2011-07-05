/**
 * 
 */
package com.hvnl.ssolo.view;

import com.hvnl.ssolo.facade.CrudAgenciaPublicitariaFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;

/**
 * Bean de caso de uso listar.
 * @author rnunes
 *
 */
public class AgenciaListBean 
		extends CrudBeanGenerico<AgenciaPublicitaria, CrudAgenciaPublicitariaFacade> {

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }

	@Override
	protected String getNavegacaoInicial() {
		return Outcome.AGENCIA_LISTAR;
	}
	
	public String consultar() {
		iniciar();
    	return Outcome.AGENCIA_LISTAR;
    }
}
