/*
 * 23/03/2011
 */
package com.hvnl.ssolo.view;

import java.util.Hashtable;

import com.hvnl.ssolo.facade.PermissoesFacade;
import com.hvnl.ssolo.model.Permissao;
import com.hvnl.ssolo.model.Usuario;
import com.hvnl.ssolo.model.Usuario.PERFIL;

/**
 * Bean para controle de permissoes nas paginas.
 * @author heber
 */
public class PermissoesBean extends BaseBean {

    private final Hashtable<PERFIL, Hashtable<String, Permissao>> permissoes;

    private PermissoesFacade permissoesFacade;

    /**
     *
     */
    public PermissoesBean() {
        // new Permissao(editar, excluir, ver, criar);
        permissoes = new Hashtable<PERFIL, Hashtable<String, Permissao>>();
        
        /* FINANCEIRO */
        /*	Menu Cadastro */
        add(PERFIL.FINANCEIRO, "arte",      			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "atividade", 			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "banco",     			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "capa",      			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "cola",      			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "cadastro",  			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "contato",   			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "corte",     			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "dobra",     			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "frete",     			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "furo",      			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "gramatura", 			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "grampo",    			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "imposto",   			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "impressao",      	new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "lombada",			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "orcamento",			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "pagamento",			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "pagina",				new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "papel",				new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "plastificacao",		new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "prazo",				new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "prova",				new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "servico",			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "status",				new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "verniz",				new Permissao(false, false, false, false));
        /* Menu Cadastro */
        
        /* Menu Entidades */
        add(PERFIL.FINANCEIRO, "agenciaPublicitaria.cadastro",new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "cliente.cadastro",			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "transportadora",		new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "usuario",			new Permissao(false, false, false, false));
        /* Menu Entidades */
        
        /* Menu Consulta */
        add(PERFIL.FINANCEIRO, "agenciaPublicitaria.consulta",new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "cliente.consulta",			new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "solicitacao.consulta",		new Permissao(false, false, false, false));
        /* Menu Consulta */
        
        /* Menu Solicitacao */
        add(PERFIL.FINANCEIRO, "solicitacao.cadastro",    	new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "solicitacao.consulta.vendedor",    	new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "solicitacao.finalizar",   new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "solicitacao.status", 	new Permissao(false, false, false, false));
        
        /* Menu Solicitacao */
        
        /* Menu Auditoria */
        add(PERFIL.FINANCEIRO, "agenciaPublicitaria.auditoria",	new Permissao(true, false, true, true));
        add(PERFIL.FINANCEIRO, "cliente.auditoria",				new Permissao(true, false, true, true));
        add(PERFIL.FINANCEIRO, "solicitacao.auditoria",			new Permissao(false, false, false, false));
        /* Menu Auditoria */
        
        add(PERFIL.FINANCEIRO, "lista.inadimplentes",			new Permissao(false, false, false, false));
        
        /* Paginas */
        add(PERFIL.FINANCEIRO, "salvar.agencia.financeiro",		new Permissao(true, false, true, true));
        add(PERFIL.FINANCEIRO, "salvar.cliente.financeiro",		new Permissao(true, false, true, true));
        add(PERFIL.FINANCEIRO, "editar.agencia",		new Permissao(false, false, false, false));
        add(PERFIL.FINANCEIRO, "editar.cliente",		new Permissao(false, false, false, false));
        /* Paginas */
        
        /* Relatorios */
        /* Relatorios */
        /* FINANCEIRO */
        
        /* ORCAMENTO */
        /*	Menu Cadastro */
        add(PERFIL.ORCAMENTO, "arte",      			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "atividade", 			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "banco",     			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "capa",      			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "cola",      			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "cadastro",  			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "contato",   			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "corte",     			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "dobra",     			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "frete",     			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "furo",      			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "gramatura", 			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "grampo",    			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "imposto",   			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "impressao",      	new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "lombada",			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "orcamento",			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "pagamento",			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "pagina",				new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "papel",				new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "plastificacao",		new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "prazo",				new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "prova",				new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "servico",			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "status",				new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "verniz",				new Permissao(false, false, false, false));
        /* Menu Cadastro */
        
        /* Menu Entidades */
        add(PERFIL.ORCAMENTO, "agenciaPublicitaria.cadastro",new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "cliente.cadastro",			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "transportadora",		new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "usuario",			new Permissao(false, false, false, false));
        /* Menu Entidades */
        
        /* Menu Consulta */
        add(PERFIL.ORCAMENTO, "agenciaPublicitaria.consulta",new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "cliente.consulta",			new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "solicitacao.consulta",		new Permissao(false, false, false, false));
        /* Menu Consulta */
        
        /* Menu Solicitacao */
        add(PERFIL.ORCAMENTO, "solicitacao.cadastro",    	new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "solicitacao.consulta.vendedor",    	new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "solicitacao.finalizar",   new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "solicitacao.status", 	new Permissao(false, false, false, false));
        /* Menu Solicitacao */
        
        /* Menu Auditoria */
        add(PERFIL.ORCAMENTO, "agenciaPublicitaria.auditoria",	new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "cliente.auditoria",				new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "solicitacao.auditoria",			new Permissao(false, false, false, false));
        /* Menu Auditoria */
        
        add(PERFIL.ORCAMENTO, "lista.inadimplentes",			new Permissao(false, false, false, false));
        
        /* Paginas */
        add(PERFIL.ORCAMENTO, "salvar.agencia.financeiro",		new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "salvar.cliente.financeiro",		new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "editar.agencia",		new Permissao(false, false, false, false));
        add(PERFIL.ORCAMENTO, "editar.cliente",		new Permissao(false, false, false, false));
        /* Paginas */
        
        /* Relatorios */
        /* Relatorios */
        /* ORCAMENTO */
        
        /* VENDEDOR */
        /* Menu Cadastro */
        add(PERFIL.VENDEDOR, "arte",      			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "atividade", 			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "banco",     			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "capa",      			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "cola",      			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "cadastro",  			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "contato",   			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "corte",     			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "dobra",     			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "frete",     			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "furo",      			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "gramatura", 			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "grampo",    			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "imposto",   			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "impressao",  	    	new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "lombada",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "VENDEDOR",			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "pagamento",			new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "pagina",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "papel",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "plastificacao",		new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "prazo",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "prova",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "servico",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "status",				new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "verniz",				new Permissao(false, false, false, false));
        /* Menu Cadastro */
        
        /* Menu Entidades */
        add(PERFIL.VENDEDOR, "agenciaPublicitaria.cadastro",new Permissao(false, false, true, false));
        add(PERFIL.VENDEDOR, "agenciaPublicitaria.consulta",new Permissao(false, false, true, false));
        add(PERFIL.VENDEDOR, "cliente.cadastro",			new Permissao(false, false, true, false));
        add(PERFIL.VENDEDOR, "cliente.consulta",			new Permissao(false, false, true, false));
        add(PERFIL.VENDEDOR, "transportadora",		new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "usuario",			new Permissao(false, false, false, false));
        /* Menu Entidades */
        
        /* Menu Solicitacao */
        add(PERFIL.VENDEDOR, "solicitacao",    		new Permissao(true,  false, true, true));
        add(PERFIL.VENDEDOR, "solicitacao.consulta",new Permissao(false,  false, true, false));
        add(PERFIL.VENDEDOR, "solicitacao.consulta.vendedor",   new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "solicitacao.finalizar",   new Permissao(false, false, true, false));
        add(PERFIL.VENDEDOR, "solicitacao.status", 	new Permissao(false, false, false, false));
        /* Menu Solicitacao */
        
        add(PERFIL.VENDEDOR, "lista.inadimplentes",	new Permissao(false, false, true, false));
        
        /* Paginas */
        add(PERFIL.VENDEDOR, "salvar.agencia.financeiro",	new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "salvar.cliente.financeiro",	new Permissao(false, false, false, false));
        add(PERFIL.VENDEDOR, "editar.agencia",		new Permissao(true, false, true, false));
        add(PERFIL.VENDEDOR, "editar.cliente",		new Permissao(true, false, true, false));
        /* Paginas */
        
        /* Relatorios */
        /* Relatorios */
        /* VENDEDOR */
    }

