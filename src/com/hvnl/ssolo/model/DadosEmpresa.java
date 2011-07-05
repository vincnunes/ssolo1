package com.hvnl.ssolo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Informações comuns a clientes/empresas.
 * @author heber
 */
@Entity
public class DadosEmpresa extends Model {

	/**
	 * Endereco.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Endereco endereco;

	/**
     * Lista de perfis do usuario.
     */
    @OneToMany(mappedBy = "dadosEmpresa", cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Contato> contatos;

    /**
     * Nome fantasia.
     */
	private String nomeFantasia;

	/**
	 * CPF ou CNPJ.
	 */
	private String cpfCnpj;

	/**
	 * RG ou CGF.
	 */
	private String rgCgf;

	/**
	 * Inscricao municipal.
	 */
	private String inscricaoMunicipal;

	/**
	 * Data da ultima atualizacao.
	 */
	private Date dataAtualizacao;
	
	/**
	 * Email.
	 */
	private String email;
	
	/**
	 * Telefone PABX.
	 */
	private String telefone;
	
	/**
	 * FAX do Model.
	 */
	private String fax;
	
	/**
	 * Celular do Model.
	 */
	private String celular;

    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgCgf() {
        return rgCgf;
    }

    public void setRgCgf(String rgCgf) {
        this.rgCgf = rgCgf;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

