/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.AgenciaPublicitariaDao;
import com.hvnl.ssolo.model.AgenciaPublicitaria;

/**
 * Implementacao do DAO de {@link AgenciaPublicitaria}.
 * @author vinicius
 */
@Component("agenciaPublicitariaDao")
public class AgenciaPublicitariaDaoImpl extends HibernateDaoGenerico<AgenciaPublicitaria> implements
		AgenciaPublicitariaDao {

}
