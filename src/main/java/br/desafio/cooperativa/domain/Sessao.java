package br.desafio.cooperativa.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sessao")
public class Sessao extends CooperativaDomain{

	@Id
	@Column(name = "id_sessao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime inicioSessao;
	private LocalDateTime fimSessao;
	@OneToMany
	private List<Cooperado> cooperados;
	@OneToOne
	private Pauta pauta;

	@Override
	public Long getId() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInicioSessao() {
		return inicioSessao;
	}

	public void setInicioSessao(LocalDateTime inicioSessao) {
		this.inicioSessao = inicioSessao;
	}

	public LocalDateTime getFimSessao() {
		return fimSessao;
	}

	public void setFimSessao(LocalDateTime fimSessao) {
		this.fimSessao = fimSessao;
	}

	public List<Cooperado> getCooperados() {
		return cooperados;
	}

	public void setCooperados(List<Cooperado> cooperados) {
		this.cooperados = cooperados;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
}
 
