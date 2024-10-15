package com.lingerie_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingerie_store.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	// Posso adicionar consultas personalizadas, caso seja necessário 
}
