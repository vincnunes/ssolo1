/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ImpostoDao;
import com.hvnl.ssolo.model.Imposto;

/**
 * Implementacao do DAO de {@link Imposto}.
 * @author vinicius
 */
@Component("impostoDao")
public class ImpostoDaoImpl extends HibernateDaoGenerico<Imposto> implements
		ImpostoDao {

}
