/**
 * 
 */
package com.hvnl.ssolo.facade;

import java.util.List;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Atividade;
import com.hvnl.ssolo.model.Banco;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cliente.Pessoa;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Usuario;

/**
 * Modelo da fachada do caso de uso Manter {@link AgenciaPublicitaria}.
 * @author vinicius
 */
public interface CrudAgenciaPublicitariaFacade extends CrudFacade<AgenciaPublicitaria> {

	/**
	 * Listar cidades.
	 * @return lista de cidades conforme o estado selecionado.
	 */
	List<Cidade> listarCidades(Estado estado);
	
	/**
	 * Listar Estados.
	 * @return lista de estados.
	 */
	List<Estado> listarEstados();
	
	/**
	 * Listar Atividades.
	 * @return lista de atividades.
	 */
	List<Atividade> listarAtividades();
	
	/**
	 * Listar vendedores.
	 * @return lista de vendedores.
	 */
	List<Usuario> listarVendedores();
	
	/**
	 * Listar de situações.
	 * @return lista de situações dos model's. 
	 */
	List<Status> listarStatus();
	
	/**
	 * Listar de bancos.
	 * @return lista de bancos dos model's. 
	 */
	List<Banco> listarBancos();
	
	/**
	 * Lista de tipo pessoa (Fisica ou Juridica).
	 * @return lista
	 */
	List<Pessoa> listarTipoPessoa();

	/**
	 * Listar vendedor logado.
	 * @return
	 */
	Usuario listarVendedor();
	
	/**
	 * Lista de associados da agência.
	 * @param selecionado
	 * @return
	 */
	List<Cliente> listarAssociados(AgenciaPublicitaria selecionado) throws FacadeException;
	
	/**
	 * Lista de clientes do vendedor.
	 * @return
	 */
	List<Cliente> listarClientes() throws FacadeException;
	
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
	 * Status para iniciar o cadastro.
	 * @param id
	 * @return
	 */
	Status getStatus(Long id);
	
	/**
	 * Atualizar cliente informando q ele é associado da agência.
	 * @param cliente
	 */
	void atualizarCliente(Cliente cliente);
}