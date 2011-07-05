/*
 * 07/07/2009
 */
package com.hvnl.ssolo.dao;

import java.io.Serializable;
import java.util.List;

import com.hvnl.ssolo.exception.DaoException;
import com.hvnl.ssolo.model.Model;

/**
 * Modelo DAO genérico.
 * @param <M> Tipo de entidade a qual a persistência será realizada.
 * @author heber
 *
 */
public interface Dao<M extends Model> extends Serializable {

    /**
     * Insere ou altera um modelo na base de dados.
     * @param model Modelo que será persistido
     * @exception DaoException no caso de erros com a base de dados
     */
    void persiste(M model) throws DaoException;

    /**
     * Exclui um modelo.
     * @param model Modelo que será excluído
     * @exception DaoException no caso de erros com a base de dados
     */
    void excluir(M model) throws DaoException;

    /**
     * Exclui todos os presentes na lista.
     * @param models objetos a serem excluídos
     * @exception DaoException no caso de erros com a base de dados
     */
    void excluir(List<M> models) throws DaoException;

    /**
     * Lista todos os registros do modelo.
     * @return Modelos listados
     * @exception DaoException no caso de erros com a base de dados
     */
    List<M> listar() throws DaoException;

    /**
     * Lista todos os registros do modelo.
     * @param camposOrdenacao Campos usados para ordenar a consulta
     * @return lista de {@link M}
     * @exception DaoException no caso de erros com a base de dados
     */
    List<M> listar(String... camposOrdenacao) throws DaoException;

    /**
     * Lista todos modelos de acordo com o filtro.
     * @param filtro Parametros da busca
     * @return Modelos listados
     * @exception DaoException no caso de erros com a base de dados
     */
    List<M> listar(M filtro) throws DaoException;

    /**
     * Lista todos os modelos de acordo com o filtro.
     * @param filtro Parametros da busca
     * @param camposOrdenacao Campos usados para ordenar a consulta
     * @return Modelos listados
     * @exception DaoException no caso de erros com a base de dados
     */
    List<M> listar(M filtro, String ... camposOrdenacao) throws DaoException;

    /**
     * Pega um modelo.
     * @param id Id do modelo
     * @return Modelo selecionado
     * @exception DaoException no caso de erros com a base de dados
     */
    M get(Long id) throws DaoException;
}
