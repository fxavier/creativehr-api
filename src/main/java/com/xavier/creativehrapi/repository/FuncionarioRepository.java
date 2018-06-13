package com.xavier.creativehrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativehrapi.model.Funcionario;
import com.xavier.creativehrapi.repository.helper.funcionario.FuncionarioRepositoryQuery;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, FuncionarioRepositoryQuery{


}
