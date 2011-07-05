/*
 * 03/08/2009
 */
package com.hvnl.ssolo.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.hvnl.ssolo.model.Model;

/**
 * Implementação para uso de Criteria no hibernate.
 * @param <M> BaseModel
 * @author heber
 */
public class HibernateCriteriaFinder<M extends Model> implements HibernateCallback {

    /**
     * Logger do DAO.
     */
    private final Log log;

    /**
     * Classe do modelo.
     */
    private final Class<M> modelClass;
    /**
     * Filtro que será utilizado na busca.
     */
    private final M filtro;
    /**
     * Ordenação dos campos.
     */
    private final String [] ordenacao;

    /**
     * Lista de aliases.
     */
    private final List<Alias> aliases = new ArrayList<Alias>();

    /**
     * Lista de FetchModes.
     */
    private final List<Fetch> fetchs = new ArrayList<Fetch>();

    /**
     * Lista de {@link Criterion} que podem ser adicionados na {@link Criteria}.
     */
    private final List<Criterion> criterions = new ArrayList<Criterion>();

    /**
     * Verifica se existe alguma coleção no filtro.
     */
    private Boolean hasCollection = false;

    /**
     * Informa que a ordenação é ascendente.
     */
    private Boolean ascendentOrder = true;

    /**
     * Lista de subcriterias.
     */
    private final Map<String, SubCriteria> subcriterias =
        new Hashtable<String, SubCriteria>();

    /**
     * Quantidade máxima de resultados. Caso <code>null</code> não haverá limites.
     */
    private Integer maxResults;

    /**
     * Construtor padrão.
     * @param modelClass classe modelo para o criteria
     * @param filtro Filtro da pesquisa
     * @param ordenacao Order by da consulta
     */
    public HibernateCriteriaFinder(Class<M> modelClass, M filtro, String ... ordenacao) {
        this.filtro = filtro;
        this.ordenacao = ordenacao;
        this.modelClass = modelClass;

        this.log = LogFactory.getLog(modelClass);
    }

    /**
     * Adiciona um Alias no Criteria.
     * @param campo nome do atributo
     * @param nome alias a ser utilizado
     * @see Criteria#createAlias(String, String)
     */
    public void createAlias(String campo, String nome) {
        Alias alias = new Alias(nome, campo);
        aliases.add(alias);
    }

    /**
     * Adiciona um Criterion em uma subcriteria.
     * @param atributo nome do atributo
     * @param criterion que será adicionado
     */
    public void addSubCriterion(String atributo, Criterion criterion) {
        SubCriteria criteria = subcriterias.get(atributo);
        if (criteria == null) {
            criteria = new SubCriteria(atributo);
            subcriterias.put(atributo, criteria);
        }
        criteria.addCriterion(criterion);
    }

    /**
     * Seta FecthMode no Criteria.
     * @param campo nome do atributo
     * @param mode FetchMode
     */
    public void setFetchMode(String campo, FetchMode mode) {
        fetchs.add(new Fetch(campo, mode));
    }

