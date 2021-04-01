package com.adft.vacinae.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.adft.vacinae.api.entity.BaseEntity;

public interface BaseRepository<E extends BaseEntity> {

	// CRUD = CREATE, READ, UPDATE, DELETE
	public E criar(E entity);
	
	public Optional<E> ler(UUID id);
	
	public List<E> lerTudo();
	
	public void atualizar(E entity);
	
	public void deletar(UUID id);
	
}
