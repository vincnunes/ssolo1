/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.TransportadoraDao;
import com.hvnl.ssolo.model.Transportadora;

/**
 * Implementacao do DAO de {@link Transportadora}.
 * @author vinicius
 */
@Component("transportadoraDao")
public class TransportadoraDaoImpl extends HibernateDaoGenerico<Transportadora> implements
		TransportadoraDao {

}
