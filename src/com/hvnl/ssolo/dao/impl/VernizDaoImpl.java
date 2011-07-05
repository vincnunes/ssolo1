/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.VernizDao;
import com.hvnl.ssolo.model.Verniz;

/**
 * Implementacao do DAO de {@link Verniz}.
 * @author vinicius
 */
@Component("vernizDao")
public class VernizDaoImpl extends HibernateDaoGenerico<Verniz> implements
		VernizDao {

}
