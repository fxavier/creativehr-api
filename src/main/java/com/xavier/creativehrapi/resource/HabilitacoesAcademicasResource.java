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
import com.xavier.creativehrapi.model.HabilitacoesAcademicas;
import com.xavier.creativehrapi.repository.HabilitacoesAcademicasRepository;

@RestController
@RequestMapping("/habilitacoes")
public class HabilitacoesAcademicasResource {
	
	@Autowired
	private HabilitacoesAcademicasRepository habilitacoesAcademicasRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<HabilitacoesAcademicas> pesquisar(){
		return habilitacoesAcademicasRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<HabilitacoesAcademicas> criar(@Valid @RequestBody HabilitacoesAcademicas haAcademicas
			, HttpServletResponse response){
		HabilitacoesAcademicas habAcademicasSalvas = habilitacoesAcademicasRepository.save(haAcademicas);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, habAcademicasSalvas.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(habAcademicasSalvas);
	}

}
