/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.GrampoDao;
import com.hvnl.ssolo.model.Grampo;

/**
 * Implementacao do DAO de {@link Grampo}.
 * @author vinicius
 */
@Component("grampoDao")
public class GrampoDaoImpl extends HibernateDaoGenerico<Grampo> implements
		GrampoDao {

}
