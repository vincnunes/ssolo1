/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ImpressaoDao;
import com.hvnl.ssolo.model.Impressao;

/**
 * Implementacao do DAO de {@link Impressao}.
 * @author vinicius
 */
@Component("impressaoDao")
public class ImpressaoDaoImpl extends HibernateDaoGenerico<Impressao> implements
		ImpressaoDao {

}
