package pe.com.backend.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.backend.model.Usuario;
import pe.com.backend.repository.UsuarioRepository;
import pe.com.backend.repository.mapper.UsuarioMapper;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> list(Usuario usuario) throws Exception {
		List<Usuario> lista = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT id,nombre,apellido,email ");
		sql_find_user.append("FROM usuario ");
		lista = (List<Usuario>) jdbcTemplate.query(sql_find_user.toString(), new UsuarioMapper());
		return lista;
	}

	@Override
	public void insert(Usuario usuario) throws Exception {
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("INSERT INTO usuario ");
		sql_insert_user.append("(nombre,apellido,email) ");
		sql_insert_user.append("VALUES (?,?,?) ");
		
		Object[] params = new Object[] {
				usuario.getNombre(), usuario.getApellido(),	usuario.getEmail()
				};
		jdbcTemplate.update(sql_insert_user.toString(),params);
	}

}
