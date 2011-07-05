/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.PlastificacaoDao;
import com.hvnl.ssolo.model.Plastificacao;

/**
 * Implementacao do DAO de {@link Plastificacao}.
 * @author vinicius
 */
@Component("plastificacaoDao")
public class PlastificacaoDaoImpl extends HibernateDaoGenerico<Plastificacao> implements
		PlastificacaoDao {

}
