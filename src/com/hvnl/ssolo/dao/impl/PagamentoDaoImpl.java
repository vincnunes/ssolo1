/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.PagamentoDao;
import com.hvnl.ssolo.model.Pagamento;

/**
 * Implementacao do DAO de {@link Pagamento}.
 * @author vinicius
 */
@Component("pagamentoDao")
public class PagamentoDaoImpl extends HibernateDaoGenerico<Pagamento> implements
		PagamentoDao {

}
