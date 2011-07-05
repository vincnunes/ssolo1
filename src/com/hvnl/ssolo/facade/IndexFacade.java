/**
 * 
 */
package com.hvnl.ssolo.facade;

import java.util.List;

import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Cliente;

/**
 * Modelo da fachada do caso de uso Manter {@link Banco}.
 * @author vinicius
 */
public interface IndexFacade {
	
	/**
	 * Lista de Clientes inadimplentes do Usuario Logado.
	 */
	List<Cliente> listarClientesInadimplentes();
	
	/**
	 * Lista de Agências inadimplentes do Usuario Logado.
	 */
	List<AgenciaPublicitaria> listarAgenciasInadimplentes();
	
}
