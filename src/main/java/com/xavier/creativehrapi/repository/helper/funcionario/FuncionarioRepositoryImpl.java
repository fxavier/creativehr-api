package com.xavier.creativehrapi.repository.helper.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.xavier.creativehrapi.model.Funcionario;
import com.xavier.creativehrapi.model.Funcionario_;
import com.xavier.creativehrapi.repository.filter.FuncionarioFilter;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Funcionario> filtrar(FuncionarioFilter funcionarioFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
		Root<Funcionario> root = criteria.from(Funcionario.class);
		
		Predicate[] predicates = criarRestricoes(funcionarioFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Funcionario> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(funcionarioFilter));
	}

	private Long total(FuncionarioFilter funcionarioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Funcionario> root = criteria.from(Funcionario.class);
		
		Predicate[] predicates = criarRestricoes(funcionarioFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Funcionario> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstRecordOfPage = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstRecordOfPage);
		query.setMaxResults(totalRecordsPerPage);
		
	}

	private Predicate[] criarRestricoes(FuncionarioFilter funcionarioFilter, CriteriaBuilder builder,
			Root<Funcionario> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(funcionarioFilter.getNumeroInterno() != null) {
			predicates.add(builder.equal(root.get(Funcionario_.numeroInterno), 
					funcionarioFilter.getNumeroInterno()));
		}
		
		if(!StringUtils.isEmpty(funcionarioFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Funcionario_.nome)), 
					"%" + funcionarioFilter.getNome().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(funcionarioFilter.getSobrenome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Funcionario_.sobrenome)), 
					"%" + funcionarioFilter.getSobrenome().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(funcionarioFilter.getApelido())) {
			predicates.add(builder.like(
					builder.lower(root.get(Funcionario_.apelido)),
					"%" + funcionarioFilter.getApelido().toLowerCase() + "%"));
		}
		
		if(funcionarioFilter.getDataInicioContrato() != null) {
			predicates.add(builder.equal(root.get(Funcionario_.dataInicioContrato),
					funcionarioFilter.getDataInicioContrato()));
		}
		
		if(funcionarioFilter.getDataFimContrato() != null) {
			predicates.add(builder.equal(root.get(Funcionario_.dataFimContrato),
					funcionarioFilter.getDataFimContrato()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	

}
