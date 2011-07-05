/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.CorteDao;
import com.hvnl.ssolo.model.Corte;

/**
 * Implementacao do DAO de {@link Corte}.
 * @author vinicius
 */
@Component("corteDao")
public class CorteDaoImpl extends HibernateDaoGenerico<Corte> implements
		CorteDao {

}
