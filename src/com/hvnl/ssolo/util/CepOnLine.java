/**
 * 
 */
package com.hvnl.ssolo.util;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hvnl.ssolo.exception.FacadeException;
import com.hvnl.ssolo.facade.CrudCidadeFacade;
import com.hvnl.ssolo.model.Cidade;
import com.hvnl.ssolo.model.Endereco;

/**
 * @author vinicius nunes
 * @since 10/05/2011
 *
 */
@Component("cepOnLine")
@SuppressWarnings("unchecked")
public class CepOnLine {
	
	private CrudCidadeFacade cidadeFacade;
	
	private Integer resultado;
	
	@Autowired
	public void setCrudCidadeFacade(@Qualifier("crudCidadeFacade") CrudCidadeFacade cidadeFacade) {
		this.cidadeFacade = cidadeFacade;
	}
	
	public void getCep(Endereco endereco) {
		try {
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + endereco.getCep() + "&formato=xml");

            Document document = getDocumento(url);

            Element root = document.getRootElement();

			for (Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
                Element element = i.next();
                
                if (element.getQualifiedName().equals("cidade")) {
                	Cidade cidade = new Cidade();
                	cidade.setNome(element.getText());
                	endereco.setCidade(cidadeFacade.filtrar(cidade).get(0));
                }
                
                if (element.getQualifiedName().equals("bairro")) {
                	endereco.setBairro(element.getText());
                }
                
                if (element.getQualifiedName().equals("tipo_logradouro")) {
                	endereco.setLogradouro(element.getText() + " ");
                }
                
                if (element.getQualifiedName().equals("logradouro")) {
                	String logradouro = endereco.getLogradouro() + element.getText();
                	endereco.setLogradouro(logradouro);
                }
                
                if (element.getQualifiedName().equals("resultado")) {
                	resultado = Integer.valueOf(element.getText());
                	if (!resultado.equals(new Integer(1))) {
                		throw new FacadeException("CEP não encontrado!");
                	}
                }
                
//                if (element.getQualifiedName().equals("resultado_txt"))
//                    setResultado_txt(element.getText());                                
            }
        } catch (FacadeException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
	
	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
}