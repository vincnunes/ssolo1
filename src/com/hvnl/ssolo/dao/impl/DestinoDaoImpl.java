/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.DestinoDao;
import com.hvnl.ssolo.model.Destino;

/**
 * Implementacao do DAO de {@link Destino}.
 * @author vinicius
 */
@Component("destinoDao")
public class DestinoDaoImpl extends HibernateDaoGenerico<Destino> implements
		DestinoDao {

}
