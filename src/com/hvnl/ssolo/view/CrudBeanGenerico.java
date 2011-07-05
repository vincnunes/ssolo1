/*
 * 07/07/2009
 */
package com.hvnl.ssolo.view;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.facade.CrudFacade;
import com.hvnl.ssolo.model.Model;
import com.hvnl.ssolo.util.CepOnLine;

/**
 * Bean genérico para realizar um CRUD.
 *
 * @param <M> Entidade que será tratada no bean
 * @param <C> Tipo da fachada do bean
 * @author heber
 */
public abstract class CrudBeanGenerico<M extends Model, C extends CrudFacade<M>>
    extends BaseBean {

    /**
     * Objeto que será utilizado para criar/alterar uma entidade.
     */
    private M selecionado;

    /**
     * Lista de registros da entidade.
     */
    private List<M> selecionados;
    
    /**
     * Classe de controle do webservice de endereços do Brasil.
     */
    private CepOnLine cepOnLine;
    
    public CepOnLine getCepOnLine() {
		return cepOnLine;
	}

	public void setCepOnLine(CepOnLine cepOnline) {
		this.cepOnLine = cepOnline;
	}
    
    /**
     * Fachada do caso de uso.
     */
    private C crudFacade;

    public void setCrudFacade(C crudFacade) {
        this.crudFacade = crudFacade;
    }

    public C getCrudFacade() {
        return crudFacade;
    }

    /**
     * Get selecionado.
     *
     * @return the selecionado
     */
    public M getSelecionado() {
        if (selecionado == null) {
            selecionado = getNewModel();
        }
        return selecionado;
    }

    /**
     * Set selecionado.
     *
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(M selecionado) {
        this.selecionado = selecionado;
    }

    public List<M> getSelecionados() {
        return selecionados;
    }

    protected void setSelecionados(List<M> selecionados) {
        this.selecionados = selecionados;
    }

    /**
     * Exclue o registro selecionado da entidade.
     *
     * @return navegação
     * @see CrudBeanGenerico#selecionado
     */
    public String excluir() {
        try {
            getCrudFacade().excluir(selecionado);
            addInfoMessage("commons.mensagem.excluido",
                    new String[] {"O Registro de código "
                            + selecionado.getId().toString()});
            iniciar();
            return Outcome.CRUD_EXCLUIR;
        } catch (ValidacaoException e) {
            tratarValidacaoException(e);
            return Outcome.ERROR;
        } catch (FacadeException e) {
            tratarFacadeException(e);
            return Outcome.ERROR;
        }
    }

    /**
     * Salva o registro selecionado.
     *
     * @return navegação
     * @see CrudBeanGenerico#selecionado
     */
    public String salvar() {

        Boolean isNew = selecionado.getId() == null;

        try {

            getCrudFacade().salvar(selecionado);
            addInfoMessage("commons.mensagem.salvo",
                    new String[] {"O Registro de código "
                            + selecionado.getId().toString()});
            iniciar();
            return Outcome.CRUD_SALVAR;
        } catch (ValidacaoException e) {
            if (isNew) {
                // Caso seja um novo registro
                selecionado.setId(null);
            }
            tratarValidacaoException(e);
            return Outcome.ERROR;
        } catch (FacadeException e) {
            if (isNew) {
                // Caso seja um novo registro
                selecionado.setId(null);
            }
            tratarFacadeException(e);
            return Outcome.ERROR;
        }
    }

    /**
     * Muda o fluxo da página para edição.
     *
     * @return navegação
     */
    public String editar() {
        return Outcome.CRUD_EDITAR;
    }

    /**
     * Muda o fluxo da página para criar um novo registro.
     *
     * @return navegação
     */
    public String novo() {
        selecionado = getNewModel();
        return Outcome.CRUD_NOVO;
    }

    /** {@inheritDoc} */
    public String iniciar() {
        selecionado = getNewModel();
        setSelecionados(new ArrayList<M>());
        /* selecionados = getCrudFacade().listar(); */
        return getNavegacaoInicial();
    }

    /**
     * Filtra uma lista de modelos.
     *
     * @return navegação
     */
    public String filtrar() {
        try {
            setSelecionados(getCrudFacade().filtrar(selecionado, getCamposOrdenacao()));

            if (selecionados.isEmpty()) {
                addAlertMessage("commons.mensagem.sem.resultado", new String[] {});
            }
        } catch (FacadeException e) {
            tratarFacadeException(e);
            e.printStackTrace();
        }

        return Outcome.CRUD_LISTAR;
    }

    /**
     * Cancela a ação.
     *
     * @return navegação
     */
    public String cancelar() {
        iniciar();
        return Outcome.CANCELAR;
    }

    /**
     * Gera o relatorio.
     */
    public void relatorio() {

        this.relatorioPDF();
    }
    
    /**
     * Gera o relatorio.
     */
    public void relatorio(Hashtable<Object, Object> parameters) {

        this.relatorioPDF(parameters);
    }

    /**
     * Gera o relatorio PDF.
     */
    public void relatorioPDF() {
        String reportName = this.getReportName();

        String path = super.getRealPath("/reports/" + reportName + ".jrxml");

        super.gerarRelatorioPDF(getSelecionados(), path, reportName);
    }
    
    /**
     * Gera o relatorio PDF.
     */
    public void relatorioPDF(Hashtable<Object, Object> parameters) {
        String reportName = this.getReportName();

        String path = super.getRealPath("/reports/" + reportName + ".jrxml");
        
        parameters.put("LOGO", getServletContext().getRealPath("/imagens/logomarca.jpg"));
        super.gerarRelatorioPDF(getSelecionados(), path, reportName, parameters);
    }
    
    /**
     * Gera o relatorio PDF.
     */
    public void relatorioPDF(Collection<?> lista, Hashtable<Object, Object> parameters) {
        String reportName = this.getReportName();

        String path = super.getRealPath("/reports/" + reportName + ".jrxml");
        
        parameters.put("LOGO", getServletContext().getRealPath("/imagens/logomarca.jpg"));
        super.gerarRelatorioPDF(lista, path, reportName, parameters);
    }

    /**
     * Gera o relatório XLS.
     */
    public void relatorioXLS() {
        String reportName = this.getReportName();

        String path = super.getRealPath("/reports/" + reportName + ".jrxml");

        super.gerarRelatorioXLS(getSelecionados(), path, reportName);
    }

    /**
     * Pega o nome do relatório a ser criado.
     * @return nome do relatório
     */
    protected String getReportName() {
        Class<M> clazz = this.getModelClass();

        return clazz.getName().replaceAll(
                clazz.getPackage().getName() + ".", "").toLowerCase();
    }

    /**
     * Nome dos campos que servirao para ordenar a lista.
     * @return campos/atributos
     */
    protected String[] getCamposOrdenacao() {
        return new String[]{"id"};
    }

    /**
     * Pega o Class do modelo.
     * @return Class do modelo.
     */
    @SuppressWarnings("unchecked")
	private Class<M> getModelClass() {
        return (Class<M>) ((ParameterizedType) getClass()
                     .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Retorna uma nova instância de {@link Model}.
     * @return nova instância
     */
    protected M getNewModel() {
        try {
            return getModelClass().newInstance();
        } catch (InstantiationException e) {
            addErrorMessage(e.getMessage());
            return null;
        } catch (IllegalAccessException e) {
            addErrorMessage(e.getMessage());
            return null;
        }
    }

    /**
     * Nagegação inicial do bean onde será redirecionado para uma página.
     *
     * @return navegação do bean
     */
    protected abstract String getNavegacaoInicial();
}
