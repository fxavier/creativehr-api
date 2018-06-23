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
import com.xavier.creativehrapi.model.PostoTrabalho;
import com.xavier.creativehrapi.repository.PostoTrabalhoRepository;

@RestController
@RequestMapping("/postos")
public class PostoTrabalhoResource {
	
	@Autowired
	private PostoTrabalhoRepository postoTrabalhoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<PostoTrabalho> pesquisar(){
		return postoTrabalhoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<PostoTrabalho> criar(@Valid @RequestBody PostoTrabalho postoTrabalho
			, HttpServletResponse response){
		PostoTrabalho postoSalvo = postoTrabalhoRepository.save(postoTrabalho);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, postoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(postoSalvo);
		
		
		
	}

}
