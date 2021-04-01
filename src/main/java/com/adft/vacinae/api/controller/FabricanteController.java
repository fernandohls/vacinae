package com.adft.vacinae.api.controller;

import static com.adft.vacinae.api.controller.ApiConstants.ENDPOINT_FABRICANTES;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adft.vacinae.api.business.FabricanteBuilder;
import com.adft.vacinae.api.business.FabricanteService;
import com.adft.vacinae.api.dto.FabricanteDto;
import com.adft.vacinae.api.entity.Fabricante;

@RestController
@RequestMapping(ENDPOINT_FABRICANTES)
public class FabricanteController implements BaseController<FabricanteDto, Fabricante> {

	private FabricanteService service;
	private FabricanteBuilder builder;

	public FabricanteController(FabricanteService service, FabricanteBuilder builder) {
		this.service = service;
		this.builder = builder;
	}

	@Override
	public ResponseEntity<Fabricante> criar(FabricanteDto fabricanteDto) {
		Fabricante fabricante = service.criar(builder.construirFabricante(fabricanteDto));
		return new ResponseEntity<Fabricante>(fabricante, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Fabricante> ler(UUID id) {
		Optional<Fabricante> fabricante = service.ler(id);
		if (fabricante.isPresent()) {
			return new ResponseEntity<Fabricante>(fabricante.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Fabricante>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Fabricante> lerTudo() {
		return service.lerTudo();
	}

	@Override
	public ResponseEntity<Void> atualizar(UUID id, FabricanteDto dto) {
		Optional<Fabricante> fabricanteStored = service.ler(id);
		if (fabricanteStored.isPresent()) {
			Fabricante fabricante = builder.construirFabricanteAtualizado(dto);
			service.atualizar(id, fabricante);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Void> deletar(UUID id) {
		Optional<Fabricante> fabricanteStored = service.ler(id);
		if (fabricanteStored.isPresent()) {
			service.deletar(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
