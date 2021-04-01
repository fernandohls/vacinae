package com.adft.vacinae.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.adft.vacinae.api.entity.Fabricante;
import com.adft.vacinae.api.repository.rowmapper.FabricanteRowMapper;

@Repository
public class FabricanteRepository implements BaseRepository<Fabricante> {

	private NamedParameterJdbcTemplate template;

	public FabricanteRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Fabricante criar(Fabricante fabricante) {

		String sql = "INSERT INTO fabricante (nome) VALUES (:nome) RETURNING *";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", fabricante.getNome());

		return template.queryForObject(sql, paramSource, new FabricanteRowMapper());
	}

	@Override
	public Optional<Fabricante> ler(UUID id) {

		String sql = "SELECT * FROM fabricante WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);

		try {
			return Optional.ofNullable(template.queryForObject(sql, paramSource, new FabricanteRowMapper()));
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Fabricante> lerTudo() {

		String sql = "SELECT * FROM fabricante";

		return template.query(sql, new FabricanteRowMapper());
	}

	@Override
	public void atualizar(Fabricante fabricante) {

		String sql = "UPDATE fabricante SET nome = :nome WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("nome", fabricante.getNome())
				.addValue("id", fabricante.getId());

		template.update(sql, paramSource);
	}

	@Override
	public void deletar(UUID id) {

		String sql = "DELETE FROM fabricante WHERE id = :id";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("id", id);
		
		template.update(sql, paramSource);
	}

}
