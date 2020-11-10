package com.example.lojajogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.lojajogos.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

	@Query(value = "select * from jogadores", nativeQuery=true)
	List<Jogador> findAllJogadores();
}
