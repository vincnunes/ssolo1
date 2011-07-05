/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AgenciaPublicitariaBusiness;
import com.hvnl.ssolo.business.AtividadeBusiness;
import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.business.ClienteBusiness;
import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.business.TransportadoraBusiness;
import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.facade.CrudClienteFacade;
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
import com.hvnl.ssolo.model.Usuario.PERFIL;

/**
 * Implementacao da fachada do caso de uso Manter {@link Cliente}.
 * @author vinicius
 */
@Component("crudClienteFacade")
public class CrudClienteFacadeImpl extends CrudFacadeGenerico<Cliente, ClienteBusiness> 
		implements CrudClienteFacade {
	/**
	 * Endereço do Cliente.
	 */
	private AtividadeBusiness atividadeBusiness;
	
	/**
	 * Cidade do endereço do Cliente.
	 */
	private CidadeBusiness cidadeBusiness;
	
	/**
	 * Estado do endereço do Cliente.
	 */
	private EstadoBusiness estadoBusiness;
	
	/**
	 * Vendedor responsável pelo Cliente.
	 */
	private UsuarioBusiness usuarioBusiness;
	
	/**
	 * Usuário Logado do sistema.
	 */
	private UsuarioLogadoBusiness usuarioLogadoBusiness;
	
	/**
	 * Situação do Cliente.
	 */
	private StatusBusiness statusBusiness;
	
	/**
	 * Agência Publicitária a qual o Cliente está associado.
	 */
	private AgenciaPublicitariaBusiness agenciaPublicitariaBusiness;
	
	/**
	 * Transportadora padrão do cliente.
	 */
	private TransportadoraBusiness transportadoraBusiness;
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("clienteBusiness") ClienteBusiness business) {
        super.setBusiness(business);
    }
    
    @Autowired
    public void setAtividadeBusiness(@Qualifier("atividadeBusiness") AtividadeBusiness atividadeBusiness) {
        this.atividadeBusiness = atividadeBusiness;
    }
    
    @Autowired
    public void setCidadeBusiness(@Qualifier("cidadeBusiness") CidadeBusiness cidadeBusiness) {
        this.cidadeBusiness = cidadeBusiness;
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
    public void setStatusBusiness(@Qualifier("statusBusiness") StatusBusiness statusBusiness) {
        this.statusBusiness = statusBusiness;
    }
    
    @Autowired
    public void setAgenciaPublicitariaBusiness(@Qualifier("agenciaPublicitariaBusiness") AgenciaPublicitariaBusiness agenciaPublicitariaBusiness) {
        this.agenciaPublicitariaBusiness = agenciaPublicitariaBusiness;
    }
    
    @Autowired
    public void setUsuarioLogadoBusiness(@Qualifier("usuarioLogadoBusiness") UsuarioLogadoBusiness usuarioLogadoBusiness) {
        this.usuarioLogadoBusiness = usuarioLogadoBusiness;
    }
    
    @Autowired
    public void setTransportadoraBusiness(@Qualifier("transportadoraBusiness") TransportadoraBusiness transportadoraBusiness) {
        this.transportadoraBusiness = transportadoraBusiness;
    }
    
    @Override
	public Estado getEstado(Long id) {
    	try {
			return estadoBusiness.get(id);
		} catch (BusinessException be) {
			be.printStackTrace();
		}
		return null;
	}

	@Override
	public Cidade getCidade(Long id) {
		try {
			return cidadeBusiness.get(id);
		} catch (BusinessException be) {
			be.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Status getStatus(Long id) {
		try {
			return statusBusiness.get(id);
		} catch (BusinessException be) {
			be.printStackTrace();
		}
		return null;
	}
    
    @Override
    public List<Cliente> filtrar(Cliente model,
    		String... camposOrdenacao) throws FacadeException {
    	Usuario usuario = usuarioLogadoBusiness.getUsuarioLogado();
    	if (usuario.getPerfil().compareTo(PERFIL.VENDEDOR) == 0) {
	    	model.setVendedor(usuario);
	    	
	    	return super.filtrar(model, camposOrdenacao);
    	} else {
    		return super.filtrar(model, camposOrdenacao);
    	}
    }
    
    /**
     * Listar as atividades.
     * @return List<Cidade>
     */
    @Override
    public List<Atividade> listarAtividades() {
    	try {
    		return atividadeBusiness.listar();
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
    	return null;
    }
    
    /**
     * Listar as transportadoras.
     * @return List<Transportadora>
     */
    @Override
    public List<Transportadora> listarTransportadoras() {
    	try {
    		return transportadoraBusiness.listar();
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
    	return null;
    }
    
    /**
     * Listar as cidades registradas no sistema para servir de opção no cadastro
     * do endereço do Cliente.
     * @return List<Cidade>
     */
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
    
    /**
     * Listar os estados registrados no sistema para servir de opção no cadastro
     * do endereço do Cliente.
     * @return List<Estado>
     */
    @Override
    public List<Estado> listarEstados() {
    	try {
    		return estadoBusiness.listar();
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
    	return null;
    }

    /**
     * 
     */
    public Usuario listarVendedor() {
    	return usuarioLogadoBusiness.getUsuarioLogado();
    }
    
	/**
     * Listar os vendedores.
     * @return List<Estado>
     */
    @Override
    public List<Usuario> listarVendedores() {
    	try {
    		Usuario usuario = usuarioLogadoBusiness.getUsuarioLogado();
    		if (usuario.getPerfil().compareTo(PERFIL.ADMINISTRADOR) == 0) {
    			Usuario usu = new Usuario();
    			usu.setPerfil(PERFIL.VENDEDOR);
    			return usuarioBusiness.listar(usu);
    		} else {
    			List<Usuario> lista = new ArrayList<Usuario>();
    			lista.add(usuario);
    			return lista;
    		}
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
    	return null;
    }
    
    /**
     * Listar as situações.
     */
	@Override
	public List<Status> listarStatus() {
		try {
    		return statusBusiness.listar();
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
		return null;
	}
	
	@Override
    public List<Pessoa> listarTipoPessoa() {
        List<Pessoa> lista = new ArrayList<Cliente.Pessoa>();
        for (Pessoa p : Pessoa.values()) {
        	lista.add(p);
        }

        return lista;
    }

	@Override
	public List<TipoAssociado> listarTipoAssociado() {
		List<TipoAssociado> lista = new ArrayList<Cliente.TipoAssociado>();
        for (TipoAssociado p : TipoAssociado.values()) {
        	lista.add(p);
        }

        return lista;
	}

	@Override
	public List<AgenciaPublicitaria> listarAgencias() {
		try {
			Usuario usuario = usuarioLogadoBusiness.getUsuarioLogado();
	    	if (usuario.getPerfil().compareTo(PERFIL.VENDEDOR) == 0) {
	    		AgenciaPublicitaria agencia = new AgenciaPublicitaria();
	    		agencia.setVendedor(usuario);
	    		return agenciaPublicitariaBusiness.listar(agencia);
	    	} else {
	    		return agenciaPublicitariaBusiness.listar();
	    	}
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
		return null;
	}

	@Override
	public void atulizarAgencia(AgenciaPublicitaria agencia) {
		try {
			agenciaPublicitariaBusiness.persiste(agencia);
		} catch (ValidacaoException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
}
