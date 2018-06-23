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
import com.xavier.creativehrapi.model.Profissao;
import com.xavier.creativehrapi.repository.ProfissaoRepository;

@RestController
@RequestMapping("/profissaos")
public class ProfissaoResource {
	
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Profissao> pesquisar(){
		return profissaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Profissao> criar(@Valid @RequestBody Profissao profissao, HttpServletResponse response){
		Profissao profissaoSalva = profissaoRepository.save(profissao);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, profissaoSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(profissaoSalva);
	}

}
