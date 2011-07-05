/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.OrcamentoDao;
import com.hvnl.ssolo.model.Orcamento;

/**
 * Implementacao do DAO de {@link Orcamento}.
 * @author vinicius
 */
@Component("orcamentoDao")
public class OrcamentoDaoImpl extends HibernateDaoGenerico<Orcamento> implements
		OrcamentoDao {

}
