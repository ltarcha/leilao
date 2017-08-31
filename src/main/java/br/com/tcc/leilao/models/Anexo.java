package br.com.tcc.leilao.models;

public class Anexo {

	private Long id;
	private Long idProduto;
	private String path;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "Anexo [id=" + id + ", idProduto=" + idProduto + ", path=" + path + "]";
	}
	
}
