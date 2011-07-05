/*
 * 23/02/2011
 */
package com.hvnl.ssolo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entidade Conta Bancaria.
 * @author heber
 */
@Entity
public class Conta extends Model {

    /**
     * Banco a qual esta agencia pertence.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Banco banco;

    /**
     * Agencia bancaria.
     */
    private String agencia;

    /**
     * Numero da conta bancaria.
     */
    private String conta;

    /**
     * Nome do favorecido.
     */
    private String favorecido;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

}
