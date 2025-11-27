package com.comercial.gardencenter.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="tb_fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfornecedor;
	
	@Column(length=50)
	@NotBlank(message="O atributo nome do fornecedor é obrigatório.")
	private String nomefornecedor;
	
	@Column(length=14)
	@NotBlank(message="O cnpj do fornecedor é obrigatório.")
	@Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter exatamente 14 dígitos numéricos.") //Pattern valida Strings, verifica se valor possui formato específico.
	private String cnpj;
	
	@Column(length = 100)
	private String responsavel;
	
	@Column(length = 100)
	@Email(message = "Informe um email válido.")
	private String email;
	
	@Pattern(regexp = "\\d{10,11}", message = "O telefone deve ter 10 ou 11 dígitos numéricos.") //Aceita números de 10 e 11 dígitos, fone fixo ou celular.
	private String telefone;

    // Relacionamento tb_produto
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("fornecedor")
    private List<Produto> produtos;
	
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("fornecedor")
    private List<Usuario> usuarios;
	
	//Getters e Setters

	public Long getIdfornecedor() {
		return idfornecedor;
	}

	public void setIdfornecedor(Long idfornecedor) {
		this.idfornecedor = idfornecedor;
	}

	public String getNomefornecedor() {
		return nomefornecedor;
	}

	public void setNomefornecedor(String nomefornecedor) {
		this.nomefornecedor = nomefornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
