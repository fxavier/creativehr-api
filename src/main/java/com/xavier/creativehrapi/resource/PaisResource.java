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
import com.xavier.creativehrapi.model.Pais;
import com.xavier.creativehrapi.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisResource {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Pais> pesquisar(){
		return paisRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pais> criar(@Valid @RequestBody Pais pais, HttpServletResponse response){
		Pais paisSalvo = paisRepository.save(pais);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, paisSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(paisSalvo);
	}

}
