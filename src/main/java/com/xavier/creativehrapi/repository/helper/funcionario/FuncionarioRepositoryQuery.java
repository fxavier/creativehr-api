package com.xavier.creativehrapi.repository.helper.funcionario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.creativehrapi.model.Funcionario;
import com.xavier.creativehrapi.repository.filter.FuncionarioFilter;

public interface FuncionarioRepositoryQuery {
	
	public Page<Funcionario> filtrar(FuncionarioFilter funcionarioFilter, Pageable pageable);

}
