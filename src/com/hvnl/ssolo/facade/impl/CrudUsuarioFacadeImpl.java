/**
 * 
 */
package com.hvnl.ssolo.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.CidadeBusiness;
import com.hvnl.ssolo.business.EstadoBusiness;
import com.hvnl.ssolo.business.StatusBusiness;
import com.hvnl.ssolo.business.UsuarioBusiness;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.facade.CrudUsuarioFacade;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;

/**
 * Implementacao da fachada do caso de uso Manter {@link Usuario}.
 * @author vinicius
 */
@Component("crudUsuarioFacade")
public class CrudUsuarioFacadeImpl extends CrudFacadeGenerico<Usuario, UsuarioBusiness> 
			implements CrudUsuarioFacade {
	
	/**
	 * Cidade do endereço do Usuário.
	 */
	private CidadeBusiness cidadeBusiness;
	
	/**
	 * Estado do endereço do Usuário.
	 */
	private EstadoBusiness estadoBusiness;
	
	/**
	 * Status do Usuário.
	 */
	private StatusBusiness statusBusiness;
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setBusiness(@Qualifier("usuarioBusiness") UsuarioBusiness business) {
        super.setBusiness(business);
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
    public void setStatusBusiness(@Qualifier("statusBusiness") StatusBusiness statusBusiness) {
        this.statusBusiness = statusBusiness;
    }
    
	@Override
	public Usuario getUsuario(String usuario, String senha) {
		return getBusiness().getUsuario(usuario, senha);
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
     * Listar os estados registrados no sistema para servir de opção no cadastro
     * do endereço do Usuário.
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
     * Listar as cidades registradas no sistema para servir de opção no cadastro
     * do endereço do Usuário.
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
    public List<PERFIL> listarPerfis() {
        List<PERFIL> lista = new ArrayList<Usuario.PERFIL>();
        for (PERFIL p : PERFIL.values()) {
        	lista.add(p);
        }

        return lista;
    }
}