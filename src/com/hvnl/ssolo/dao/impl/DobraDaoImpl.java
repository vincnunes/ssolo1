/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.DobraDao;
import com.hvnl.ssolo.model.Dobra;

/**
 * Implementacao do DAO de {@link Dobra}.
 * @author vinicius
 */
@Component("dobraDao")
public class DobraDaoImpl extends HibernateDaoGenerico<Dobra> implements
		DobraDao {

}
