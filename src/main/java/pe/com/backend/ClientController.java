package pe.com.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	
	@RequestMapping(value ="/services/rest/listadoclientes", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public List<Client> listClients(@RequestBody Autenticacion request) {
		
		List<Client> response = new ArrayList<Client>();
		
		if(request.getToken().equals("41818310")) {
		
		Client c1 = new Client();
		c1.setEmail("willy@gmail.com");
		c1.setNombre("Willy");		
		response.add(c1);
		
		Client c2 = new Client("vivi@gmail.com","Marco");
		response.add(c2);
		
		response.add(new Client("chino@gmail.com","WWilmer"));
		}
		
		return response;
	}
	
	
	

	@RequestMapping(value ="/services/rest/crearcliente", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public Response crearCliente(@RequestBody Client request) {
		
		Response response = new Response();
		response.setCode("OK");
		response.setDescription("Usuario "+ request.getNombre() + " grabado.");
		
		return response;
	}
	
	
	@RequestMapping(value ="/services/rest/listadoProducto", 
			method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<Product> listProduct(@RequestBody Autenticacion request) {
		
		List<Product> response = new ArrayList<Product>();
			
		
		Product prod1 = new Product();
		prod1.setNombre("arroz");
		prod1.setCodigo("0001");		
		response.add(prod1);
		
		
		
		
		return response;
	}

	
}
