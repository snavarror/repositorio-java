package pe.com.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.backend.model.Usuario;
import pe.com.backend.repository.UsuarioRepository;
import pe.com.backend.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> list(Usuario usuario) throws Exception {
		List<Usuario> list = usuarioRepository.list(usuario);
		return list;
	}

	@Override
	public void insert(Usuario usuario) throws Exception {
		usuarioRepository.insert(usuario);
		
	}
	
	

}
