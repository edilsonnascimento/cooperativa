package br.dafio.cooperativa.domain;

import javax.persistence.*;

@Entity
@Table(name = "cooperado")
public class Cooperado extends CooperativaDomain{

	@Id
	@Column(name = "id_cooperado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
 
