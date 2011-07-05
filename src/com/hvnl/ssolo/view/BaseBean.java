/*
 * 28/07/2009
 */
package com.hvnl.ssolo.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.exception.ValidacaoException;
import com.hvnl.ssolo.model.Model;
import com.hvnl.ssolo.validation.CannotBeNullMensagem;
import com.hvnl.ssolo.validation.CpfCnpjInvalidoMensagem;
import com.hvnl.ssolo.validation.ValidacaoMensagem;

/**
 * Base para criação de Beans.
 *
 * @author heber
 */
public abstract class BaseBean implements Bean {
	
    /**
     * Ordenador de select itens.
     */
    private final Comparator<SelectItem> ordenadorSelectItem =
            new Comparator<SelectItem>() {

            public int compare(SelectItem s1, SelectItem s2) {

                verificaSubGrupo(s1);
                verificaSubGrupo(s2);

                int result = normalizar(s1.getLabel()).compareTo(
                        normalizar(s2.getLabel()));

                return result == 0 ? 1 : result;
            }
        };

    /**
     * Executa o {@link Normalizer#normalize(CharSequence, java.text.Normalizer.Form)}, e
     * depois executa {@link String#replaceAll(String, String)} com '[^\\p{ASCII}]'.
     * @param text texto a ser modificado
     * @return String normalizada
     */
    protected String normalizar(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Verifica se é um subgrupo e organiza seus filhos.
     * @param item a ser avaliado
     */
    protected void verificaSubGrupo(SelectItem item) {
        if (!(item instanceof SelectItemGroup)) {
            return;
        }

        SelectItemGroup group = (SelectItemGroup) item;

        List<SelectItem> itens = new ArrayList<SelectItem>();

        for (SelectItem selectItem : group.getSelectItems()) {
            itens.add(selectItem);
        }

        itens = ordena(itens);
        SelectItem [] array = new SelectItem[itens.size()];

        for (int i = 0; i < itens.size(); i++) {
            array[i] = itens.get(i);
        }

        group.setSelectItems(array);
    }

    /**
     * Ordena uma lista de SelectItens.
     * @param lista lista a ser ordenada
     * @return lista ordenada
     */
    protected List<SelectItem> ordena(List<SelectItem> lista) {

        Set<SelectItem> set = new TreeSet<SelectItem>(ordenadorSelectItem);
        set.addAll(lista);

        return new ArrayList<SelectItem>(set);
    }

    /**
     * Adiciona uma mensagem informativa.
     * @param message Mensagem a ser exibida.
     */
    protected void addInfoMessage(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, message);
    }

    /**
     * Adiciona uma mensagem informativa.
     * @param expression código da mensagem a ser exibida
     * @param argumentos textos que serão trocados na mensagem
     */
    protected void addInfoMessage(String expression, String... argumentos) {
        addInfoMessage(getMessage(expression, argumentos));
    }

