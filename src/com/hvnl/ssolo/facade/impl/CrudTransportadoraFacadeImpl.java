/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.AtividadeBusiness;
import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.business.TransportadoraBusiness;
import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.facade.CrudTransportadoraFacade;
import com.hvnl.ssolo.model.Atividade;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Cliente;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Transportadora;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Cliente.Pessoa;

/**
 * Implementacao da fachada do caso de uso Manter {@link Transportadora}.
 * @author vinicius
 */
@Component("crudTransportadoraFacade")
public class CrudTransportadoraFacadeImpl 
		extends CrudFacadeGenerico<Transportadora, TransportadoraBusiness> 
		implements CrudTransportadoraFacade {
	
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
	 * Situação do Cliente.
	 */
	private StatusBusiness statusBusiness;
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("transportadoraBusiness") TransportadoraBusiness business) {
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
    		return usuarioBusiness.listar();
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
    
}
