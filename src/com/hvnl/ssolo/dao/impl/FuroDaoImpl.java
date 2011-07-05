/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.FuroDao;
import com.hvnl.ssolo.model.Furo;

/**
 * Implementacao do DAO de {@link Furo}.
 * @author vinicius
 */
@Component("furoDao")
public class FuroDaoImpl extends HibernateDaoGenerico<Furo> implements
		FuroDao {

}
