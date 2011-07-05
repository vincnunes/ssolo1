/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.EstadoDao;
import com.hvnl.ssolo.model.Estado;

/**
 * Implementacao do DAO de {@link Estado}.
 * @author vinicius
 */
@Component("estadoDao")
public class EstadoDaoImpl extends HibernateDaoGenerico<Estado> implements
		EstadoDao {

}
