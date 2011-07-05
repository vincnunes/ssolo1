/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;


import com.hvnl.ssolo.dao.SolicitacaoDestinoDao;
import com.hvnl.ssolo.model.SolicitacaoDestino;

/**
 * Implementacao do DAO de {@link SolicitacaoDestino}.
 * @author vinicius
 */
@Component("solicitacaoDestinoDao")
public class SolicitacaoDestinoDaoImpl extends HibernateDaoGenerico<SolicitacaoDestino> implements
		SolicitacaoDestinoDao {

}
