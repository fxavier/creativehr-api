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
import com.xavier.creativehrapi.model.TipoContrato;
import com.xavier.creativehrapi.repository.TipoContratoRepository;

@RestController
@RequestMapping("/tipo_contratos")
public class TipoContratoResource {
	
	@Autowired
	private TipoContratoRepository tipoContratoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<TipoContrato> pesquisar(){
		return tipoContratoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<TipoContrato> criar(@Valid @RequestBody TipoContrato tipoContrato, HttpServletResponse response){
		TipoContrato tipoContratoSalvo = tipoContratoRepository.save(tipoContrato);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoContratoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoContratoSalvo);
	}
}
