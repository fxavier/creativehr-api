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
import com.xavier.creativehrapi.model.Subsidio;
import com.xavier.creativehrapi.repository.SubsidioRepository;

@RestController
@RequestMapping("/subsidios")
public class SubsidioResource {
	
	@Autowired
	private SubsidioRepository subsidioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Subsidio> pesquisar(){
		return subsidioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Subsidio> criar(@Valid @RequestBody Subsidio subsidio, HttpServletResponse response){
		Subsidio subsidioSalvo = subsidioRepository.save(subsidio);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, subsidioSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(subsidioSalvo);
	}

}
