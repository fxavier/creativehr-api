package com.xavier.creativehrapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativehrapi.event.RecursoCriadoEvent;
import com.xavier.creativehrapi.model.Funcao;
import com.xavier.creativehrapi.repository.FuncaoRepository;

@RestController
@RequestMapping("/funcaos")
public class FuncaoResource {

	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Funcao> pesquisar(){
		return funcaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Funcao> criar(@Valid @RequestBody Funcao funcao, HttpServletResponse response){
		Funcao funcaoSalva = funcaoRepository.save(funcao);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, funcaoSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(funcaoSalva);
	}
}
