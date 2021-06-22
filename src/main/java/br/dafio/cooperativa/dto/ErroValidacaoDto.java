package br.dafio.cooperativa.dto;

public class ErroValidacaoDto {

    private String campo;
    private String erro;

    public ErroValidacaoDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}