package br.desafio.cooperativa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pauta")
public class Pauta extends CooperativaDomain{

	@Id
	@Column(name = "id_pauta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataAlteracao;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
 
