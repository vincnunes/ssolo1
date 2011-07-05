/**
 *
 */
package com.hvnl.ssolo.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.dao.SolicitacaoDao;
import com.hvnl.ssolo.exception.DaoException;
import com.hvnl.ssolo.model.Solicitacao;

/**
 * Implementacao do DAO de {@link Solicitacao}.
 * @author vinicius
 */
@Component("solicitacaoDao")
public class SolicitacaoDaoImpl extends HibernateDaoGenerico<Solicitacao> implements
		SolicitacaoDao {

    /** {@inheritDoc} */
    public List<Solicitacao> listar(Solicitacao filtro, String... camposOrdenacao) throws DaoException {

        HibernateCriteriaFinder<Solicitacao> action =
            new HibernateCriteriaFinder<Solicitacao>(Solicitacao.class, filtro, camposOrdenacao);

        if (filtro.getDataCadastroInicial() != null && filtro.getDataCadastroFinal() != null) {
        	restricaoPeriodo(action, filtro.getDataCadastroInicial(), filtro.getDataCadastroFinal(),
        					"dataCadastro");
        }

        if (filtro.getDataFinalizacaoInicial() != null && filtro.getDataFinalizacaoFinal() != null) {
        	restricaoPeriodo(action, filtro.getDataFinalizacaoInicial(), filtro.getDataFinalizacaoFinal(),
        					"dataFinalizacao");
        }

        return super.listar(action);
    }
    
    private void restricaoPeriodo(HibernateCriteriaFinder<Solicitacao> action, 
    									Date dataInicial, Date dataFinal, String campoRestricao) {
    	Calendar inicio = Calendar.getInstance();
    	inicio.setTime(dataInicial);
    	inicio.set(Calendar.DATE, inicio.get(Calendar.DATE) - 1);

    	Calendar fim = Calendar.getInstance();
    	fim.setTime(dataFinal);
    	fim.set(Calendar.DATE, fim.get(Calendar.DATE) + 1);

        action.addCriterion(Restrictions.between(campoRestricao,
                inicio.getTime(), fim.getTime()));
    }
}
