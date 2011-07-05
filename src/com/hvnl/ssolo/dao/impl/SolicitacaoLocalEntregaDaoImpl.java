/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;


import com.hvnl.ssolo.dao.SolicitacaoLocalEntregaDao;
import com.hvnl.ssolo.model.SolicitacaoLocalEntrega;

/**
 * Implementacao do DAO de {@link SolicitacaoLocalEntrega}.
 * @author vinicius
 */
@Component("solicitacaoLocalEntregaDao")
public class SolicitacaoLocalEntregaDaoImpl extends HibernateDaoGenerico<SolicitacaoLocalEntrega> implements
		SolicitacaoLocalEntregaDao {

}
