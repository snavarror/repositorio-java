package pe.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.backend.model.Response;
import pe.com.backend.model.Usuario;
import pe.com.backend.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/services/rest/listadoUsuario", method = RequestMethod.POST, produces = {
			"application/json" })
	
	@ResponseBody
	public List<Usuario> listUsuario() throws Exception {

		List<Usuario> response = usuarioService.list(new Usuario());

		return response;
	}
	
	@RequestMapping(value = "/services/rest/InsertarUsuario", method = RequestMethod.POST, produces = {
	"application/json" })
	@ResponseBody
	public Response insert(@RequestBody Usuario usuario) throws Exception {
		usuarioService.insert(usuario);
		Response res = new Response();
		res.setCodigo("Ok");
		return res;
	}
}
