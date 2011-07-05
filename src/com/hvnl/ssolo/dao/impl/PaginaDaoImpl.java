/**
 * 
 */
package com.hvnl.ssolo.dao.impl;

import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.PaginaDao;
import com.hvnl.ssolo.model.Pagina;

/**
 * Implementacao do DAO de {@link Pagina}.
 * @author vinicius
 */
@Component("paginaDao")
public class PaginaDaoImpl extends HibernateDaoGenerico<Pagina> implements
		PaginaDao {

}
