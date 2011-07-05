/**
 *
 */
package com.hvnl.ssolo.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AgenciaPublicitariaBusiness;
import com.hvnl.ssolo.business.ArteBusiness;
import com.hvnl.ssolo.business.CapaBusiness;
import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.business.ClienteBusiness;
import com.hvnl.ssolo.business.ColaBusiness;
import com.hvnl.ssolo.business.CorteBusiness;
import com.hvnl.ssolo.business.DestinoBusiness;
import com.hvnl.ssolo.business.DobraBusiness;
import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.business.FreteBusiness;
import com.hvnl.ssolo.business.FuroBusiness;
import com.hvnl.ssolo.business.GramaturaBusiness;
import com.hvnl.ssolo.business.GrampoBusiness;
import com.hvnl.ssolo.business.ImpostoBusiness;
import com.hvnl.ssolo.business.ImpressaoBusiness;
import com.hvnl.ssolo.business.LombadaBusiness;
import com.hvnl.ssolo.business.PagamentoBusiness;
import com.hvnl.ssolo.business.PaginaBusiness;
import com.hvnl.ssolo.business.PapelBusiness;
import com.hvnl.ssolo.business.PlastificacaoBusiness;
import com.hvnl.ssolo.business.PrazoBusiness;
import com.hvnl.ssolo.business.ProvaBusiness;
import com.hvnl.ssolo.business.ServicoBusiness;
import com.hvnl.ssolo.business.SolicitacaoBusiness;
import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.business.TransportadoraBusiness;
import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.business.VernizBusiness;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.facade.CrudSolicitacaoFacade;
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
import com.hvnl.ssolo.model.Model;
import com.hvnl.ssolo.model.Pagamento;
import com.hvnl.ssolo.model.Pagina;
import com.hvnl.ssolo.model.Papel;
import com.hvnl.ssolo.model.Plastificacao;
import com.hvnl.ssolo.model.Prazo;
import com.hvnl.ssolo.model.Prova;
import com.hvnl.ssolo.model.Servico;
import com.hvnl.ssolo.model.Solicitacao;
import com.hvnl.ssolo.model.SolicitacaoLocalEntrega;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Transportadora;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;
import com.hvnl.ssolo.model.Verniz;
import com.hvnl.ssolo.util.Constants;

/**
 * Implementacao da fachada do caso de uso Manter {@link Solicitacao}.
 * @author vinicius
 */
