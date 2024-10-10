package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Produto;
import repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();		
	}
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}

}
