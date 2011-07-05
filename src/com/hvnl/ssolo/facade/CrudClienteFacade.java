/**
 * 
 */
package com.hvnl.ssolo.facade;

import java.util.List;

import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Atividade;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cliente.Pessoa;
import com.hvnl.ssolo.model.Cliente.TipoAssociado;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Transportadora;
import com.hvnl.ssolo.model.Usuario;

/**
 * Modelo da fachada do caso de uso Manter {@link Cliente}.
 * @author vinicius
 */
public interface CrudClienteFacade extends CrudFacade<Cliente> {
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
	 * Lista de tipo pessoa (Fisica ou Juridica).
	 * @return lista de tipo pessoa.
	 */
	List<Pessoa> listarTipoPessoa();
	   
	/**
	 * Listar Transportadoras.
	 * @return lista de transportadoras.
	 */
	List<Transportadora> listarTransportadoras();

	/**
	 * Listar vendedor logado;
	 * @return
	 */
	Usuario listarVendedor();

	/**
	 * Lista de tipo associação (Cliente ou Agência).
	 * @return lista de tipo associação.
	 */
	List<TipoAssociado> listarTipoAssociado();

	/**
	 * Lista de Agências Publicitárias cadastradas.
	 * @return
	 */
	List<AgenciaPublicitaria> listarAgencias();

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
	 * Atualizar dados da Agência Publicitária
	 * @param agencia
	 */
	void atulizarAgencia(AgenciaPublicitaria agencia);
}
