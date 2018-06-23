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
import com.xavier.creativehrapi.model.Estabelecimento;
import com.xavier.creativehrapi.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoResource {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Estabelecimento> pesquisar(){
		return estabelecimentoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Estabelecimento> criar(@Valid @RequestBody Estabelecimento estabelecimento
			, HttpServletResponse response){
		Estabelecimento estabelecimentoSalvo = estabelecimentoRepository.save(estabelecimento);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, estabelecimentoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoSalvo);
	}

}
