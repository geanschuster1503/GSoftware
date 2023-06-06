package br.com.gsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gsoftware.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
