package br.desafio.cooperativa.domain;

import br.desafio.cooperativa.repositoy.SessaoRepository;
import br.desafio.cooperativa.validacion.SessaoException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "sessao")
public class Sessao{

	@Id
	@Column(name = "id_sessao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tempo_sessao")
	private Long tempoSessao;

	@Column(name = "dt_inicio")
	private LocalDateTime inicioSessao;

	@Column(name = "dt_fim")
	private LocalDateTime fimSessao;

	@OneToOne
	@JoinColumn(name = "id_pauta")
	private Pauta pauta;

	public Sessao() {
	}

	public Long getId() {
		return id;
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

	public Long getTempoSessao() {
		return tempoSessao;
	}

	public void setTempoSessao(Long tempoSessao) {
		this.tempoSessao = tempoSessao;
	}

	public Boolean validar(){
		return fimSessao.isBefore(LocalDateTime.now());
	}

	public static Sessao retornaSessao(Long idSessao, SessaoRepository repository) throws SessaoException {
		Optional<Sessao> optional = repository.findById(idSessao);
		if(!optional.isPresent()) throw new SessaoException("Sessão não encontrada.");
		return optional.get();
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
	
	public void vincular(Pauta pauta){
		this.pauta = pauta;
		pauta.setSessao(this);
	}
}
 
