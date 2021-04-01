package com.adft.vacinae.api.business;

import org.springframework.stereotype.Component;

import com.adft.vacinae.api.dto.FabricanteDto;
import com.adft.vacinae.api.entity.Fabricante;

@Component
public class FabricanteBuilder {

	public Fabricante construirFabricante(FabricanteDto dto) {
		Fabricante fabricante = new Fabricante();
		fabricante.setNome(dto.getNome());
		return fabricante;
	}

	public Fabricante construirFabricanteAtualizado(FabricanteDto dto) {
		Fabricante fabricante = new Fabricante();
		fabricante.setNome(dto.getNome());
		return fabricante;
	}

}
