import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import com.hvnl.ssolo.model.Solicitacao;
import com.hvnl.ssolo.util.Constants;

public class Teste {
	
	private StringBuffer montaLocaisEntrega(Solicitacao selecionado) {
		StringBuffer mensagem = new StringBuffer();
		
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Logradouro:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>Rua dois mil e dez, 1876</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Bairro:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>Passar&eacute;</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Cidade:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>Fortaleza</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Estado:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>Cear&aacute;</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>CEP:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%;\">\n");
			mensagem.append("				<span>60187-263</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
			mensagem.append("		<div style=\"margin: 0 0 10px 0; padding: 0;\">\n");
			mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 30%; float: left; text-align: right;\">\n");
			mensagem.append("				<label>Ponto de Refer&ecirc;ncia:</label>\n");
			mensagem.append("			</div>\n");
			mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 70%; min-height: 100px; padding: 0 0 0 150px; text-align: justify;\">\n");
			mensagem.append("				<span style=\"\">Pr&oacute;ximo daquele lugar, do outro lado, perto do bar na esquina, depois da curva.</span>\n");
			mensagem.append("			</div>\n");
			mensagem.append("		</div>\n");
		
		return mensagem;
	}
	
	public StringBuffer mensagemVendedor(Solicitacao selecionado) {
		StringBuffer mensagem = new StringBuffer();
		mensagem.append("<div id=\"dados_solicitacao\" style=\"background-color: #dfdffd; padding: 10px; font-family: Arial; width: 70%;\">\n");
		mensagem.append("	<label style=\"font-weight: bold;\">Solicita&ccedil;&atilde;o de Or&ccedil;amento n&ordm; 230 finalizada em 16/05/2011.</label>\n");
		mensagem.append("	<fieldset style=\"margin: 5px 0 0 0;\">\n");
		mensagem.append("		<legend style=\"padding: 10px;\">Informa&ccedil;&otilde;es Principais da Solicita&ccedil;&atilde;o</legend>\n");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">\n");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">\n");
		mensagem.append("				<label>Nome do Cliente/Ag&ecirc;ncia:</label>\n");
		mensagem.append("			</div>\n");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">\n");
		mensagem.append("				<span>Internet 5</span>\n");
		mensagem.append("			</div>\n");
		mensagem.append("		</div>\n");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">\n");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">\n");
		mensagem.append("				<label>Servi&ccedil;o Solicita&ccedil;&atilde;o:</label>\n");
		mensagem.append("			</div>\n");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">\n");
		mensagem.append("				<span>R&oacute;tulo</span>\n");
		mensagem.append("			</div>\n");
		mensagem.append("		</div>\n");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">\n");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">\n");
		mensagem.append("				<label>Quantide Total Solicitada:</label>\n");
		mensagem.append("			</div>\n");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">\n");
		mensagem.append("				<span>5000</span>\n");
		mensagem.append("			</div>\n");
		mensagem.append("		</div>\n");
		mensagem.append("		<div style=\"margin: 0 0 10px 0; float: left; width: 100%;\">\n");
		mensagem.append("			<div style=\"padding: 0 10px 0 0; font-weight: bold; width: 35%; float: left; text-align: right;\">\n");
		mensagem.append("				<label>Data de Entrega:</label>\n");
		mensagem.append("			</div>\n");
		mensagem.append("			<div style=\"margin: 0 0 0 15px; width: 65%;\">\n");
		mensagem.append("				<span>18/10/2011</span>\n");
		mensagem.append("			</div>\n");
		mensagem.append("		</div>\n");
		mensagem.append("	</fieldset>\n");
		mensagem.append("	<fieldset>\n");
		mensagem.append("		<legend style=\"padding: 10px;\">Locais de Entrega</legend>\n");
		mensagem.append(montaLocaisEntrega(selecionado));
		mensagem.append("	</fieldset>\n");
		mensagem.append("</div>\n");
		return mensagem;
	}
	
	public void send() {
		try {
	        HtmlEmail email = new HtmlEmail();
	        email.setHostName(Constants.HOST_SMTP);
	        email.setSmtpPort(Constants.PORT_SMTP);
	        email.setAuthenticator(new DefaultAuthenticator(Constants.USUARIO_SMTP, Constants.SENHA_SMTP));
	        email.setDebug(true);
	        email.setFrom(Constants.USUARIO_SMTP, "Solicitação de Orçamento");
	        email.setSubject("Solicitacao no. 230 Finalizada");
	        email.addTo("vincnunes@gmail.com", "Vinicius Nunes");
	        
	        email.setHtmlMsg(mensagemVendedor(null).toString());
	        
	        email.send();
        } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Teste teste = new Teste();
		System.out.println(teste.mensagemVendedor(null));
//		teste.send();
	}
}
