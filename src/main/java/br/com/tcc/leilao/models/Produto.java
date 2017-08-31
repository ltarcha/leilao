package br.com.tcc.leilao.models;

import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto {

	@Id
	private Long id;
	private Float valorInicio;
	private Float valorAtual;
	private String titulo;
	private String descricao;
	private Calendar dataCadastro;
	private Long idProprietario;
	
	public Produto() {
	}
	
	public Produto(Long id, Float valorInicio, Float valorAtual, String titulo, String descricao, Calendar dataCadastro,
			Long idProprietario) {
		super();
		this.id = id;
		this.valorInicio = valorInicio;
		this.valorAtual = valorAtual;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.idProprietario = idProprietario;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getValorInicio() {
		return valorInicio;
	}
	public void setValorInicio(Float valorInicio) {
		this.valorInicio = valorInicio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Long idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Float getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(Float valorAtual) {
		this.valorAtual = valorAtual;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", valorInicio=" + valorInicio + ", valorAtual=" + valorAtual + ", titulo="
				+ titulo + ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", idProprietario="
				+ idProprietario + "]";
	}

}
