package br.dafio.cooperativa.service;

import org.apache.logging.log4j.Logger;

public abstract class AbstractService {

    private static final String NMIDSESSAO = "nmIdSessao";
    private static final String NMIDTRANSACAO = "nmIdTransacao";
    private String identificador = "Serviço - ";

    protected abstract Logger getLogger();

    private void logInfo(String mensagem, String nmIdSessao, String nmIdTransacao) {
        getLogger().info(identificador.concat(mensagem), NMIDSESSAO, nmIdSessao, NMIDTRANSACAO, nmIdTransacao);
    }

    private void logErro(String mensagem, Exception ex, String nmIdSessao, String nmIdTransacao) {
        getLogger().info(identificador.concat(mensagem), NMIDSESSAO, nmIdSessao, NMIDTRANSACAO, nmIdTransacao, ex);
    }
}
