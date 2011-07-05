/**
 * 
 */
package com.hvnl.ssolo.facade;

import java.util.List;

import com.hvnl.ssolo.model.Atividade;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Transportadora;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Cliente.Pessoa;

/**
 * Modelo da fachada do caso de uso Manter {@link Transportadora}.
 * @author vinicius
 */
public interface CrudTransportadoraFacade extends CrudFacade<Transportadora> {
	
	/**
	 * Listar cidades.
	 * @return lista de cidades conforme o estado selecionado.
	 */
	public List<Cidade> listarCidades(Estado estado);
	
	/**
	 * Listar Estados.
	 * @return lista de estados.
	 */
	public List<Estado> listarEstados();
	
	/**
	 * Listar Atividades.
	 * @return lista de atividades.
	 */
	public List<Atividade> listarAtividades();

	/**
	 * Listar vendedores.
	 * @return lista de vendedores.
	 */
	public List<Usuario> listarVendedores();

	/**
	 * Listar de situações.
	 * @return lista de situações dos model's. 
	 */
	public List<Status> listarStatus();
	
   /**
    * Lista de tipo pessoa (Fisica ou Juridica).
    * @return lista
    */
   List<Pessoa> listarTipoPessoa();

   /**
	 * Estado para iniciar o cadastro.
	 * @param id
	 * @return
	 */
	Estado getEstado(Long id);
   
   /**
    * Cidade para iniciar o cadastro.
    * @param long1
    * @return
    */
   Cidade getCidade(Long id);
}
