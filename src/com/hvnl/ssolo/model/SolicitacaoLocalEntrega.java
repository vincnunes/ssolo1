/*
 * 24/02/2011
 */
package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Quantidade que sera entregue em um local especifico.
 * @author heber
 */
@Entity
public class SolicitacaoLocalEntrega extends Model {

    /**
     * Solicitacao que sera entregue.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Solicitacao solicitacao;

    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Cliente associado;

    /**
     * Quantidade.
     */
    private Integer quantidade;

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getAssociado() {
        return associado;
    }

    public void setAssociado(Cliente associado) {
        this.associado = associado;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        return obj == this;
        /*
        if (obj instanceof SolicitacaoLocalEntrega) {
            SolicitacaoLocalEntrega sle = (SolicitacaoLocalEntrega) obj;
            return equals(this.solicitacao, sle.solicitacao)
                    && equals(this.endereco, sle.endereco);
        }
        return false;*/
    }
}
