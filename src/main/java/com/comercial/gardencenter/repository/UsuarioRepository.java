package com.comercial.gardencenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercial.gardencenter.model.Produto;
import com.comercial.gardencenter.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByNomeusuario(String nomeusuario); //busca um único usuário, bom para login
	//public List<Usuario> findAllByNomeusuarioContainingIgnoreCase(String nomeusuario); //retorna rodas as string com o "x" informado


}
