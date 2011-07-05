/**
 *
 */
package com.hvnl.ssolo.facade;

import java.util.List;

import org.apache.commons.mail.EmailException;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Arte;
import com.hvnl.ssolo.model.Capa;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cola;
import com.hvnl.ssolo.model.Corte;
import com.hvnl.ssolo.model.Destino;
import com.hvnl.ssolo.model.Dobra;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Frete;
import com.hvnl.ssolo.model.Furo;
import com.hvnl.ssolo.model.Gramatura;
import com.hvnl.ssolo.model.Grampo;
import com.hvnl.ssolo.model.Imposto;
import com.hvnl.ssolo.model.Impressao;
import com.hvnl.ssolo.model.Lombada;
import com.hvnl.ssolo.model.Pagamento;
import com.hvnl.ssolo.model.Pagina;
import com.hvnl.ssolo.model.Papel;
import com.hvnl.ssolo.model.Plastificacao;
import com.hvnl.ssolo.model.Prazo;
import com.hvnl.ssolo.model.Prova;
import com.hvnl.ssolo.model.Servico;
import com.hvnl.ssolo.model.Solicitacao;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Transportadora;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Verniz;

/**
 * Modelo da fachada do caso de uso Manter {@link Solicitacao}.
 * @author vinicius
 */
public interface CrudSolicitacaoFacade extends CrudFacade<Solicitacao> {

    /**
	 * Lista de {@link Cliente} disponíveis no sistema.
	 * @return list<Cliente>
	 */
	List<Cliente> listarCliente();

	/**
	 * Lista de {@link AgenciaPublicitaria} disponíveis no sistema.
	 * @return list<AgenciaPublicitaria>
	 */
	List<AgenciaPublicitaria> listarAgenciaPublicitaria();

	/**
	 * Lista de {@link Transportadora} disponíveis no sistema.
	 * @return list<Transportadora>
	 */
	List<Transportadora> listarTransportadora();

	/**
	 * Lista de {@link Servico} disponíveis no sistema.
	 * @return list<Servico>
	 */
	List<Servico> listarServico();

	/**
	 * Lista de {@link Plastificacao} disponíveis no sistema.
	 * @return list<Plastificacao>
	 */
	List<Plastificacao> listarPlastificacao();

	/**
	 * Lista de {@link Impressao} disponíveis no sistema.
	 * @return list<Impressao>
	 */
	List<Impressao> listarImpressao();

	/**
	 * Lista de {@link Arte} disponíveis no sistema.
	 * @return list<Arte>
	 */
	List<Arte> listarArte();

	/**
	 * Lista de {@link Prova} disponíveis no sistema.
	 * @return list<Prova>
	 */
	List<Prova> listarProva();

	/**
	 * Lista de {@link Dobra} disponíveis no sistema.
	 * @return list<Dobra>
	 */
	List<Dobra> listarDobra();

	/**
	 * Lista de {@link Gramatura} disponíveis no sistema.
	 * @return list<Gramatura>
	 */
	List<Gramatura> listarGramatura();

	/**
	 * Lista de {@link Grampo} disponíveis no sistema.
	 * @return list<Grampo>
	 */
	List<Grampo> listarGrampo();

	/**
	 * Lista de {@link Cola} disponíveis no sistema.
	 * @return list<Cola>
	 */
	List<Cola> listarCola();

	/**
	 * Lista de {@link Corte} disponíveis no sistema.
	 * @return list<Corte>
	 */
	List<Corte> listarCorte();

	/**
	 * Listar {@link Usuario} usuarioLogado.
	 * @return list<Verniz>
	 */
	Usuario listarVendedor();

	/**
	 * Lista de {@link Verniz} disponíveis no sistema.
	 * @return list<Verniz>
	 */
	List<Verniz> listarVerniz();

	/**
	 * Lista de {@link Furo} disponíveis no sistema.
	 * @return list<Furo>
	 */
	List<Furo> listarFuro();

	/**
	 * Lista de {@link Frete} disponíveis no sistema.
	 * @return list<Frete>
	 */
	List<Frete> listarFrete();

	/**
	 * Lista de {@link Pagamento} disponíveis no sistema.
	 * @return list<Pagamento>
	 */
	List<Pagamento> listarPagamento();

	/**
	 * Lista de {@link Prazo} disponíveis no sistema.
	 * @return list<Prazo>
	 */
	List<Prazo> listarPrazo();

	/**
	 * Lista de {@link Imposto} disponíveis no sistema.
	 * @return list<Imposto>
	 */
	List<Imposto> listarImposto();

	/**
	 * Lista de {@link Status} disponíveis no sistema.
	 * @return list<Status>
	 */
	List<Status> listarStatus();

	/**
	 * Lista de {@link Papel} disponíveis no sistema.
	 * @return list<Papel>
	 */
	List<Papel> listarPapel();

	/**
	 * Lista de {@link Destino} disponíveis no sistema.
	 * @return list<Destino>
	 */
	List<Destino> listarDestino();

    /**
     * Lista as cidades de um estado.
     * @param estado filtro
     * @return lista de cidades
     */
    List<Cidade> listarCidades(Estado estado);

    /**
     * Listar Estados.
     * @return lista de estados.
     */
    public List<Estado> listarEstados();

    /**
     * Listar solicitacões finalizadas.
     * @return lista de solicitações finalizadas.
     */
	List<Solicitacao> listarFinalizados();

	/**
	 * Listar quantidade de páginas.
	 * @return lista de quantidade de páginas disponíveis no sistema.
	 */
	List<Pagina> listarPagina();

	/**
	 * Listar modelos de capa de livro.
	 * @return lista de capas de livro.
	 */
	List<Capa> listarCapa();

	/**
	 * Listar de modelos de lombadas de capas de livro.
	 * @return lista de lombadas de capas de livro. 
	 */
	List<Lombada> listarLombada();
	
	/**
	 * Listar vendedores.
	 * @return lista de vendedores. 
	 */	
	List<Usuario> listarVendedores();
	
	/**
     * Finaliza uma solicitacao, persiste e envia email de notificacao.
     * @param selecionado solicitacao que sera finalizada
     * @throws FacadeException caso de erros durante a persistencia
     * @throws EmailException caso de erros durante o envio de email
     */
    void finalizar(Solicitacao selecionado) throws FacadeException, EmailException;

}
