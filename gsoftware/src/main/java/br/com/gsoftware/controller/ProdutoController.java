package br.com.gsoftware.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gsoftware.model.Produto;
import br.com.gsoftware.repository.ProdutoRepository;



@Controller
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/detalhes")
	public String detalhes(Model model) {
		
		
		
		return "WEB/produto/detalhes";
	}
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Produto> produto = this.produtoRepository.findAll();
		model.addAttribute("produto", produto);
		return "WEB/produto/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		return "WEB/produto/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto) {
		produto = produto.toProduto();
		this.produtoRepository.save(produto);
		return "redirect:/produto/lista";
	}
	
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Optional<Produto> optional = this.produtoRepository.findById(id);
    	if (optional.isPresent()) {
			Produto produto = optional.get();
			model.addAttribute(produto);
    		return "WEB/produto/detalhes";
		}else {
			return"redirect:/produto/lista";	
		}
    }
	
	
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id,Model model) {
	
		 Optional<Produto> optional = this.produtoRepository.findById(id);
		 
		 if (optional.isPresent()) {
			 Produto produto = optional.get();
			 produto.fromProduto(produto);
			model.addAttribute(produto);
			
	    		return "WEB/produto/editar";
			}else {
				return"redirect:/produto/lista";	
			}
	}
	
	
	
	@PostMapping("/{id}/atualizar")
	public String atualizar(@PathVariable Long id,Produto produto) {
		Optional<Produto> optional = this.produtoRepository.findById(id);
		if(optional.isPresent()) {
			
			produto.toProduto(optional.get());
			this.produtoRepository.save(produto);
		
		}
		
		return"redirect:/produto/lista";
		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		
		this.produtoRepository.deleteById(id);
		 return"redirect:/produto/lista";
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
