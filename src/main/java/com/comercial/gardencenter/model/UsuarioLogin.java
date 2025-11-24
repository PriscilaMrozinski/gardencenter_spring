package com.comercial.gardencenter.model;

public class UsuarioLogin {
	
	//Dados de entrada:
	private String login; //no front-end email ou cpf
	private String senha;
	
	//Dados de saída (depois de logar, devolve os dados para autenticação):
	private Long idusuario;
	private String nomeusuario;
	private String token;
	
	
	//Getters e Setters
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	

}
