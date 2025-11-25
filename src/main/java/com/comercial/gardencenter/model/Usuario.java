package com.comercial.gardencenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	
	@Column(length=50)
	@NotBlank(message="O atributo nome do usuário é obrigatório.")
	private String nomeusuario;
	
	@Column(length=11)
	@NotBlank(message="O cpf do usuário é obrigatório.")
	@Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.") //Pattern valida Strings, verifica se valor possui formato específico.
	private String cpf;
	
	@Column(length=50)
	private String funcao;
	
	@Column(length = 100)
	@Email(message = "Informe um email válido.")
	@NotBlank(message = "O email é obrigatório.")
	private String email;
	
	@NotBlank(message = "O Atributo senha é Obrigatório.")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
	private String senha;
	
	//senha = passwordEncoder.encode(senha); --- falta adicionar security!
	
	//Falta relacionamento
	
	
	// Getters e Setters

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	

}
