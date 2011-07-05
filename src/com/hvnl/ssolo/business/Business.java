/*
 * 07/07/2009
 */
package com.hvnl.ssolo.business;

import java.io.Serializable;
import java.util.List;

import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.model.Model;

/**
 * Definição de um business padrão.
 * @param <M> BaseModel que o business tratará
 * @author heber
 */
public interface Business<M extends Model> extends Serializable {

    /**
     * Insere ou altera um modelo na base de dados.
     * @param model Modelo que será persistido
     * @exception ValidacaoException caso haja erro na validação
     * @exception BusinessException caso haja erros gerais
     */
    void persiste(M model) throws ValidacaoException, BusinessException;

    /**
     * Insere ou altera uma lista de modelos na base de dados.
     * @param models Modelos que serão persistidos
     * @exception ValidacaoException caso haja erro na validação
     * @exception BusinessException caso haja erros gerais
     */
    void persiste(List<M> models) throws ValidacaoException, BusinessException;

    /**
     * Exclui um modelo.
     * @param model Modelo que será excluído
     * @exception ValidacaoException caso haja erro na validação
     * @exception BusinessException caso haja erros gerais
     */
    void excluir(M model) throws ValidacaoException, BusinessException;

    /**
     * Exclui todos os modelos presentes na lista.
     * @param models objetos a serem excluídos
     * @exception BusinessException caso haja erros gerais
     */
    void excluir(List<M> models) throws BusinessException;

    /**
     * Lista todos os registros do modelo.
     * @return Modelos listados
     * @exception BusinessException caso haja erros gerais
     */
    List<M> listar() throws BusinessException;

    /**
     * Lista todos os registros do modelo.
     * @param camposOrdenacao Campos usados para ordenar a consulta
     * @return lista de {@link M}
     * @exception BusinessException caso haja erros gerais
     */
    List<M> listar(String... camposOrdenacao) throws BusinessException;

    /**
     * Lista todos modelos de acordo com o filtro.
     * @param filtro Parametros da busca
     * @return Modelos listados
     * @exception BusinessException caso haja erros gerais
     */
    List<M> listar(M filtro) throws BusinessException;

    /**
     * Lista todos modelos de acordo com o filtro.
     * @param filtro Parametros da busca
     * @param camposOrdenacao Campos usados para ordenar a consulta
     * @return Modelos listados
     * @exception BusinessException caso haja erros gerais
     */
    List<M> listar(M filtro, String... camposOrdenacao) throws BusinessException;

    /**
     * Pega um modelo.
     * @param id Id do modelo
     * @return Modelo selecionado
     * @exception BusinessException caso haja erros gerais
     */
    M get(Long id) throws BusinessException;

    /**
     * Pega um modelo.
     * @param filtro filtro
     * @return primeiro modelo selecionado de uma lista de resultados
     * @exception BusinessException caso haja erros gerais
     */
    M get(M filtro) throws BusinessException;

    /**
     * Verifica se todos os campos do objeto estão vazios/nulos/zerados.
     * @param model objeto que será verificado
     * @return true se estiver tudo vazio.
     */
    Boolean isEmpty(M model);
}
