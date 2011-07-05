/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ProvaDao;
import com.hvnl.ssolo.model.Prova;

/**
 * Implementacao do DAO de {@link Prova}.
 * @author vinicius
 */
@Component("provaDao")
public class ProvaDaoImpl extends HibernateDaoGenerico<Prova> implements
		ProvaDao {

}
