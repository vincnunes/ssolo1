/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.CapaDao;
import com.hvnl.ssolo.model.Capa;

/**
 * Implementacao do DAO de {@link Capa}.
 * @author vinicius
 */
@Component("capaDao")
public class CapaDaoImpl extends HibernateDaoGenerico<Capa> implements
		CapaDao {

}
