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
import com.xavier.creativehrapi.model.TipoSubsidio;
import com.xavier.creativehrapi.repository.TipoSubsidioRepository;

@RestController
@RequestMapping("/tipo_subsidios")
public class TipoSubsidioResource {
	
	@Autowired
	private TipoSubsidioRepository tipoSubsidioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<TipoSubsidio> pesquisar(){
		return tipoSubsidioRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<TipoSubsidio> criar(@Valid @RequestBody TipoSubsidio tipoSubsidio, HttpServletResponse response){
		TipoSubsidio tipoSubsidioSalvo = tipoSubsidioRepository.save(tipoSubsidio);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoSubsidioSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoSubsidioSalvo);
	}
}
