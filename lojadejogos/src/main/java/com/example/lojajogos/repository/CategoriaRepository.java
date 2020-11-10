package com.example.lojajogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.lojajogos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query(value = "select * from categoria", nativeQuery=true)
	List<Categoria> findAllCategoria();

	
}
