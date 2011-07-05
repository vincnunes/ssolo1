package com.hvnl.ssolo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Modelo das classes de negócio.
 * @author heber
 */
@MappedSuperclass
public class Model implements Serializable {

    /**
     * Identificador da entidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	/**
	 * Nome da entidade.
	 */
	private String nome;

	/**
	 * Descricao da entidade.
	 */
	private String descricao;

	/**
	 * Usuario que cadastrou a entidade.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
	private Usuario usuarioCadastro;

	/**
	 * Data em que a entidade foi criada.
	 */
	private Date dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
    	return getNome();
    }

    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof Model)) {
    		return false;
    	}

    	Model m = (Model) obj;

    	if (id != null && m.id != null) {
    		return id.equals(m.id);
    	}

    	if (nome != null && m.nome != null) {
    		return m.nome.equals(nome);
    	}

    	if (id == null && m.id == null) {
    	    return true;
    	}

    	if (nome == null && m.nome == null) {
            return true;
        }

    	return false;
    }

    /**
     * Verifica se dois models sao iguais.
     * @param m1 objeto 1
     * @param m2 objeto 2
     * @return true se forem iguais.
     */
    public boolean equals(Model m1, Model m2) {
    	if (m1 == null && m2 == null) {
    		return true;
    	} else if (m1 != null) {
    		return m1.equals(m2);
    	}
    	return false;
    }

    @Override
    public int hashCode() {
    	return (id != null ? id.hashCode() : 0) + ("" + nome).hashCode();
    }
}