    /**
     * Adiciona um {@link Criterion} para ser adicionada na execução de uma
     * {@link Criteria}.
     * @param criterion o que será adicionado
     */
    public void addCriterion(Criterion criterion) {
        if (criterion != null) {
            criterions.add(criterion);
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
	public Object doInHibernate(Session session) throws HibernateException,
            SQLException {
        Criteria criteria = session.createCriteria(this.modelClass);
        addCriterions(criteria);

        // O filtro só será utilizado se for diferente de null
        if (this.filtro != null) {
            addFields(criteria, this.filtro.getClass());
        }

        addOrders(criteria);
        addSubCriteria(criteria);
        addAliases(criteria);
        setFetchModes(criteria);

        if (maxResults != null) {
            criteria.setMaxResults(maxResults);
        }

        criteria.setCacheable(true);

        return filtraLista(criteria.list());
    }

    /**
     * Adiciona os campos de ordenação.
     * @param criteria onde serão adicionados
     */
    private void addOrders(Criteria criteria) {
        for (String campo : this.ordenacao) {
            if (ascendentOrder) {
                criteria.addOrder(Order.asc(campo));
            } else {
                criteria.addOrder(Order.desc(campo));
            }
        }
    }

    /**
     * Adiciona os campos para pesquisa.
     * @param criteria criteria hibernate
     * @param c classe
     */
    private void addFields(Criteria criteria, Class<?> c) {
        if (c == null) {
            return;
        }

        for (Field field : c.getDeclaredFields()) {
            if (field.getType().isAssignableFrom(Collection.class)) {
                hasCollection = true;
            }
            addCriterion(field, this.filtro, criteria);
        }

        addFields(criteria, c.getSuperclass());
    }

    /**
     * Tira os objetos repetidos da lista.
     * @param original conteudo a ser analisado
     * @return Lista sem objetos repetidos
     */
    private List<M> filtraLista(List<M> original) {
        // Se não houver nenhum alias a lista será retornada da mesma forma
        if (this.aliases.isEmpty() && !hasCollection) {
            return original;
        }

        List<M> modificada = new ArrayList<M>();

        for (M m : original) {
            if (!modificada.contains(m)) {
                modificada.add(m);
            }
        }

        return modificada;
    }

    /**
     * Adiciona todos os aliases na criteria.
     * @param criteria a ser utilizado
     */
    private void addAliases(Criteria criteria) {
        for (Alias alias : aliases) {
            criteria.createAlias(alias.campo, alias.nome, Criteria.LEFT_JOIN);
        }
    }

    /**
     * Adiciona todas as subcriterias.
     * @param criteria onde serão colocadas
     */
    private void addSubCriteria(Criteria criteria) {
        for (SubCriteria sub : subcriterias.values()) {
            Criteria cr = criteria.createCriteria(sub.nome);
            for (Criterion criterion : sub.criterions) {
                cr.add(criterion);
            }
        }
    }

    /**
     * Seta todos os FetchModes na criteria.
     * @param criteria a ser utilizado
     */
    private void setFetchModes(Criteria criteria) {
        for (Fetch f : fetchs) {
            criteria.setFetchMode(f.nome, f.mode);
        }
    }

    /**
     * Adiciona a lista de criterions na criteria.
     * @param criteria onde serão adicionados os Criterions
     */
    private void addCriterions(Criteria criteria) {
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
    }

    /**
     * Adiciona/cria um {@link Criterion} na {@link Criteria}.
     * @param field Atributo a ser lido
     * @param instance Objeto que terá seu atributo lido
     * @param criteria Onde o criterion gerado será adicionado
     */
    private void addCriterion(Field field, M instance, Criteria criteria) {
        Criterion criterion = getCriterion(field, instance);
        if (criterion != null) {
            criteria.add(criterion);
        }
    }

    /**
     * Cria um {@link Criterion}.
     * @param field Atributo que será lido
     * @param instance Objeto que terá seu atributo lido
     * @return Criterion gerado ou null caso o field seja transient
     */
    private Criterion getCriterion(Field field, M instance) {

        if (Modifier.isTransient(field.getModifiers())) {
            return null;
        }

        Object value = getValue(field, instance);

        if (isInvalidValue(value)) {
            return null;
        }

        String name = field.getName();

        Class<?> type = field.getType();
        if (type == String.class) {
            return ilike(name, (String) value);
        } else {
            return eq(name, value);
        }
    }

    /**
     * Verifica se o valor é válido.
     * @param value analizado
     * @return true se for NULL ou vazio ("")
     */
    private Boolean isInvalidValue(Object value) {
        if (value == null) {
            return true;
        }

        if (value instanceof Collection<?>) {
            hasCollection = true;
            return ((Collection<?>) value).isEmpty();
        }

        if (value instanceof Model) {
            return ((Model) value).getId() == null;
        }

        return value.equals("");
    }

    /**
     * Pega o valor de um atributo de um objeto.
     * @param field atributo a ser lido
     * @param instance objeto que contêm o atributo
     * @return valor do atributo
     */
    private Object getValue(Field field, M instance) {

        try {
            Method method = instance.getClass().getMethod(
                    getMethodName(field), new Class[]{});

            Object value = method.invoke(instance, new Object[]{});

            return value;

        } catch (InvocationTargetException e) {
            printStackTrace(e);
        } catch (IllegalAccessException e) {
            printStackTrace(e);
        } catch (SecurityException e) {
            printStackTrace(e);
        } catch (NoSuchMethodException e) {
            printStackTrace(e);
        }

        return null;
    }


    /**
     * Invoca o método printStackTrace de uma exceção e a lança para o log.
     * @param e exceção
     */
    private void printStackTrace(Exception e) {
        e.printStackTrace();
        log.info(e);
    }

    /**
     * Pega o método 'get' do atributo.
     * @param field Atributo a ser lido
     * @return nome do método
     */
    private String getMethodName(Field field) {
        String metodo = "get";
        String atributo = field.getName();
        String first = atributo.substring(0, 1).toUpperCase();
        String restante = "";

        if (atributo.length() > 1) {
            restante = atributo.substring(1, atributo.length());
        }

        return metodo + first + restante;
    }

    /**
     * Cria um {@link Criterion} EQUALS.
     * @param parameter nome do atributo referenciado
     * @param value valor que será comparado
     * @return null se o valor for null
     */
    public Criterion eq(String parameter, Object value) {
        if (value != null) {
            return Restrictions.eq(parameter, value);
        }
        return null;
    }

    /**
     * Cria um {@link Criterion} LIKE.
     * @param parameter nome do atributo referenciado
     * @param value valor que será comparado
     * @return null se o valor for null
     */
    public Criterion ilike(String parameter, String value) {
        if (value != null) {
            return Restrictions.ilike(parameter, value, MatchMode.ANYWHERE);
        }
        return null;
    }

    /**
     * Cria um {@link Criterion} BETWEEN.
     * @param parameter nome do atributo referenciado
     * @param value1 valor que será comparado
     * @param value2 valor que será comparado
     * @return null se o valor for null
     */
    public Criterion between(String parameter, Object value1, Object value2) {
        if (value1 != null && value2 != null) {
            return Restrictions.between(parameter, value1, value2);
        }
        return null;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setAscendentOrder(Boolean ascendentOrder) {
        this.ascendentOrder = ascendentOrder;
    }

    public Boolean getAscendentOrder() {
        return ascendentOrder;
    }

    /**
     * Alias para Criteria.
     * @author Heber
     */
    private final class Alias {
        /** Nome do atributo. */
        private final String nome;
        /** Nome do campo. */
        private final String campo;

        /**
         * Construtor padrão.
         * @param nome Nome do atributo
         * @param campo Nome do campo
         */
        private Alias(String nome, String campo) {
            this.campo = campo;
            this.nome = nome;
        }
    }

    /**
     * FetchMode para Criteria.
     * @author Heber
     */
    private final class Fetch {
        /** Nome do atributo. */
        private final String nome;
        /** Nome do campo. */
        private final FetchMode mode;

        /**
         * Construtor padrão.
         * @param nome Nome do atributo
         * @param mode Tipo do relacionamento
         */
        private Fetch(String nome, FetchMode mode) {
            this.mode = mode;
            this.nome = nome;
        }
    }

    /**
     * Subcriteria que será adicionada à Criteria.
     * @author heber
     */
    private class SubCriteria {
        /** Nome do atributo. */
        private final String nome;
        /** Criterions da subcriteria. */
        private final List<Criterion> criterions = new ArrayList<Criterion>();

        /**
         * Construtor padrão.
         * @param nome atributo subcriteria
         */
        public SubCriteria(String nome) {
            this.nome = nome;
        }

        /**
         * Adiciona um criterion.
         * @param criterion será adicionado
         */
        public void addCriterion(Criterion criterion) {
            criterions.add(criterion);
        }
    }
}