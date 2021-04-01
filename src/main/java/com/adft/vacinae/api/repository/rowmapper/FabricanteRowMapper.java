package com.adft.vacinae.api.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;

import com.adft.vacinae.api.entity.Fabricante;

public class FabricanteRowMapper implements RowMapper<Fabricante> {

	@Override
	public Fabricante mapRow(ResultSet rs, int rowNum) throws SQLException {

		Fabricante fabricante = new Fabricante();
		fabricante.setId(UUID.fromString(rs.getString("id")));
		fabricante.setNome(rs.getString("nome"));

		return fabricante;
	}

}
