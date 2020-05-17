package com.capgemini.casamento.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.capgemini.casamento.model.Convidado;

public interface ConvidadoRepository extends Repository<Convidado, Long> {
	
	Convidado save(Convidado convidado);
	
	List<Convidado> findAll();

}
