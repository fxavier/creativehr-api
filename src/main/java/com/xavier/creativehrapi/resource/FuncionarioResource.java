package com.xavier.creativehrapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativehrapi.event.RecursoCriadoEvent;
import com.xavier.creativehrapi.model.Funcionario;
import com.xavier.creativehrapi.repository.FuncionarioRepository;
import com.xavier.creativehrapi.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long codigo){
		Funcionario foundFuncionario = funcionarioRepository.getOne(codigo);
		return foundFuncionario != null ? ResponseEntity.ok(foundFuncionario) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response){
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, funcionarioSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
		
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Funcionario> editar(@PathVariable Long codigo, @Valid @RequestBody Funcionario funcionario){
		Funcionario funcionarioSalvo = funcionarioService.actualizar(codigo, funcionario);
		return ResponseEntity.ok(funcionarioSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		funcionarioRepository.deleteById(codigo);
	}

}
