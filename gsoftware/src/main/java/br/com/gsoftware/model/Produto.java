package br.com.gsoftware.model;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long id;
	@Column(nullable = false)
	private String nome;
	
	private Integer quantidade;
	
	
	private BigDecimal preco;
	
	private LocalDateTime dataEntrada;
	
	private String descricao;
	
	public Produto(String nome,Integer quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
		
	}
	
	public Produto toProduto() {
		
		Produto produto = new Produto();
		produto.setNome(this.nome);
		produto.setQuantidade(this.quantidade);
		produto.setPreco(this.preco);
		produto.setDataEntrada(this.dataEntrada);
		produto.setDescricao(this.descricao);
		
		return produto;
	}
	
	public Produto toProduto(Produto produto) {
		
		produto.setNome(this.nome);
		produto.setQuantidade(this.quantidade);
		produto.setPreco(this.preco);
		produto.setDataEntrada(this.dataEntrada);
		produto.setDescricao(this.descricao);
		
		return produto;
	}
	
	public void fromProduto(Produto produto) {
		this.nome = getNome();
		this.quantidade = getQuantidade();
		this.preco = getPreco();
		this.dataEntrada = getDataEntrada();
		this.descricao = getDescricao();
		
		
	}
	
	public Produto() {
		
	}

	public Produto(String nome, Long id, Integer quantidade, BigDecimal preco, LocalDateTime dataEntrada,
			String descricao) {
		super();
		this.nome = nome;
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
		this.dataEntrada = dataEntrada;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	
	
	
	
	
}
