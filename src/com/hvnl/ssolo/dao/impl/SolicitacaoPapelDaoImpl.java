/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;


import com.hvnl.ssolo.dao.SolicitacaoPapelDao;
import com.hvnl.ssolo.model.SolicitacaoPapel;

/**
 * Implementacao do DAO de {@link SolicitacaoPapel}.
 * @author vinicius
 */
@Component("solicitacaoPapelDao")
public class SolicitacaoPapelDaoImpl extends HibernateDaoGenerico<SolicitacaoPapel> implements
		SolicitacaoPapelDao {

}
