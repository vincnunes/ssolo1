/*
 * 07/07/2009
 */
package com.hvnl.ssolo.business.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hvnl.ssolo.business.Business;
import com.hvnl.ssolo.business.UsuarioLogadoBusiness;
import com.hvnl.ssolo.dao.Dao;
import com.hvnl.ssolo.exception.BusinessException;
import com.hvnl.ssolo.exception.DaoException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.model.Model;
import com.hvnl.ssolo.validation.CannotBeNullMensagem;
import com.hvnl.ssolo.validation.ValidacaoMensagem;
import com.hvnl.ssolo.view.util.ValidaHelper;

/**
 * Business genérico.
 *
 * @param <M> Modelo que será tratado pela classe
 * @param <D> Camada DAO.
 * @author heber
 */
public abstract class BusinessGenerico<M extends Model, D extends Dao<M>> implements
        Business<M> {

    /**
     * Camada DAO.
     */
    private D dao;

    /**
     * Utilizado para pegar o usuário logado.
     */
    @Autowired
    @Qualifier("usuarioLogadoBusiness")
    private UsuarioLogadoBusiness usuarioBusiness;

    /** {@inheritDoc} */
    public void excluir(M model) throws ValidacaoException, BusinessException {

        verificar(model);

        try {
            getDao().excluir(model);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public void excluir(List<M> models) throws BusinessException {
        try {
            getDao().excluir(models);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public M get(Long id) throws BusinessException {
        try {
            return getDao().get(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar() throws BusinessException {
        try {
            return getDao().listar();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar(final M filtro) throws BusinessException {
        try {
            return getDao().listar(filtro);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar(final String... camposOrdenacao)
        throws BusinessException {

        try {
            return getDao().listar(camposOrdenacao);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public List<M> listar(M filtro, String... camposOrdenacao) throws BusinessException {

        try {
            return getDao().listar(filtro, camposOrdenacao);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }

    };

    /** {@inheritDoc} */
    public void persiste(M model) throws ValidacaoException, BusinessException {

        verificar(model);

        setNomeDataCadastro(model);

        try {
            getDao().persiste(model);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    /** {@inheritDoc} */
    public void persiste(List<M> models) throws ValidacaoException, BusinessException {

        for (M m : models) {
            this.persiste(m);
        }
    }

    /** {@inheritDoc} */
    public M get(M filtro) throws BusinessException {
        List<M> modelos = listar(filtro);

        if (!modelos.isEmpty()) {
            return modelos.get(0);
        }

        return null;
    };

    /** {@inheritDoc} */
    public Boolean isEmpty(M model) {
        return ValidaHelper.isEmpty(model);
    }

    /**
     * Faz a verificação de um objeto do mesmo ser salvo ou excluído.
     *
     * @param model objeto que será verificado
     * @exception ValidacaoException possíveis mensagens de erro
     */
    protected void verificar(M model) throws ValidacaoException {

        List<ValidacaoMensagem> mensagens = new ArrayList<ValidacaoMensagem>();

        Class<?> c = model.getClass();
        for (Field field : c.getDeclaredFields()) {
            List<ValidacaoMensagem> mensagem = verificar(model, field);
            for (ValidacaoMensagem validacaoMensagem : mensagem) {
                if (validacaoMensagem != null) {
                    mensagens.add(validacaoMensagem);
                }
            }
        }

        if (!mensagens.isEmpty()) {
            throw new ValidacaoException(mensagens);
        }
    }

    /**
     * Faz a verificação de um campo. Método que deve ser sobrescrito para o caso de
     * validações específicas.
     *
     * @param model objeto que será verificado
     * @param field campo que será lido
     * @return Lista de mensagens de validação
     */
    protected List<ValidacaoMensagem> verificar(M model, Field field) {

        List<ValidacaoMensagem> mensagens = new ArrayList<ValidacaoMensagem>();

        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            mensagens.add(verificaColuna(column, field, model));
        }

        if (field.isAnnotationPresent(JoinColumn.class)) {
            JoinColumn column = field.getAnnotation(JoinColumn.class);
            mensagens.add(verificaColuna(column, field, model));
        }

        return mensagens;
    }

    /**
     * Verifica a coluna.
     *
     * @param column coluna a ser verificada
     * @param field campo a ser lido
     * @param model modelo a ser validado
     * @return Mensagem de Validação, se houver
     */
    private ValidacaoMensagem verificaColuna(Column column, Field field, M model) {

        if (!column.nullable() && isNull(field, model)) {
            return new CannotBeNullMensagem(field, model);
        }

        return null;
    }

    /**
     * Verifica a coluna.
     *
     * @param column coluna a ser verificada
     * @param field campo a ser lido
     * @param model modelo a ser validado
     * @return Mensagem de Validação, se houver
     */
    private ValidacaoMensagem verificaColuna(JoinColumn column, Field field, M model) {

        if (!column.nullable() && isNull(field, model)) {
            return new CannotBeNullMensagem(field, model);
        }

        return null;
    }

    /**
     * Verifica se o valor do atributo é nulo.
     *
     * @param field Atributo a ser lido
     * @param instance objeto a ser lido
     * @return <code>true</code> para nulo
     */
    private Boolean isNull(Field field, M instance) {

        return ValidaHelper.isNull(field, instance);
    }

    /**
     * Seta o nome e a data de cadastro do model.
     * @param model model
     */
    protected void setNomeDataCadastro(Model model) {

        if (model.getUsuarioCadastro() == null) {
            model.setUsuarioCadastro(usuarioBusiness.getUsuarioLogado());
        }

        if (model.getDataCadastro() == null) {
            model.setDataCadastro(new Date());
        }
    }

    protected D getDao() {
        return dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    public void setUsuarioBusiness(UsuarioLogadoBusiness usuarioBusiness) {
        this.usuarioBusiness = usuarioBusiness;
    }

    public UsuarioLogadoBusiness getUsuarioBusiness() {
        return usuarioBusiness;
    }
}
