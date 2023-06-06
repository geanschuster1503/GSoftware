package br.com.gsoftware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String senha;
	
	
	private String confirmaSenha;
	
	private String email;
	
	public Usuario include() {
		
		Usuario usuario = new Usuario();
		usuario.setNome(this.nome);
		usuario.setSenha(this.senha);
		usuario.setConfirmaSenha(this.confirmaSenha);
		usuario.setEmail(this.email);
		return usuario;
	}
	
	
	public Usuario() {
		
	}


	
	public Usuario(Long id, String nome, String senha, String confirmaSenha, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.confirmaSenha = confirmaSenha;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getConfirmaSenha() {
		return confirmaSenha;
	}


	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	
	
	
}
