package br.com.gsoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gsoftware.model.Usuario;
import br.com.gsoftware.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario/novo")
	public String usuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "WEB/usuario/novo";
	}
	
	@PostMapping("/usuario/salvar")
	public String salvar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		
		return "redirect:/index";
	}
	
	
}
