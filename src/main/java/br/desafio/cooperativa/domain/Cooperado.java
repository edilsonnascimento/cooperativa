package br.desafio.cooperativa.domain;

import javax.persistence.*;

@Entity
@Table(name = "cooperado")
public class Cooperado extends CooperativaDomain{

	@Id
	@Column(name = "id_cooperado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(name = "documento_nacional")
	private String documentoNacional;


	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentoNacional() {
		return documentoNacional;
	}

	public void setDocumentoNacional(String documentoNacional) {
		this.documentoNacional = documentoNacional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
 
