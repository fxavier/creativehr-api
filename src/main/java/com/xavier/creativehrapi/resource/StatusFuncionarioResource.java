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
import com.xavier.creativehrapi.model.StatusFuncionario;
import com.xavier.creativehrapi.repository.StatusFuncionarioRepository;

@RestController
@RequestMapping("/status_funcionarios")
public class StatusFuncionarioResource {
	
	@Autowired
	private StatusFuncionarioRepository statusFuncionarioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<StatusFuncionario> pesquisar(){
		return statusFuncionarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<StatusFuncionario> criar(@Valid @RequestBody StatusFuncionario statusFuncionario
			, HttpServletResponse response){
		StatusFuncionario statusSavlo = statusFuncionarioRepository.save(statusFuncionario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, statusSavlo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(statusSavlo);
	}

}
