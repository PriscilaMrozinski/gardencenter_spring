package com.comercial.gardencenter.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.comercial.gardencenter.model.Produto;
import com.comercial.gardencenter.repository.CategoriaRepository;
import com.comercial.gardencenter.repository.FornecedorRepository;
import com.comercial.gardencenter.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	// Criar injeção de dependência
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	// Buscar pelo Id
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	// Buscar pelo nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getAllByNomeProduto(@PathVariable("nome") String nomeproduto) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeprodutoContainingIgnoreCase(nomeproduto));
	}

	// Listar todas
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	// Criar produto:
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
		if (!categoriaRepository.existsById(produto.getCategoria().getIdcategoria())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A categoria não existe!");
		}
		if (!fornecedorRepository.existsById(produto.getFornecedor().getIdfornecedor())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O fornecedor não existe!");
		}
		produto.setIdproduto(null); // garante que é novo
		Produto salvo = produtoRepository.save(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}

	// Atualizar:
	@PutMapping("/{id}")
	public ResponseEntity<Produto> put(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		if (!categoriaRepository.existsById(produto.getCategoria().getIdcategoria())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A categoria não existe!");
		}
		if (!fornecedorRepository.existsById(produto.getFornecedor().getIdfornecedor())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O fornecedor não existe!");
		}
		produto.setIdproduto(id);
		Produto atualizado = produtoRepository.save(produto);
		return ResponseEntity.ok(atualizado);
	}

	// Apagar:
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		produtoRepository.deleteById(id);
	}

	// Query Methods: filtra maior que x valor, e ordena em decrescente
	@GetMapping("/acima/{preco}")
	public ResponseEntity<List<Produto>> getProdutosPrecoAcimaDe(@PathVariable BigDecimal preco) {
		return ResponseEntity.ok(produtoRepository.findAllByPrecoGreaterThanOrderByPrecoDesc(preco));
	}

	// Query Methods: filtra menor que x valor, e ordena em crescente
	@GetMapping("/menor/{preco}")
	public ResponseEntity<List<Produto>> getProdutosPrecoAbaixoDe(@PathVariable BigDecimal preco) {
		return ResponseEntity.ok(produtoRepository.findAllByPrecoLessThanEqualOrderByPrecoAsc(preco));
	}

	// Query Methods: filtra valores entre x e y
	@GetMapping("/entre/{min}/{max}")
	public ResponseEntity<List<Produto>> getProdutosPrecosEntre(@PathVariable BigDecimal min,
			@PathVariable BigDecimal max) {
		return ResponseEntity.ok(produtoRepository.findAllByPrecoBetween(min, max));
	}

}
