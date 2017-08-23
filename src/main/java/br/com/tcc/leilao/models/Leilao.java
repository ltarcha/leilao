package br.com.tcc.leilao.models;

import java.util.Calendar;

public class Leilao {
	
	private Long id;
	private Calendar data;
	private Float valorInicial;
	private Float valorLance;
	private Long idUsuarioVencedor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Float getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(Float valorInicial) {
		this.valorInicial = valorInicial;
	}
	public Float getValorLance() {
		return valorLance;
	}
	public void setValorLance(Float valorLance) {
		this.valorLance = valorLance;
	}
	public Long getIdUsuarioVencedor() {
		return idUsuarioVencedor;
	}
	public void setIdUsuarioVencedor(Long idUsuarioVencedor) {
		this.idUsuarioVencedor = idUsuarioVencedor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leilao other = (Leilao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
