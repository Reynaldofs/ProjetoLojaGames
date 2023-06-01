package com.loja_games.loja_games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.loja_games.loja_games.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

	List<Categoria> findAllByModeloContainingIgnoreCase(@Param("modelo") String modelo);
}
