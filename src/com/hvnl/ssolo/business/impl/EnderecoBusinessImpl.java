/**
 * 
 */
package com.hvnl.ssolo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.business.EnderecoBusiness;
import com.hvnl.ssolo.dao.EnderecoDao;
import com.hvnl.ssolo.model.Endereco;

/**
 * Implementacao do business de {@link Endereco}.
 * @author vinicius
 */
@Component("enderecoBusiness")
public class EnderecoBusinessImpl extends BusinessGenerico<Endereco, EnderecoDao>
		implements EnderecoBusiness {
	
	/** {@inheritDoc} */
    @Override
    @Autowired
    public void setDao(@Qualifier("enderecoDao") EnderecoDao dao) {
        super.setDao(dao);
    }
    
}
