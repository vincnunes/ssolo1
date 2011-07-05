/*
 * 07/07/2009
 */
package com.hvnl.ssolo.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hvnl.ssolo.dao.Dao;
import com.hvnl.ssolo.exception.DaoException;
import com.hvnl.ssolo.model.Model;

/**
 * Implementação genérica para o DAO utilizando Hibernate.
 * @param <M> BaseModel
 * @author heber
 */
public abstract class HibernateDaoGenerico<M extends Model> extends
        HibernateDaoSupport implements Dao<M> {

    /**
     * Variável para o warning unchecked.
     */
    protected static final String UNCHECKED = "unchecked";

    /**
     * Logger do DAO.
     */
    private final Log log = LogFactory.getLog(getClass());

    /**
     * Usado para injeção do Session Factory com annotations.
     * @param sessionFactory Session Factory do hibernate
     */
    @Autowired
    public final void setHibernateSessionFactory(
            @Qualifier("hibernateSessionFactory") SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
        log.info("HibernateSessionFactory adicionado");
    }

    /** {@inheritDoc} */
    public void excluir(M model) throws DaoException {
        try {
            getHibernateTemplate().delete(model);
            log.info("Exclusão de " + model);
        } catch (DataAccessException e) {
            throw getDaoException(e);
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
	public M get(Long id) throws DaoException {
        try {
            M model = (M) getHibernateTemplate().get(getModelClass(), id);
            log.info("Selecionando (" + id + ") " + model);
            return model;
        } catch (DataAccessException e) {
            throw getDaoException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar() throws DaoException {
        return listar("id");
    }

    /** {@inheritDoc} */
    public List<M> listar(M filtro, String... camposOrdenacao)
        throws DaoException {

        return listar(new HibernateCriteriaFinder<M>(
                getModelClass(), filtro, camposOrdenacao));
    }

    /**
     * Executa uma pesquisa com o {@link HibernateCallback} passado.
     * @param action Modo de execução da pesquisa
     * @return resultado da consulta
     * @exception DaoException erros gerais
     */
    @SuppressWarnings("unchecked")
	public List<M> listar(HibernateCallback action) throws DaoException {

        try {
            List<M> lista = getHibernateTemplate().executeFind(action);
            log.info("Listando " + getModelClass() + " >> " + lista.size()
                    + " resultados");
            return lista;
        } catch (DataAccessException e) {
            throw getDaoException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar(String... camposOrdenacao) throws DaoException {
        return listar(getNewInstance(), camposOrdenacao);
    }

    /** {@inheritDoc} */
    public List<M> listar(M filtro) throws DaoException {
        return listar(filtro, "id");
    }

    /** {@inheritDoc} */
    public void persiste(M model) throws DaoException {
        try {
            if (model.getId() == null) {
                getHibernateTemplate().save(model);
            } else {
                getHibernateTemplate().merge(model);
            }

            log.info("Persistencia de " + model);
        } catch (DataAccessException e) {
            throw getDaoException(e);
        }
    }

    /** {@inheritDoc} */
    public void excluir(List<M> models) throws DaoException {
        try {
            getHibernateTemplate().deleteAll(models);
            log.info("Persistencia de " + models);
        } catch (DataAccessException e) {
            throw getDaoException(e);
        }
    }

    /**
     * Procura um SQLException.
     * @param e Exception a ser analisado
     * @return null se não achar
     */
    protected SQLException getSqlException(Throwable e) {

        if (e == null) {
            return null;
        }

        if (e instanceof SQLException) {
            return (SQLException) e;
        }

        return getSqlException(e.getCause());
    }

    /**
     * Cria um DaoException.
     * @param e base da exceção
     * @return DaoException
     */
    protected DaoException getDaoException(Exception e) {

        SQLException sql = getSqlException(e);

        if (sql != null) {
            return new DaoException(sql);
        }

        return new DaoException(e.getLocalizedMessage());
    }

    /**
     * Pega o Class do modelo.
     * @return Class do modelo.
     */
    @SuppressWarnings("unchecked")
	protected Class<M> getModelClass() {
        return (Class<M>) ((ParameterizedType) getClass()
                     .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Cria uma instância de M.
     * @return nova instância
     */
    private M getNewInstance() {

        try {
            return getModelClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
