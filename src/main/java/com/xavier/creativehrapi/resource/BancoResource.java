package com.xavier.creativehrapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativehrapi.event.RecursoCriadoEvent;
import com.xavier.creativehrapi.model.Banco;
import com.xavier.creativehrapi.repository.BancoRepository;

@RestController
@RequestMapping("/bancos")
public class BancoResource {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Banco> listar(){
		return bancoRepository.findAll();
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Banco> findById(@PathVariable Long codigo){
		Banco foundBanco = bancoRepository.getOne(codigo);
		return foundBanco != null ? ResponseEntity.ok(foundBanco) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Banco> criar(@Valid @RequestBody Banco banco, HttpServletResponse response){
		Banco bancoSalvo = bancoRepository.save(banco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, bancoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(bancoSalvo);
		
	}

}
