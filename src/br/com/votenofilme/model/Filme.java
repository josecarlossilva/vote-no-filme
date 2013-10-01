package br.com.votenofilme.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="FILME")
public class Filme implements Serializable {
	
	private static final long serialVersionUID = -4981840472798992278L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "NOME", nullable = false)
    private String nome;
	
	@Column(name = "QUANTIDADE_VOTOS", nullable = false)
    private Long quantidadeDeVotos;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getQuantidadeDeVotos() {
		return quantidadeDeVotos;
	}
	public void setQuantidadeDeVotos(Long quantidadeDeVotos) {
		this.quantidadeDeVotos = quantidadeDeVotos;
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
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}