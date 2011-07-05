/*
 * 23/02/2011
 */
package com.hvnl.ssolo.util;

/**
 * Classe de constantes para o sistema.
 * @author heber
 */
public final class Constants {

    /**
     * Chave para pegar o usuario logado do sistema.
     * @see String
     */
    public static final String USUARIO_LOGADO_DO_SISTEMA = "USUARIO_LOGADO_DO_SISTEMA";

    /**
     * Nome do Host SMTP.
     */
    public static final String HOST_SMTP = "smtp.gmail.com";
    
    /**
     * Porta SMTP.
     */
    public static final int PORT_SMTP = 587;
    
    /**
     * Usuário do serviço SMTP.
     */
    public static final String USUARIO_SMTP = "ssolo@newgraf.com";
    
    /**
     * Senha de usuário do serviço SMTP.
     */
    public static final String SENHA_SMTP = "87654321";

    /**
     * Código da cidade brasileira tratada como padrão para o sistema.
     */
    public static final long CIDADE_PADRAO = 59;
    
    /**
     * Código do estado brasileiro tratado como padrão para o sistema.
     */
    public static final long ESTADO_PADRAO = 6;
    
    /**
     * Código do status "ATIVO" no banco de dados do sistema.
     */
    public static final long STATUS_ATIVO = 1;
    
    /**
     * Mensagem padrão de cadastro de entidades.
     */
    public static final String MENSAGEM_STATUS_ATIVO = "Cadastro Novo.";
    
    /**
     * Privado.
     */
    private Constants() { }
}
