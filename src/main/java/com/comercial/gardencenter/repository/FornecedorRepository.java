package com.comercial.gardencenter.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.comercial.gardencenter.model.Fornecedor;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	public List<Fornecedor> findAllByNomefornecedorContainingIgnoreCase(String nomefornecedor);
	public List<Fornecedor> findAllByCnpjContaining(String cnpj); //permite também procurar por parte do cnpj
	//public Fornecedor findByCnpj(String cnpj); //buscaria pelo cnpj exato

	

}
