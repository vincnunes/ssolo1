package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Quantidade que sera entregue em um destino da Solicitacao.
 * @author heber
 */
@Entity
public class SolicitacaoDestino extends Model {

    /**
     * Solicitacao que sera entregue.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private SolicitacaoLocalEntrega localEntrega;

    /**
     * Quantidade.
     */
	private Integer quantidade;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public SolicitacaoLocalEntrega getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(SolicitacaoLocalEntrega localEntrega) {
        this.localEntrega = localEntrega;
    }

}

