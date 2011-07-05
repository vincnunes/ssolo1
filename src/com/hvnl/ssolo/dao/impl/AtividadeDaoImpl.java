/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.AtividadeDao;
import com.hvnl.ssolo.model.Atividade;

/**
 * Implementacao do DAO de {@link Atividade}.
 * @author vinicius
 */
@Component("atividadeDao")
public class AtividadeDaoImpl extends HibernateDaoGenerico<Atividade> implements
		AtividadeDao {
	
}
