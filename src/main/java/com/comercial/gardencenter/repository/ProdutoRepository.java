package com.comercial.gardencenter.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.comercial.gardencenter.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByNomeprodutoContainingIgnoreCase(String nomeproduto);
	
	//Busca por preço:
	public List<Produto> findAllByPrecoGreaterThanOrderByPrecoDesc(BigDecimal preco); //preço maior que
	public List<Produto> findAllByPrecoLessThanEqualOrderByPrecoAsc(BigDecimal preco); //preço menor que
	public List<Produto> findAllByPrecoBetween(BigDecimal min, BigDecimal max); //preço entre x e y
}
