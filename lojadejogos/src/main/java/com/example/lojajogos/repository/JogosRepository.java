package com.example.lojajogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.lojajogos.model.Jogos;


public interface JogosRepository extends JpaRepository<Jogos, Long>{
	

	@Query(value = "select * from jogos", nativeQuery=true)
	List<Jogos> findAllJogos();


}
