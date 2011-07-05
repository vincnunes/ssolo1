package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Destino de entrega.
 * @author heber
 */
@Entity
public class Destino extends Model {

    /**
     * Cliente a qual o Destino pertence.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Cliente cliente;

    /**
     * Dados gerais.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private DadosEmpresa dados;

    public void setDados(DadosEmpresa dados) {
        this.dados = dados;
    }

    public DadosEmpresa getDados() {
        return dados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}

