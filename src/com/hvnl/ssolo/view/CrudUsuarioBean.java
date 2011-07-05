/**
 *
 */
package com.hvnl.ssolo.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.hvnl.ssolo.facade.CrudUsuarioFacade;
import com.hvnl.ssolo.model.Endereco;
import com.hvnl.ssolo.model.Estado;
import com.hvnl.ssolo.model.Situacao;
import com.hvnl.ssolo.model.Status;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Verniz;

/**
 * Bean do caso de uso cadastrar {@link Verniz}.
 * @author vinicius
 */
public class CrudUsuarioBean extends CrudBeanGenerico<Usuario, CrudUsuarioFacade> {
	/**
     * Lista de cidades.
     */
    private List<SelectItem> cidades;

    /**
     * Lista de estados.
     */
    private List<SelectItem> estados;

    /**
     * Lista de status.
     */
    private List<SelectItem> status;

	/**
     * Estado do endereco do usuario.
     */
    private Estado estado;
    
    /**
     * Teste de senha criada.
     */
    private String repetirSenha;

    public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}
	
	public void testarSenha() {
		if (!getSelecionado().getSenha().equals(repetirSenha)) {
			addErrorMessage("A senha informada está incorreta. Favor, informe a senha novamente.");
		}
		getSelecionado().setSenha(getRepetirSenha());
		setRepetirSenha(getSelecionado().getSenha());
	}
	
	@Override
    protected Usuario getNewModel() {
    	Usuario usuario = new Usuario();
    	Situacao situacao = new Situacao();
        for(Status status : getCrudFacade().listarStatus()) {
        	if (status.getNome().equals("Ativo")) {
        		situacao.setStatus(status);
        	}
        }
    	situacao.setDataAtualizacao(new Date());
        situacao.setMotivo("Cadastro novo.");
        usuario.setSituacao(situacao);
        Endereco endereco = new Endereco();
        /* Código da cidade de Fortaleza */
        endereco.setCidade(getCrudFacade().getCidade(new Long(59)));
        usuario.setEndereco(endereco);
        setRepetirSenha(null);
        /* Código do estado do Ceará */
        setEstado(getCrudFacade().getEstado(new Long(6)));
        
    	return usuario;
    }
	
	public void buscarEndereco() {
    	getCepOnLine().getCep(getSelecionado().getEndereco());
    	estado = getSelecionado().getEndereco().getCidade().getEstado();
    }
	
    public List<SelectItem> getCidades() {
        if (estado != null) {
            cidades = ordena(gerarListaSelectItem(
                    getCrudFacade().listarCidades(estado)));
        } else {
            cidades = new ArrayList<SelectItem>();
        }

        return cidades;
    }

    public List<SelectItem> getEstados() {
        if (estados == null) {
            estados = ordena(gerarListaSelectItem(getCrudFacade().listarEstados()));
        }

        return estados;
    }

    public List<SelectItem> getStatus() {
        if (status == null) {
        	status = ordena(gerarListaSelectItem(getCrudFacade().listarStatus()));
        }

        return status;
    }
    
    public List<SelectItem> getPerfis() {
        return ordena(gerarListaSelectItem(getCrudFacade().listarPerfis()));
    }

	/* (non-Javadoc)
	 * @see com.hvnl.ssolo.view.CrudBeanGenerico#getNavegacaoInicial()
	 */
	@Override
	protected String getNavegacaoInicial() {
		return Outcome.CRUD_USUARIO;
	}

	public String consultar() {
		return Outcome.USUARIO_LISTAR;
	}

	/** {@inheritDoc} */
    @Override
    public String iniciar() {
        String retorno = super.iniciar();
        super.filtrar();
        return retorno;
    }

    public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
