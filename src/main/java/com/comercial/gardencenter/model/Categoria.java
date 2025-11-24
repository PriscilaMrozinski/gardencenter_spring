package com.comercial.gardencenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcategoria;
	
	@Column(length=50)
	@NotBlank(message="O nome é obrigatório.")
	private String nomecategoria;
	
	//Getters e Setters

	public Long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}
	
	
	

}
