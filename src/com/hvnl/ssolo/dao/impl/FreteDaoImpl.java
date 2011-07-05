/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.FreteDao;
import com.hvnl.ssolo.model.Frete;

/**
 * Implementacao do DAO de {@link Frete}.
 * @author vinicius
 */
@Component("freteDao")
public class FreteDaoImpl extends HibernateDaoGenerico<Frete> implements
		FreteDao {

}