@Component("crudSolicitacaoFacade")
public class CrudSolicitacaoFacadeImpl extends CrudFacadeGenerico<Solicitacao, SolicitacaoBusiness>
			implements CrudSolicitacaoFacade {

	private ClienteBusiness clienteBusiness;
	
	private CapaBusiness capaBusiness;
	
	private LombadaBusiness lombadaBusiness;

	private UsuarioBusiness usuarioBusiness;
	
	private UsuarioLogadoBusiness usuarioLogadoBusiness;

	private AgenciaPublicitariaBusiness agenciaPublicitariaBusiness;

	private TransportadoraBusiness transportadoraBusiness;

	private ServicoBusiness servicoBusiness;

	private PlastificacaoBusiness plastificacaoBusiness;

	private ImpressaoBusiness impressaoBusiness;

	private ArteBusiness arteBusiness;

	private ProvaBusiness provaBusiness;

	private DobraBusiness dobraBusiness;

	private GramaturaBusiness gramaturaBusiness;

	private GrampoBusiness grampoBusiness;

	private ColaBusiness colaBusiness;

	private CorteBusiness corteBusiness;

	private VernizBusiness vernizBusiness;

	private FuroBusiness furoBusiness;

	private FreteBusiness freteBusiness;
	
	private PaginaBusiness paginaBusiness;

	private PagamentoBusiness pagamentoBusiness;

	private PrazoBusiness prazoBusiness;

	private ImpostoBusiness impostoBusiness;

	private StatusBusiness statusBusiness;

	private PapelBusiness papelBusiness;

	private DestinoBusiness destinoBusiness;

	/**
     * Cidade do endereço do Cliente.
     */
    private CidadeBusiness cidadeBusiness;

    /**
     * Estado do endereço do Cliente.
     */
    private EstadoBusiness estadoBusiness;

	@Override
    @Autowired
	public void setBusiness(@Qualifier("solicitacaoBusiness") SolicitacaoBusiness business) {
		super.setBusiness(business);
	}

	@Autowired
    public void setCidadeBusiness(@Qualifier("cidadeBusiness") CidadeBusiness cidadeBusiness) {
        this.cidadeBusiness = cidadeBusiness;
    }

	@Autowired
    public void setCapaBusiness(@Qualifier("capaBusiness") CapaBusiness capaBusiness) {
        this.capaBusiness = capaBusiness;
    }
	
	@Autowired
    public void setLombadaBusiness(@Qualifier("lombadaBusiness") LombadaBusiness lombadaBusiness) {
        this.lombadaBusiness = lombadaBusiness;
    }
	
    @Autowired
    public void setEstadoBusiness(@Qualifier("estadoBusiness") EstadoBusiness estadoBusiness) {
        this.estadoBusiness = estadoBusiness;
    }

    @Autowired
    public void setUsuarioBusiness(@Qualifier("usuarioBusiness") UsuarioBusiness usuarioBusiness) {
        this.usuarioBusiness = usuarioBusiness;
    }
    
	@Autowired
    public void setUsuarioLogadoBusiness(@Qualifier("usuarioLogadoBusiness") UsuarioLogadoBusiness business) {
        this.usuarioLogadoBusiness = business;
    }

	@Autowired
    public void setClienteBusiness(@Qualifier("clienteBusiness") ClienteBusiness clienteBusiness) {
    	this.clienteBusiness = clienteBusiness;
    }

    @Autowired
    public void setAgenciaPublicitariaBusiness(@Qualifier("agenciaPublicitariaBusiness")
    				AgenciaPublicitariaBusiness agenciaPublicitariaBusiness) {
    	this.agenciaPublicitariaBusiness = agenciaPublicitariaBusiness;
    }

    @Autowired
    public void setTransportadoraBusiness(@Qualifier("transportadoraBusiness")
    		TransportadoraBusiness transportadoraBusiness) {
    	this.transportadoraBusiness = transportadoraBusiness;
    }

    @Autowired
    public void setServicoBusiness(@Qualifier("servicoBusiness") ServicoBusiness servicoBusiness) {
    	this.servicoBusiness = servicoBusiness;
    }

    /** {@inheritDoc} */
    @Autowired
    public void setPaginaBusiness(@Qualifier("paginaBusiness")
    								PaginaBusiness paginaBusiness) {
    	this.paginaBusiness = paginaBusiness;
    }
    
    /** {@inheritDoc} */
    @Autowired
    public void setPlastificacaoBusiness(@Qualifier("plastificacaoBusiness")
    								PlastificacaoBusiness plastificacaoBusiness) {
    	this.plastificacaoBusiness = plastificacaoBusiness;
    }

    @Autowired
    public void setImpressaoBusiness(@Qualifier("impressaoBusiness")
    		ImpressaoBusiness impressaoBusiness) {
    	this.impressaoBusiness = impressaoBusiness;
    }

    @Autowired
    public void setArteBusiness(@Qualifier("arteBusiness") ArteBusiness arteBusiness) {
    	this.arteBusiness = arteBusiness;
    }

    @Autowired
    public void setProvaBusiness(@Qualifier("provaBusiness") ProvaBusiness provaBusiness) {
    	this.provaBusiness = provaBusiness;
    }

    @Autowired
    public void setDobraBusiness(@Qualifier("dobraBusiness") DobraBusiness dobraBusiness) {
    	this.dobraBusiness = dobraBusiness;
    }

    @Autowired
    public void setGramaturaBusiness(@Qualifier("gramaturaBusiness") GramaturaBusiness gramaturaBusiness) {
    	this.gramaturaBusiness = gramaturaBusiness;
    }

    @Autowired
    public void setGrampoBusiness(@Qualifier("grampoBusiness") GrampoBusiness grampoBusiness) {
    	this.grampoBusiness = grampoBusiness;
    }

    @Autowired
    public void setColaBusiness(@Qualifier("colaBusiness") ColaBusiness colaBusiness) {
    	this.colaBusiness = colaBusiness;
    }

    @Autowired
    public void setCorteBusiness(@Qualifier("corteBusiness") CorteBusiness corteBusiness) {
    	this.corteBusiness = corteBusiness;
    }

    @Autowired
    public void setVernizBusiness(@Qualifier("vernizBusiness") VernizBusiness vernizBusiness) {
    	this.vernizBusiness = vernizBusiness;
    }

    @Autowired
    public void setFuroBusiness(@Qualifier("furoBusiness") FuroBusiness furoBusiness) {
    	this.furoBusiness = furoBusiness;
    }

    @Autowired
    public void setFreteBusiness(@Qualifier("freteBusiness") FreteBusiness freteBusiness) {
    	this.freteBusiness = freteBusiness;
    }

    @Autowired
    public void setPagamentoBusiness(@Qualifier("pagamentoBusiness") PagamentoBusiness pagamentoBusiness) {
    	this.pagamentoBusiness = pagamentoBusiness;
    }

    @Autowired
    public void setPrazoBusiness(@Qualifier("prazoBusiness") PrazoBusiness prazoBusiness) {
    	this.prazoBusiness = prazoBusiness;
    }

    @Autowired
    public void setImpostoBusiness(@Qualifier("impostoBusiness") ImpostoBusiness impostoBusiness) {
    	this.impostoBusiness = impostoBusiness;
    }

    @Autowired
    public void setStatusBusiness(@Qualifier("statusBusiness") StatusBusiness statusBusiness) {
    	this.statusBusiness = statusBusiness;
    }

    @Autowired
    public void setPapelBusiness(@Qualifier("papelBusiness") PapelBusiness papelBusiness) {
    	this.papelBusiness = papelBusiness;
    }

    @Autowired
    public void setDestinoBusiness(@Qualifier("destinoBusiness") DestinoBusiness destinoBusiness) {
    	this.destinoBusiness = destinoBusiness;
    }
    
    @Override
    public List<Solicitacao> filtrar(Solicitacao model,
    		String... camposOrdenacao) throws FacadeException {
    	Usuario usuario = usuarioLogadoBusiness.getUsuarioLogado();
    	if (usuario.getPerfil().compareTo(PERFIL.VENDEDOR) == 0) {
	    	model.setVendedor(usuario);
	    	return super.filtrar(model, camposOrdenacao);
    	} else {
    		return super.filtrar(model, camposOrdenacao);
    	}
    }
    
    @Override
    public List<Arte> listarArte() {
    	try {
    		return arteBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
    }

    public List<Servico> listarServico() {
    	try {
    		return servicoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
    }
    
    public List<Capa> listarCapa() {
    	try {
    		return capaBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
    }
    
    public List<Lombada> listarLombada() {
    	try {
    		return lombadaBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
    }

	@Override
	public List<Cliente> listarCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setVendedor(usuarioLogadoBusiness.getUsuarioLogado());
			
			List<Cliente> lista = new ArrayList<Cliente>();
			
			if (cliente.getVendedor().getPerfil().compareTo(PERFIL.ADMINISTRADOR) == 0) {
				lista = clienteBusiness.listar();
			} else {
				List<Cliente> clientes = new ArrayList<Cliente>();
				clientes = clienteBusiness.listar(cliente);
				for (Cliente cli : clientes) {
					if (cli.getSituacao().getStatus().getNome().equals("Ativo")) {
						lista.add(cli);
					}
				}
			}
    		return lista;
    	} catch (BusinessException e) {
    		e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarAgenciaPublicitaria()
	 */
	@Override
	public List<AgenciaPublicitaria> listarAgenciaPublicitaria() {
		try {
			return agenciaPublicitariaBusiness.listar();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private String endereco(Model model) {
		if (model instanceof Cliente) {
			return ((Cliente)model).getDados().getEndereco().getLogradouro() + ", " +
			((Cliente)model).getDados().getEndereco().getNumero();
		} else if (model instanceof AgenciaPublicitaria) {
			return ((AgenciaPublicitaria)model).getDados().getEndereco().getLogradouro() + ", " +
			((AgenciaPublicitaria)model).getDados().getEndereco().getNumero();
		}
		return null;
	}
	
	private String bairro(Model model) {
		if (model instanceof Cliente) {
			return ((Cliente)model).getDados().getEndereco().getBairro();
		} else if (model instanceof AgenciaPublicitaria) {
			return ((AgenciaPublicitaria)model).getDados().getEndereco().getBairro();
		}
		return null;
	}
	
	private String cep(Model model) {
		if (model instanceof Cliente) {
			return ((Cliente)model).getDados().getEndereco().getCep();
		} else if (model instanceof AgenciaPublicitaria) {
			return ((AgenciaPublicitaria)model).getDados().getEndereco().getCep();
		}
		return null;
	}
	
	private String pontoReferencia(Model model) {
		if (model instanceof Cliente) {
			return ((Cliente)model).getDados().getEndereco().getPontoReferencia();
		} else if (model instanceof AgenciaPublicitaria) {
			return ((AgenciaPublicitaria)model).getDados().getEndereco().getPontoReferencia();
		}
		return null;
	}
	
	private Cidade cidade(Model model) {
		if (model instanceof Cliente) {
			return ((Cliente)model).getDados().getEndereco().getCidade();
		} else if (model instanceof AgenciaPublicitaria) {
			return ((AgenciaPublicitaria)model).getDados().getEndereco().getCidade();
		}
		return null;
	}
	
	private StringBuffer montaLocaisEntrega(Solicitacao selecionado) {
		StringBuffer mensagem = new StringBuffer();
		Boolean cliente = selecionado.getCliente() != null;
		
		Boolean locaisEntrega = selecionado.getLocaisEntrega() != null && !selecionado.getLocaisEntrega().isEmpty();
		
		if (!locaisEntrega) {
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Endere&ccedil;o:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>" + (cliente ? endereco(selecionado.getCliente()) : endereco(selecionado.getAgencia())) + "</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Bairro:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>" + (cliente ? bairro(selecionado.getCliente()) : bairro(selecionado.getAgencia())) + "</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Cidade:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>" + (cliente ? cidade(selecionado.getCliente()).getNome() : cidade(selecionado.getAgencia()).getNome()) + "</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Estado:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>" + (cliente ? cidade(selecionado.getCliente()).getEstado().getNome() : cidade(selecionado.getAgencia()).getEstado().getNome()) + "</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>CEP:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>" + (cliente ? cep(selecionado.getCliente()) : cep(selecionado.getAgencia())) + "</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0; padding: 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Ponto de Refer&ecirc;ncia:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%; min-height: 100px; padding: 0 0 0 150px; text-align: justify;\">\n");
			mensagem.append("				<span style=\"\">" + (cliente ? pontoReferencia(selecionado.getCliente()) : pontoReferencia(selecionado.getAgencia())) + "</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
		} else if (!locaisEntrega) {
			int i = 1;
			for (SolicitacaoLocalEntrega local : selecionado.getLocaisEntrega()) {
				mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>Local de Entrega " + i + ":</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
				mensagem.append("				<span>" + local.getAssociado().getDados().getNomeFantasia() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>Endere&ccedil;o:</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
				mensagem.append("				<span>" + local.getAssociado().getDados().getEndereco().getLogradouro() + ", " + local.getAssociado().getDados().getEndereco().getNumero() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>Bairro:</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
				mensagem.append("				<span>" + local.getAssociado().getDados().getEndereco().getBairro() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>Cidade:</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
				mensagem.append("				<span>" + local.getAssociado().getDados().getEndereco().getCidade().getNome() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>Estado:</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
				mensagem.append("				<span>" + local.getAssociado().getDados().getEndereco().getCidade().getEstado().getNome() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>CEP:</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
				mensagem.append("				<span>" + local.getAssociado().getDados().getEndereco().getCep() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<div style=\"margin: 0 0 10px 0; padding: 0;\">\n");
				mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
				mensagem.append("				<label>Ponto de Refer&ecirc;ncia:</label>\n");
				mensagem.append("			</div>\n");
				mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%; min-height: 100px; padding: 0 0 0 150px; text-align: justify;\">\n");
				mensagem.append("				<span style=\"\">" + local.getAssociado().getDados().getEndereco().getPontoReferencia() + "</span>\n");
				mensagem.append("			</div>\n");
				mensagem.append("		</div>\n");
				mensagem.append("		<hr/>\n");
				i++;
			}
		}
		
		return mensagem;
	}
	
	private StringBuffer mensagemVendedor(Solicitacao selecionado) {
		StringBuffer mensagem = new StringBuffer();
		Boolean cliente = selecionado.getCliente() != null;
		
		mensagem.append("<div id=\"dados_solicitacao\" style=\"background-color: #dfdffd; padding: 10px; font-family: Arial; width: 70%;\">");
		mensagem.append("	<label style=\"font-weight: bold;\">Solicita&ccedil;&atilde;o de Or&ccedil;amento n&ordm; " + selecionado.getId() + " finalizada em " + selecionado.getDataFinalizacao() + ".</label>");
		mensagem.append("	<fieldset style=\"margin: 5px 0 0 0;\">");
		mensagem.append("		<legend style=\"padding: 10px;\">Informa&ccedil;&otilde;es Principais da Solicita&ccedil;&atilde;o</legend>");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">");
		mensagem.append("				<label>Nome do Cliente/Ag&ecirc;ncia:</label>");
		mensagem.append("			</div>");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">");
		mensagem.append("				<span>" + (cliente ? selecionado.getCliente().getDados().getNomeFantasia() : selecionado.getAgencia().getDados().getNomeFantasia()) + "</span>");
		mensagem.append("			</div>");
		mensagem.append("		</div>");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">");
		mensagem.append("				<label>Servi&ccedil;o Solicita&ccedil;&atilde;o:</label>");
		mensagem.append("			</div>");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">");
		mensagem.append("				<span>" + selecionado.getServico() + "</span>");
		mensagem.append("			</div>");
		mensagem.append("		</div>");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">");
		mensagem.append("				<label>Quantide Total Solicitada:</label>");
		mensagem.append("			</div>");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">");
		mensagem.append("				<span>" + selecionado.getQuantidade() + "</span>");
		mensagem.append("			</div>");
		mensagem.append("		</div>");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">");
		mensagem.append("				<label>Data de Entrega:</label>");
		mensagem.append("			</div>");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">");
		mensagem.append("				<span>" + selecionado.getDataEntrega() + "</span>");
		mensagem.append("			</div>");
		mensagem.append("		</div>");
		mensagem.append("	</fieldset>");
		mensagem.append("	<fieldset>");
		mensagem.append("		<legend style=\"padding: 10px;\">Locais de Entrega</legend>");
		mensagem.append(montaLocaisEntrega(selecionado));
		mensagem.append("	</fieldset>");
		mensagem.append("</div>");
		return mensagem;
	}
	
	/** {@inheritDoc} */
	@Override
	public void finalizar(Solicitacao selecionado) throws FacadeException, EmailException {
	    try {
	    	selecionado.setDataFinalizacao(new Date());
	        selecionado.setFinalizado(true);
            this.salvar(selecionado);
        } catch (ValidacaoException e) {
        	e.printStackTrace();
            throw new FacadeException(e);
        }
        
        try {
	        HtmlEmail email = new HtmlEmail();
	        email.setHostName(Constants.HOST_SMTP);
	        email.setSmtpPort(Constants.PORT_SMTP);
	        email.setAuthenticator(new DefaultAuthenticator(Constants.USUARIO_SMTP, Constants.SENHA_SMTP));
	        email.setDebug(true);
	        email.setFrom(Constants.USUARIO_SMTP, "Solicitação de Orçamento");
	        email.setSubject("Solicitacao no. " + selecionado.getId() + " Finalizada");
	        StringBuffer msg = new StringBuffer();
	        msg.append("<b>Solicitacao no. " + selecionado.getId() + " Finalizada!</b>");
	        email.addTo(selecionado.getVendedor().getEmail(), selecionado.getVendedor().getNome());
	        email.addCc("orcamento@newgraf.com", "Orçamento - Newgraf");
	        
	        if (selecionado.getCliente() != null) {
	            email.addTo("vincnunes@gmail.com");
	        }
	
	        if (selecionado.getAgencia() != null) {
	            email.addTo("vincnunes@gmail.com");
	        }
	        
	        email.setHtmlMsg(mensagemVendedor(selecionado).toString());
	        
	        email.send();
        } catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarTransportadora()
	 */
	@Override
	public List<Transportadora> listarTransportadora() {
		try {
    		return transportadoraBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarPlastificacao()
	 */
	@Override
	public List<Plastificacao> listarPlastificacao() {
		try {
    		return plastificacaoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarImpressao()
	 */
	@Override
	public List<Impressao> listarImpressao() {
		try {
    		return impressaoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarProva()
	 */
	@Override
	public List<Prova> listarProva() {
		try {
    		return provaBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarDobra()
	 */
	@Override
	public List<Dobra> listarDobra() {
		try {
    		return dobraBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	@Override
	public List<Solicitacao> listarFinalizados() {
		try {
			Solicitacao solicitacao = new Solicitacao();
			solicitacao.setFinalizado(true);
			
			return getBusiness().listar(solicitacao);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarGramatura()
	 */
	@Override
	public List<Usuario> listarVendedores() {
		try {
			Usuario usuario = new Usuario();
			usuario.setPerfil(PERFIL.VENDEDOR);
			return usuarioBusiness.listar(usuario);
		} catch (BusinessException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarGramatura()
	 */
	@Override
	public List<Gramatura> listarGramatura() {
		try {
    		return gramaturaBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarGrampo()
	 */
	@Override
	public List<Grampo> listarGrampo() {
		try {
    		return grampoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarCola()
	 */
	@Override
	public List<Cola> listarCola() {
		try {
    		return colaBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarCorte()
	 */
	@Override
	public List<Corte> listarCorte() {
		try {
    		return corteBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarCorte()
	 */
	@Override
	public Usuario listarVendedor() {
		try {
    		return usuarioLogadoBusiness.getUsuarioLogado();
    	} catch (Exception e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarVerniz()
	 */
	@Override
	public List<Verniz> listarVerniz() {
		try {
    		return vernizBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarFuro()
	 */
	@Override
	public List<Furo> listarFuro() {
		try {
    		return furoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarFrete()
	 */
	@Override
	public List<Frete> listarFrete() {
		try {
    		return freteBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarPagamento()
	 */
	@Override
	public List<Pagamento> listarPagamento() {
		try {
    		return pagamentoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarPrazo()
	 */
	@Override
	public List<Prazo> listarPrazo() {
		try {
    		return prazoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarImposto()
	 */
	@Override
	public List<Imposto> listarImposto() {
		try {
    		return impostoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarStatus()
	 */
	@Override
	public List<Status> listarStatus() {
		try {
    		return statusBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarPapel()
	 */
	@Override
	public List<Papel> listarPapel() {
		try {
    		return papelBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}
	
	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarPagina()
	 */
	@Override
	public List<Pagina> listarPagina() {
		try {
    		return paginaBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}

    	return null;
	}

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.facade.CrudSolicitacaoFacade#listarDestino()
	 */
	@Override
	public List<Destino> listarDestino() {
		try {
    		return destinoBusiness.listar();
    	} catch (BusinessException e) {
			e.printStackTrace();
		}
    	return null;
	}

	/** {@inheritDoc} */
	@Override
    public List<Cidade> listarCidades(Estado estado) {
        try {
            Cidade cidade = new Cidade();
            cidade.setEstado(estado);
            return cidadeBusiness.listar(cidade);
        } catch (BusinessException be) {
            be.printStackTrace();
        }
        return null;
    }

	@Override
    public List<Estado> listarEstados() {
        try {
            return estadoBusiness.listar();
        } catch (BusinessException be) {
            be.printStackTrace();
        }

        return null;
    }
	
}
