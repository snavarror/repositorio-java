package pe.com.backend.service;

import java.util.List;

import pe.com.backend.model.Usuario;

public interface UsuarioService {
	List<Usuario> list(Usuario usuario) throws Exception;
	void insert(Usuario usuario) throws Exception;
}
