package com.adft.vacinae.api.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.adft.vacinae.api.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {

	public E criar(E entity);
	
	public Optional<E> ler(UUID id);
	
	public List<E> lerTudo();
	
	public void atualizar(UUID id, E e);
	
	public void deletar(UUID id);
	
}