    /**
     * Adiciona uma mensagem de erro.
     * @param message Mensagem a ser exibida.
     */
    protected void addErrorMessage(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, message);
    }

    /**
     * Adiciona uma mensagem de erro.
     *
     * @param expression código da mensagem a ser exibida
     * @param argumentos textos que serão trocados na mensagem
     */
    protected void addErrorMessage(String expression, String... argumentos) {
        addErrorMessage(getMessage(expression, argumentos));
    }

    /**
     * Adiciona uma mensagem de alerta.
     * @param message Mensagem a ser exibida.
     */
    protected void addAlertMessage(String message) {
        addMessage(FacesMessage.SEVERITY_WARN, message);
    }

    /**
     * Adiciona uma mensagem de erro.
     * @param expression código da mensagem a ser exibida
     * @param argumentos textos que serão trocados na mensagem
     */
    protected void addAlertMessage(String expression, String... argumentos) {
        addAlertMessage(getMessage(expression, argumentos));
    }

    /**
     * Adiciona uma mensagem no {@link FacesContext}.
     * @param tipo Tipo de mensagem
     * @param message Mensagem que será adicionada
     */
    protected void addMessage(Severity tipo, String message) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage facesMessage = new FacesMessage(message);
        facesMessage.setSeverity(tipo);

        context.addMessage(null, facesMessage);
    }

    /**
     * Adiciona uma {@link ValidacaoMensagem} no {@link FacesContext}.
     * @param message mensagem que será adicionada
     */
    protected void addMessage(ValidacaoMensagem message) {

        String texto = "";
        if (message instanceof CannotBeNullMensagem) {
            addErrorMessage("commons.mensagem.erro.validacao.not.null",
                    new String[] {
                        ((CannotBeNullMensagem) message).getCampo().getName() });
        } else if (message instanceof CpfCnpjInvalidoMensagem<?>) {

            CpfCnpjInvalidoMensagem<?> m = (CpfCnpjInvalidoMensagem<?>) message;

            texto = "commons.mensagem.erro.validacao.cnpj.invalido";

            if (m.isCpf()) {
                texto = "commons.mensagem.erro.validacao.cpf.invalido";
            }

            addErrorMessage(texto, new String[] {m.getCpfCnpj()});

        } else {
            if (message.getExpression() != null) {
                addErrorMessage(message.getExpression(), message.getArgumentos());
            } else {
                addErrorMessage(message.getMensagem());
            }
        }
    }

    /**
     * Pega uma mensagem de um arquivo de internacionalização.
     * @param expression Chave da mensagem
     * @return mensagem encontrada
     */
    protected String getMessage(String expression) {
        FacesContext context = FacesContext.getCurrentInstance();
        String value = (String) context.getApplication().evaluateExpressionGet(
                context, "#{msg['" + expression + "']}", String.class);

        return value;
    }

    /**
     * Pega uma mensagem de um arquivo de internacionalização.
     * @param expression chave da mensagem
     * @param argumentos textos a serem substituídos na mensagem
     * @return mensagem formatada
     */
    protected String getMessage(String expression, String... argumentos) {

        MessageFormat format = new MessageFormat(getMessage(expression));

        return format.format(argumentos);
    }

    /**
     * Trata as exceções.
     * @param e Exceção a ser tratada.
     */
    protected void tratarException(Exception e) {
        addErrorMessage(e.getLocalizedMessage());
    }


    /**
     * Trata as exceções de Facade.
     * @param e Exceção a ser tratada
     */
    protected void tratarFacadeException(FacadeException e) {
        e.printStackTrace();

        Throwable error = e;

        while (error.getCause() != null) {
            error = error.getCause();
        }

        addErrorMessage(error.getLocalizedMessage());
    }

    /**
     * Trata as exceções de validação.
     * @param e Exceção a ser tratada
     */
    protected void tratarValidacaoException(ValidacaoException e) {

        e.printStackTrace();

        List<ValidacaoMensagem> mensagens = e.getMensagens();
        if (mensagens == null || mensagens.isEmpty()) {
            addErrorMessage(e.getMessage());
        } else {
            for (ValidacaoMensagem validacaoMensagem : mensagens) {
                addMessage(validacaoMensagem);
            }
        }
    }

    /**
     * Gera uma lista de {@link SelectItem} a partir de uma lista de objetos.
     * @param lista Objetos que serão lidos
     * @param label Nome do campo que será exibido
     * @return SelectItens
     */
    protected List<SelectItem> gerarListaSelectItem(
            List<? extends Model> lista, String label) {

        List<SelectItem> itens = new ArrayList<SelectItem>();

        String metodo = getMethodName(label);

        for (Model model : lista) {
            itens.add(new SelectItem(model, getValue(metodo, model)));
        }

        return itens;
    }

    /**
     * Gera uma lista de {@link SelectItem} a partir de uma lista de objetos.
     * @param lista enums que serão lidos
     * @return SelectItens
     */
    protected List<SelectItem> gerarListaSelectItem(List<?> lista) {

        List<SelectItem> itens = new ArrayList<SelectItem>();

        for (Object e : lista) {
            itens.add(new SelectItem(e, e.toString()));
        }

        return itens;
    }

    /**
     * Pega o valor de um atributo de um objeto.
     * @param metodo atributo a ser lido
     * @param instance objeto que contêm o atributo
     * @return valor do atributo
     */
    private String getValue(String metodo, Model instance) {

        try {
            Method method = instance.getClass().getMethod(metodo, new Class[] {});

            Object value = method.invoke(instance, new Object[] {});

            return "" + value;

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return "null";
    }

    /**
     * Pega o método 'get' do atributo.
     * @param atributo Atributo a ser lido
     * @return nome do método
     */
    private String getMethodName(String atributo) {
        String metodo = "get";
        String first = atributo.substring(0, 1).toUpperCase();
        String restante = "";

        if (atributo.length() > 1) {
            restante = atributo.substring(1, atributo.length());
        }

        return metodo + first + restante;
    }

    /**
     * Gera um relatório PDF.
     * @param dados a serem lidos.
     * @param path local do arquivo jrxml
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioPDF(Collection<?> dados, String path, String fileName,
            Map<?, ?> parameters) {

        try {
            this.gerarRelatorioPDF(dados, JRXmlLoader.load(path), fileName, parameters);
        } catch (JRException e) {
            tratarException(e);
            e.printStackTrace();
        }
    }

    /**
     * Gera um relatório PDF.
     * @param dados a serem lidos.
     * @param design desenhor do relatório
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioPDF(Collection<?> dados, JasperDesign design,
            String fileName, Map<?, ?> parameters) {
    	try {
	        JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(dados);
	        this.gerarRelatorioPDF(datasource, design, fileName, parameters);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * Gera um relatório PDF, com nenhum parâmetro.
     * @param dados a serem lidos.
     * @param path local do arquivo jrxml
     * @param fileName nome do relatorio
     * @see #gerarRelatorioPDF(Collection, String, String, Map)
     */
    protected void gerarRelatorioPDF(Collection<?> dados, String path, String fileName) {
    	Hashtable<Object, Object> parametros = new Hashtable<Object, Object>();
    	parametros.put("LOGO", getServletContext().getRealPath("/imagens/logomarca.jpg"));
    	
        this.gerarRelatorioPDF(dados, path, fileName, parametros);
    }
    /**
     * Gera um relatório PDF, com nenhum parâmetro.
     * @param dados a serem lidos.
     * @param design {@link JasperDesign}
     * @param fileName nome do relatorio
     * @see #gerarRelatorioPDF(Collection, String, String, Map)
     */
    protected void gerarRelatorioPDF(Collection<?> dados, JasperDesign design,
            String fileName) {
    	Hashtable<Object, Object> parametros = new Hashtable<Object, Object>();
    	parametros.put("LOGO", getServletContext().getRealPath("/imagens/logomarca.jpg"));
        this.gerarRelatorioPDF(dados, design, fileName, parametros);
    }

    /**
     * Gera um relatório PDF.
     * @param dados a serem lidos.
     * @param path local do arquivo jrxml
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioPDF(JRDataSource dados, String path, String fileName,
            Map<?, ?> parameters) {

        try {
            this.gerarRelatorioPDF(dados, JRXmlLoader.load(path), fileName, parameters);
        } catch (JRException e) {
            tratarException(e);
        }
    }

    /**
     * Gera um relatório PDF.
     * @param dados a serem lidos.
     * @param design desenhor do relatório
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioPDF(JRDataSource dados, JasperDesign design,
            String fileName, Map<?, ?> parameters) {

        try {
            JasperPrint jasperPrint = compileCreateJasper(dados, design, parameters);
            byte [] gerado = JasperExportManager.exportReportToPdf(jasperPrint);
            download(gerado, "PDF", fileName + ".pdf");
        } catch (JRException e) {
            tratarException(e);
            e.printStackTrace();
        }
    }

    /**
     * Gera um relatório XLS.
     * @param dados a serem lidos.
     * @param path local do arquivo jrxml
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioXLS(Collection<?> dados, String path, String fileName,
            Map<?, ?> parameters) {

        try {
            this.gerarRelatorioXLS(dados, JRXmlLoader.load(path), fileName, parameters);
        } catch (JRException e) {
            tratarException(e);
        }
    }

    /**
     * Gera um relatório XLS.
     * @param dados a serem lidos.
     * @param design desenhor do relatório
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioXLS(Collection<?> dados, JasperDesign design,
            String fileName, Map<?, ?> parameters) {

        JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(dados);
        this.gerarRelatorioXLS(datasource, design, fileName, parameters);
    }
    /**
     * Gera um relatório XLS, com nenhum parâmetro.
     * @param dados a serem lidos.
     * @param path local do arquivo jrxml
     * @param fileName nome do relatorio
     * @see #gerarRelatorioPDF(Collection, String, String, Map)
     */
    protected void gerarRelatorioXLS(Collection<?> dados, String path, String fileName) {
        this.gerarRelatorioXLS(dados, path, fileName, new Hashtable<Object, Object>());
    }
    /**
     * Gera um relatório XLS, com nenhum parâmetro.
     * @param dados a serem lidos.
     * @param design {@link JasperDesign}
     * @param fileName nome do relatorio
     * @see #gerarRelatorioPDF(Collection, String, String, Map)
     */
    protected void gerarRelatorioXLS(Collection<?> dados, JasperDesign design,
            String fileName) {

        this.gerarRelatorioXLS(dados, design, fileName, new Hashtable<Object, Object>());
    }

    /**
     * Gera um relatório XLS.
     * @param dados a serem lidos.
     * @param path local do arquivo jrxml
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioXLS(JRDataSource dados, String path, String fileName,
            Map<?, ?> parameters) {

        try {
            this.gerarRelatorioXLS(dados, JRXmlLoader.load(path), fileName, parameters);
        } catch (JRException e) {
            tratarException(e);
        }
    }

    /**
     * Gera um relatório XLS.
     * @param dados a serem lidos.
     * @param design desenhor do relatório
     * @param fileName nome do relatorio
     * @param parameters parâmetros para o relatórios
     */
    protected void gerarRelatorioXLS(JRDataSource dados, JasperDesign design,
            String fileName, Map<?, ?> parameters) {

        try {
            JasperPrint jasperPrint = compileCreateJasper(dados, design, parameters);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            //JRXlsExporter xls = new JRXlsExporter();
            JExcelApiExporter xls = new JExcelApiExporter();

            xls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            xls.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
            xls.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);

            xls.setParameter(
                    JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE,
                    Boolean.TRUE);
            xls.setParameter(
                    JRXlsAbstractExporterParameter.IS_IMAGE_BORDER_FIX_ENABLED,
                    Boolean.TRUE);
            xls.setParameter(
                    JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                    Boolean.TRUE);
            xls.setParameter(
                    JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
                    Boolean.TRUE);
            xls.setParameter(
                    JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND,
                    Boolean.FALSE);
            xls.setParameter(
                    JRXlsAbstractExporterParameter.MAXIMUM_ROWS_PER_SHEET,
                    Integer.decode("65000"));

            xls.exportReport();

            byte[] bytes = output.toByteArray();

            download(bytes, "application/vnd.ms-excel", fileName + ".xls");

        } catch (JRException e) {
            tratarException(e);
        }
    }

    /**
     * Cria e compila o relatório.
     * @param dados datasource
     * @param design desenho do relatório
     * @return JasperPrint
     * @throws JRException caso haja algum erro no Jasper
     * @param parameters parâmetros para o relatórios
     */
    private JasperPrint compileCreateJasper(JRDataSource dados, JasperDesign design,
            Map<?, ?> parameters) throws JRException {

        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        return JasperFillManager.fillReport(jasperReport, parameters, dados);
    }

    /**
     * Seta o header do response como download.
     * @param conteudo conteúdo que será exibido
     * @param contentType tipo do retorno
     * @param fileName nome do arquivo
     */
    protected void download(byte[] conteudo, String contentType, String fileName) {
        try {
            HttpServletResponse response = getHttpServletResponse();
            response.setContentType(contentType);
            response.addHeader("CACHE-CONTROL", "NO-CACHE");
            response.addHeader("Content-Disposition", "attachment; "
                    + "filename=\"" + fileName + "\"");
            OutputStream responseStream = response.getOutputStream();
            responseStream.write(conteudo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FacesContext.getCurrentInstance().responseComplete();
    }

    /**
     * Pega o path real do arquivo.
     * @param fileName arquivo a ser localizado
     * @return path real
     */
    protected String getRealPath(String fileName) {
        return getServletContext().getRealPath(fileName);
    }

    protected ServletContext getServletContext() {
        return (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();
    }
}
