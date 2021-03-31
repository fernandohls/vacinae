package com.adft.vacinae.api.controller;

import static com.adft.vacinae.api.controller.ApiConstants.ENDPOINT_FABRICANTES;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adft.vacinae.api.dto.FabricanteDto;
import com.adft.vacinae.api.entity.Fabricante;

@RestController
@RequestMapping(ENDPOINT_FABRICANTES)
public class FabricanteController implements BaseController<FabricanteDto, Fabricante> {

	@Override
	public void criar(FabricanteDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Fabricante ler(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fabricante> lerTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(UUID id, FabricanteDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(UUID id) {
		// TODO Auto-generated method stub

	}

}
