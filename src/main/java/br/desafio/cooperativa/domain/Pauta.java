package br.desafio.cooperativa.domain;

import br.desafio.cooperativa.repositoy.PautaRepository;
import br.desafio.cooperativa.validacion.PautaException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "pauta")
public class Pauta extends CooperativaDomain{

	@Id
	@Column(name = "id_pauta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String descricao;

	@OneToOne
	@JoinColumn(name = "id_sessao")
	private Sessao sessao;

	@OneToMany
	@JoinColumn(name = "id_cooperado")
	private List<Cooperado> cooperados;

	@Column(name = "qt_votos_sim")
	private int quantidadeVotosSim;

	@Column(name = "qt_votos_nao")
	private int quantidadeVotosNao;

	@Column(name = "resultado_votacao")
	private Boolean resultadoVotacao;

	public Pauta() {
	}

	@Override
	public Long getId() {
		return id;
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

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public List<Cooperado> getCooperados() {
		return cooperados;
	}

	public int getQuantidadeVotosSim() {
		return quantidadeVotosSim;
	}

	public void somaVotosSim() {
		this.quantidadeVotosSim = this.quantidadeVotosSim + 1;
	}

	public int getQuantidadeVotosNao() {
		return quantidadeVotosNao;
	}

	public void somaVotoNao() {
		this.quantidadeVotosNao = this.quantidadeVotosNao + 1;
	}

	public Boolean getResultadoVotacao() {
		return resultadoVotacao;
	}

	public Boolean existeCooperados(Long idCooperado){
		return getCooperados().stream()
				.anyMatch(cooperado -> cooperado.getId().equals(idCooperado));
	}

	public static Pauta retornaPauta(Long idPauta, PautaRepository repository) throws PautaException {
		Optional<Pauta> optional = repository.findById(idPauta);
		if(!optional.isPresent()) throw new PautaException("Pauta não encontrada.");
		return optional.get();
	}

}
 
