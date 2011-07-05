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
import com.hvnl.ssolo.business.BancoBusiness;
import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.business.ClienteBusiness;
import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.facade.CrudAgenciaPublicitariaFacade;
import com.hvnl.ssolo.model.AgenciaPublicitaria;
import com.hvnl.ssolo.model.Atividade;
import com.hvnl.ssolo.model.Banco;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Cliente.Pessoa;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;

/**
 * Implementacao da fachada do caso de uso Manter {@link AgenciaPublicitaria}.
 * @author vinicius
 */
@Component("crudAgenciaPublicitariaFacade")
public class CrudAgenciaPublicitariaFacadeImpl 
		extends CrudFacadeGenerico<AgenciaPublicitaria, AgenciaPublicitariaBusiness> 
		implements CrudAgenciaPublicitariaFacade {
	
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
	 * Situação da Agência.
	 */
	private StatusBusiness statusBusiness;
	
	/**
	 * Clientes associados.
	 */
	private ClienteBusiness clienteBusiness;
	
	/**
	 * Banco da conta da Agência.
	 */
	private BancoBusiness bancoBusiness;
	
	/**
	 * Usuario logado no sistema.
	 */
	private UsuarioLogadoBusiness usuarioLogadoBusiness;
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("agenciaPublicitariaBusiness") AgenciaPublicitariaBusiness business) {
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
    public void setClienteBusiness(@Qualifier("clienteBusiness") ClienteBusiness clienteBusiness) {
        this.clienteBusiness = clienteBusiness;
    }
    
    @Autowired
    public void setBancoBusiness(@Qualifier("bancoBusiness") BancoBusiness bancoBusiness) {
        this.bancoBusiness = bancoBusiness;
    }
    
    @Autowired
    public void setUsuarioLogadoBusiness(@Qualifier("usuarioLogadoBusiness") UsuarioLogadoBusiness usuarioLogadoBusiness) {
        this.usuarioLogadoBusiness = usuarioLogadoBusiness;
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
	
	/**
     * Listar os bancos.
     */
	@Override
	public List<Banco> listarBancos() {
		try {
    		return bancoBusiness.listar();
    	} catch (BusinessException be) {
			be.printStackTrace();
		}
    	
		return null;
	}
	
	@Override
	public List<Cliente> listarAssociados(AgenciaPublicitaria selecionado) {
		if (selecionado.getId() != null) {
			try {
				return get(selecionado.getId()).getAssociados();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<Cliente> listarClientes() {
		try {
			Cliente cliente = new Cliente();
			cliente.setVendedor(usuarioLogadoBusiness.getUsuarioLogado());
			return clienteBusiness.listar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
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
	public Usuario listarVendedor() {
		return usuarioLogadoBusiness.getUsuarioLogado();
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		try {
			clienteBusiness.persiste(cliente);
		} catch (Exception be) {
			be.printStackTrace();
		}
	}
	
}
