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
import com.xavier.creativehrapi.model.IRPS;
import com.xavier.creativehrapi.model.IRPSRepository;

@RestController
@RequestMapping("/irps")
public class IRPSResource {
	
	@Autowired
	private IRPSRepository irpsRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<IRPS> pesquisar(){
		return irpsRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<IRPS> criar(@Valid @RequestBody IRPS irps, HttpServletResponse response){
		IRPS irpsSalvo = irpsRepository.save(irps);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, irpsSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(irpsSalvo);
	}

}
