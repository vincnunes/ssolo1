/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.GramaturaDao;
import com.hvnl.ssolo.model.Gramatura;

/**
 * Implementacao do DAO de {@link Gramatura}.
 * @author vinicius
 */
@Component("gramaturaDao")
public class GramaturaDaoImpl extends HibernateDaoGenerico<Gramatura> implements
		GramaturaDao {

}
