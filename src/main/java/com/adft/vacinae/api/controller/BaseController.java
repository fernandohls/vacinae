package com.adft.vacinae.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.adft.vacinae.api.dto.BaseDto;
import com.adft.vacinae.api.entity.BaseEntity;

public interface BaseController<D extends BaseDto, E extends BaseEntity> {

	// POST - PUBLICAR/CRIAR
	@PostMapping
	public void criar(@RequestBody D dto);

	// GET - OBTER/PEGAR/LER
	@GetMapping("/{id}")
	public E ler(@PathVariable UUID id);

	// GET - OBTER/PEGAR/LER
	@GetMapping
	public List<E> lerTudo();

	// PUT - ATUALIZAR
	@PutMapping("/{id}")
	public void atualizar(@PathVariable UUID id, @RequestBody D dto);

	// DELETE - DELETAR
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable UUID id);

}
