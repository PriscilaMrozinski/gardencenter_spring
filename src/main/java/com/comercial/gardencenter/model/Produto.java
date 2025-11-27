package com.comercial.gardencenter.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproduto;

	@Column(length = 50)
	@NotBlank(message = "O atributo nome é obrigatório.")
	private String nomeproduto;

	@Column(length = 1000)
	@NotBlank(message = "O atributo descrição é obrigatório.")
	@Size(min = 5, max = 1000, message = "O atributo descrição deve conter no mínimo 5 e no máximo 1000 caracteres.")
	private String descricao;

	@NotNull(message = "O preço é obrigatório.")
	@Positive(message = "O preço deve ser positvo")
	private BigDecimal preco;

	@NotNull(message = "A quantidade é obrigatória.")
	@PositiveOrZero(message = "A quantidade não pode ser negativa.")
	private Long quantidade;

	private String foto;

	// Incluir relacionamento tb_categoria:
	@ManyToOne
	@JsonIgnoreProperties("produtos") // Evita loop infinito: produto contem um categoria. Categoria uma lista de produtos. Que contem uma categoria. Que contem produtos... e assim gera um loop. Impede que seja serializada , quebra ciclo.
	private Categoria categoria;

	// Incluir relacionamento tb_fornecedor:
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Fornecedor fornecedor;

	// Getters e Setters

	public Long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public String getNomeproduto() {
		return nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
