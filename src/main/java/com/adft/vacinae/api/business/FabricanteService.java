package com.adft.vacinae.api.business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.adft.vacinae.api.entity.Fabricante;
import com.adft.vacinae.api.repository.FabricanteRepository;

@Service
public class FabricanteService implements BaseService<Fabricante> {

	private FabricanteRepository repository;

	public FabricanteService(FabricanteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Fabricante criar(Fabricante fabricante) {
		return repository.criar(fabricante);
	}

	@Override
	public Optional<Fabricante> ler(UUID id) {
		return repository.ler(id);
	}

	@Override
	public List<Fabricante> lerTudo() {
		return repository.lerTudo();
	}

	@Override
	public void atualizar(UUID id, Fabricante fabricante) {
		fabricante.setId(id);
		repository.atualizar(fabricante);
	}

	@Override
	public void deletar(UUID id) {
		repository.deletar(id);
	}

}
