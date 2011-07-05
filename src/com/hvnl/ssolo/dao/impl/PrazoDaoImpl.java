/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.PrazoDao;
import com.hvnl.ssolo.model.Prazo;

/**
 * Implementacao do DAO de {@link Prazo}.
 * @author vinicius
 */
@Component("prazoDao")
public class PrazoDaoImpl extends HibernateDaoGenerico<Prazo> implements
		PrazoDao {

}
