/*
 * 07/07/2009
 */
package com.hvnl.ssolo.facade;

import java.io.Serializable;
import java.util.List;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.model.Model;

/**
 * Definição dos métodos padrões de um crud.
 * @param <M> Modelo que será tradado
 * @author heber
 *
 */
public interface CrudFacade<M extends Model> extends Serializable {

    /**
     * Pega um modelo de acordo com o ID.
     * @param id identificador do modelo
     * @return modelo selecionado
     * @throws FacadeException caso haja erros gerais
     */
    M get(Long id) throws FacadeException;
    
    /**
     * Salva uma entidade.
     * @param model Entidade que será salva
     * @exception ValidacaoException caso haja erro na validação
     * @exception FacadeException caso haja erros gerais
     */
    void salvar(M model) throws ValidacaoException, FacadeException;

    /**
     * Lista todos os registros da entidade.
     * @return registros listados
     * @exception FacadeException caso haja erros gerais
     */
    List<M> listar() throws FacadeException;

    /**
     * Lista todos os registros da entidade.
     * @param camposOrdenacao campos que servirão para ordenar a lista
     * @return registros listados
     * @exception FacadeException caso haja erros gerais
     */
    List<M> listar(String... camposOrdenacao) throws FacadeException;

    /**
     * Excluir uma entidade dos dados.
     * @param model Dado que será exluído
     * @exception ValidacaoException caso haja erro na validação
     * @exception FacadeException caso haja erros gerais
     */
    void excluir(M model) throws ValidacaoException, FacadeException;

    /**
     * Filtra uma lista de acordo com os parametros passados.
     * @param model parametros para filtro
     * @return Lista filtrada
     * @exception FacadeException caso haja erros gerais
     */
    List<M> filtrar(M model) throws FacadeException;

    /**
     * Filtra uma lista de acordo com os parametros passados.
     * @param model parametros para filtro
     * @param camposOrdenacao Campos usados para ordenar a consulta
     * @return Lista filtrada
     * @exception FacadeException caso haja erros gerais
     */
    List<M> filtrar(M model, String... camposOrdenacao) throws FacadeException;
    
    
}
