package br.com.tcc.leilao.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto {

	@Id
	private Long id;
	private Float valorInicio;
	private String descricao;
	private String urlImg;
	private Long idLeilao;
	private Long idProprietario;
	
	public Produto() {
	}
	
	public Produto(Long id, Float valorInicio, String descricao, String urlImg, Long idLeilao, Long idProprietario) {
		super();
		this.id = id;
		this.valorInicio = valorInicio;
		this.descricao = descricao;
		this.urlImg = urlImg;
		this.idLeilao = idLeilao;
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
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public Long getIdLeilao() {
		return idLeilao;
	}
	public void setIdLeilao(Long idLeilao) {
		this.idLeilao = idLeilao;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", valorInicio=" + valorInicio + ", descricao=" + descricao + ", urlImg=" + urlImg
				+ ", idLeilao=" + idLeilao + ", idProprietario=" + idProprietario + "]";
	}
	
}
