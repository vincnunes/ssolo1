/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.LombadaDao;
import com.hvnl.ssolo.model.Lombada;

/**
 * Implementacao do DAO de {@link Lombada}.
 * @author vinicius
 */
@Component("lombadaDao")
public class LomabadaDaoImpl extends HibernateDaoGenerico<Lombada> implements
		LombadaDao {

}
