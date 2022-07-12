package pe.com.backend.repository;

import java.util.List;

import pe.com.backend.model.Usuario;

public interface UsuarioRepository {
	List<Usuario> list(Usuario usuario) throws Exception;
	void insert(Usuario usuario) throws Exception;
}
