/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.ServicoDao;
import com.hvnl.ssolo.model.Servico;

/**
 * Implementacao do DAO de {@link Servico}.
 * @author vinicius
 */
@Component("servicoDao")
public class ServicoDaoImpl extends HibernateDaoGenerico<Servico> implements
		ServicoDao {

}
