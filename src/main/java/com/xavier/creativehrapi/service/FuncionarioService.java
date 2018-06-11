package com.xavier.creativehrapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.xavier.creativehrapi.model.Funcionario;
import com.xavier.creativehrapi.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario actualizar(Long codigo, Funcionario funcionario) {
		Funcionario funcionarioSalvo = funcionarioRepository.getOne(codigo);
		if(funcionarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(funcionario, funcionarioSalvo, "codigo");
		return funcionarioRepository.save(funcionarioSalvo);
	}

}
