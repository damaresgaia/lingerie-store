package com.lingerie_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingerie_store.model.Produto;
import com.lingerie_store.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public String listarProdutos(Model model) {
		List<Produto> produtos = produtoService.listarProdutos();
		model.addAttribute("produtos", produtos);
		return "produtos/lista";
	}
	
	@GetMapping("/detalhes")
	public String detalhesProduto(@RequestParam Long id, Model model) {
		Produto produto = produtoService.buscarPorId(id);
		model.addAttribute("produto", produto);
		return "produtos/detalhes";
	}
	
	@GetMapping("/adicionar")
    public String mostrarFormularioAdicionarProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/adicionar"; // Nome da página Thymeleaf
    }

    @PostMapping("/adicionar")
    public String adicionarProduto(Produto produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/produtos"; // Redireciona após adicionar
    }
}
