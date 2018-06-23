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
import com.xavier.creativehrapi.model.Departamento;
import com.xavier.creativehrapi.repository.DepartamentoRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoResource {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Departamento> pesquisar(){
		return departamentoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Departamento> criar(@Valid @RequestBody Departamento departamento, HttpServletResponse response){
		Departamento departamentoSalvo = departamentoRepository.save(departamento);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, departamentoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoSalvo);
	}

}