    /**
     * @param perfil
     * @param funcao
     * @param permissao
     */
    private void add(PERFIL perfil, String funcao, Permissao permissao) {
        Hashtable<String, Permissao> funcoes = permissoes.get(perfil);
        if (funcoes == null) {
            funcoes = new Hashtable<String, Permissao>();
            permissoes.put(perfil, funcoes);
        }
        funcoes.put(funcao, permissao);
    }

    /** {@inheritDoc} */
    @Override
    public String iniciar() {
        return null;
    }

    public void setPermissoesFacade(PermissoesFacade permissoesFacade) {
        this.permissoesFacade = permissoesFacade;
    }

    /**
     * Pega a permissao de uma determinada funcao do usuario logado.
     * @param funcao nome da funcao que sera acessada
     * @return {@link Permissao}
     */
    protected Permissao get(String funcao) {
        PERFIL perfil = getPerfil();
        if (PERFIL.ADMINISTRADOR.equals(perfil)) {
            return new Permissao(true, true, true, true);
        }
        return get(perfil, funcao);
    }

    /**
     * Pega a permissao de uma determinada funcao do usuario logado.
     * @param perfil perfil do usuario
     * @param funcao nome da funcao que sera acessada
     * @return {@link Permissao}
     */
    private Permissao get(PERFIL perfil, String funcao) {
        Permissao permissao = permissoes.get(perfil).get(funcao);
        if (permissao == null) {
            return new Permissao();
        }
        return permissao;
    }

