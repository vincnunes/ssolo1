/*
 * 08/09/2009
 */
package com.hvnl.ssolo.model;


/**
 * Permissão de um perfil.
 * @author heber
 */
public class Permissao {

    /**
     * Se é possível editar.
     */
    private Boolean editar;
    /**
     * Se é possível excluir.
     */
    private Boolean excluir;
    /**
     * Se é possível ver.
     */
    private Boolean ver;
    /**
     * Se é possível criar.
     */
    private Boolean criar;

    /**
     * Padrão.
     */
    public Permissao() { }

    /**
     * Construtor com permissoes.
     * @param editar
     * @param excluir
     * @param ver
     * @param criar
     */
    public Permissao(Boolean editar, Boolean excluir, Boolean ver, Boolean criar) {
        this.editar = editar;
        this.excluir = excluir;
        this.ver = ver;
        this.criar = criar;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getCriar() {
        return criar;
    }

    public void setCriar(Boolean criar) {
        this.criar = criar;
    }
}
