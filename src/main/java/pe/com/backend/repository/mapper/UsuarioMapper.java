package pe.com.backend.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.backend.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario bean = new Usuario();
		bean.setNombre(rs.getString(2));
		bean.setApellido(rs.getString(3));
		bean.setEmail(rs.getString(4));

		return bean;
	}

}
