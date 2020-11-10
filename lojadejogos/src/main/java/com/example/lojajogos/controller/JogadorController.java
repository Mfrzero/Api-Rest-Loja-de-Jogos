package com.example.lojajogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lojajogos.model.Jogador;
import com.example.lojajogos.repository.JogadorRepository;


@RestController
@RequestMapping("/jogador")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JogadorController {
	
	@Autowired
	private JogadorRepository repository;
	
	@GetMapping("/buscarTodosJogadores")
	public ResponseEntity<List<Jogador>> findAllJogadores(){
		return ResponseEntity.ok(repository.findAllJogadores());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogador> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
	
	@PostMapping
	public ResponseEntity<Jogador> post(@RequestBody Jogador jogador){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogador));
	}
	
	@PutMapping
	public ResponseEntity<Jogador> put(@RequestBody Jogador jogador){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jogador));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
