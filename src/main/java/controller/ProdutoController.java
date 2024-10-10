package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Produto;
import service.ProdutoService;

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
}
