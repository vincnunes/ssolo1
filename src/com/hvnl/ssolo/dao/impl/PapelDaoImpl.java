/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.PapelDao;
import com.hvnl.ssolo.model.Papel;

/**
 * Modelo de DAO para {@link Papel}.
 * @author vinicius
 */
@Component("papelDao")
public class PapelDaoImpl extends HibernateDaoGenerico<Papel> implements PapelDao {

	
}