    /**
     * Pega o perfil do usuario logado.
     * @return {@link PERFIL}
     */
    protected PERFIL getPerfil() {
        Usuario usuario = permissoesFacade.getUsuarioLogado();
        return usuario.getPerfil();
    }
    
    /* Menu Cadastro */
    public Permissao getArte() {
        return get("arte");
    }
    
    public Permissao getAtividade() {
        return get("atividade");
    }
    
    public Permissao getBanco() {
        return get("banco");
    }
    
    public Permissao getCapa() {
        return get("capa");
    }
    
    public Permissao getCola() {
        return get("cola");
    }
    
    public Permissao getCadastro() {
        return get("cadastro");
    }
    
    public Permissao getContato() {
        return get("contato");
    }
    
    public Permissao getCorte() {
        return get("corte");
    }
    
    public Permissao getDobra() {
        return get("dobra");
    }
    
    public Permissao getFrete() {
        return get("frete");
    }
    
    public Permissao getFuro() {
        return get("furo");
    }
    
    public Permissao getGramatura() {
        return get("gramatura");
    }
    
    public Permissao getGrampo() {
        return get("grampo");
    }
    
    public Permissao getImposto() {
        return get("imposto");
    }
    
    public Permissao getImpressao() {
        return get("impressao");
    }
    
    public Permissao getLombada() {
        return get("lombada");
    }
    
    public Permissao getOrcamento() {
        return get("orcamento");
    }
    
    public Permissao getPagamento() {
        return get("pagamento");
    }
    
    public Permissao getPagina() {
        return get("pagina");
    }
    
    public Permissao getPapel() {
        return get("papel");
    }
    
    public Permissao getPlastificacao() {
        return get("plastificacao");
    }
    
    public Permissao getPrazo() {
        return get("prazo");
    }
    
    public Permissao getProva() {
        return get("prova");
    }
    
    public Permissao getServico() {
        return get("servico");
    }
    
    public Permissao getStatus() {
        return get("status");
    }
    
    public Permissao getVerniz() {
        return get("verniz");
    }
    /* Fim Menu Cadastro */
    
	/* Menu Entidade */
	public Permissao getAgenciaCadastro() {
    	return get("agenciaPublicitaria.cadastro");
	}
    
	public Permissao getClienteCadastro() {
		return get("cliente.cadastro");
	}
    
	public Permissao getTransportadora() {
		return get("transportadora");
	}
	
	public Permissao getUsuario() {
		return get("usuario");
	}
    /* Fim Menu Entidade */
    
    /* Menu Consulta */
	public Permissao getAgenciaConsulta() {
		return get("agenciaPublicitaria.consulta");
	}
	
	public Permissao getClienteConsulta() {
		return get("cliente.consulta");
	}
	
	public Permissao getSolicitacaoConsulta() {
		return get("solicitacao.consulta");
	}
    /* Fim Menu Consulta */
    
	/* Menu Auditoria */
	public Permissao getAgenciaAuditoria() {
		return get("agenciaPublicitaria.auditoria");
	}
	
	public Permissao getClienteAuditoria() {
		return get("cliente.auditoria");
	}
	
	public Permissao getSolicitacaoAuditoria() {
		return get("solicitacao.auditoria");
	}
	/* Fim Menu Auditoria */
	
	/* Menu Solicitacao */
    public Permissao getSolicitacao() {
        return get("solicitacao");
    }

    public Permissao getSolicitacaoStatus() {
        return get("solicitacao.status");
    }
    /* Fim Menu Solicitacao */
    
    public Permissao getListaInadimplentes() {
        return get("lista.inadimplentes");
    }
    
    public Permissao getSalvarAgenciaFinanceiro() {
    	return get("salvar.agencia.financeiro");
    }
    
    public Permissao getSalvarClienteFinanceiro() {
    	return get("salvar.cliente.financeiro");
    }
    
    public Permissao getEditarAgencia() {
    	return get("editar.agencia");
    }
    
    public Permissao getEditarCliente() {
    	return get("editar.cliente");
    }
    
    public Permissao getSolicitacaoConsultaVendedor() {
    	return get("solicitacao.consulta.vendedor");
    }
    
    public Permissao getSolicitacaoFinalizar() {
    	return get("solicitacao.finalizar");
    }
}
