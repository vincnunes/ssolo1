/**
 * 
 */
package com.hvnl.ssolo.facade;

import java.util.List;

import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;

/**
 * Modelo da fachada do caso de uso Manter {@link Usuario}.
 * @author vinicius
 */
public interface CrudUsuarioFacade extends CrudFacade<Usuario> {
	/**
     * Usuario que pretende se logar. 
     * @param usuario
     * @param senha
     * @return usuario se os dados forem corretos.
     */
	Usuario getUsuario(String usuario, String senha);
	
	/**
	 * Estado para iniciar o cadastro.
	 * @param id
	 * @return
	 */
	Estado getEstado(Long id);
	
	/**
	 * Cidade para iniciar o cadastro.
	 * @param id
	 * @return
	 */
	Cidade getCidade(Long id);
	
	/**
	 * Listar estados.
	 * @return Lista de estados.
	 */
	List<Estado> listarEstados();

	/**
	 * Listar cidades.
	 * @param estado a ser consultado.
	 * @return lista de cidades do estado.
	 */
	List<Cidade> listarCidades(Estado estado);
	
	/**
	 * Listar status.
	 * @return lista de status.
	 */
	List<Status> listarStatus();
	
	/**
	 * Lista de perfis (Vendedor, Administrador).
	 * @return lista de perfis.
	 */
	List<PERFIL> listarPerfis();
}
