/*
 * 07/07/2009
 */
package com.hvnl.ssolo.facade.impl;

import java.util.List;

import com.hvnl.ssolo.business.Business;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.facade.CrudFacade;
import com.hvnl.ssolo.model.Model;

/**
 * Implementação genérica de uma fachada para Crud.
 * @param <M> Entidade que será tratada na fachada
 * @param <B> Camada de negócios
 * @author heber
 */
public abstract class CrudFacadeGenerico<M extends Model, B extends Business<M>>
    implements CrudFacade<M> {

    /**
     * Camada de Negócios.
     */
    private B business;

    /** {@inheritDoc} */
    public M get(Long id) throws FacadeException {
        try {
            return getBusiness().get(id);
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    }

    /** {@inheritDoc} */
    public void excluir(M model) throws ValidacaoException, FacadeException {
        try {
            getBusiness().excluir(model);
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar() throws FacadeException {
        try {
            return getBusiness().listar();
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar(String... camposOrdenacao) throws FacadeException {
        try {
            return getBusiness().listar(camposOrdenacao);
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    }

    /** {@inheritDoc} */
    public void salvar(M model) throws ValidacaoException, FacadeException {
        try {
            getBusiness().persiste(model);
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> filtrar(M model) throws FacadeException {
        try {
            return getBusiness().listar(model);
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> filtrar(M model, String... camposOrdenacao) throws FacadeException {
        try {
            return getBusiness().listar(model, camposOrdenacao);
        } catch (BusinessException e) {
            throw new FacadeException(e);
        }
    };

    protected B getBusiness() {
        return business;
    }

    public void setBusiness(B business) {
        this.business = business;
    }
}
