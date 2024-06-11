package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;

import com.example.demo.interfaces.ClientService;

@RestController
@RequestMapping("/client")

public class ControllerClient {
@Autowired
private ClientService clientserv;

@GetMapping("/listarclientes")
public List<Client> index() {
	return  clientserv.findAll();

}

@GetMapping("/findcliente/{id}")
public Client showe(@PathVariable Long id)  {
	return  clientserv.findById(id);
}



@PostMapping("/clientesave")
@ResponseStatus(HttpStatus.CREATED)	
public ResponseEntity<?> createproductos(@Validated @RequestBody Client cliente, BindingResult result) {
	
	Client cliNew = null;


	Map<String, Object> response = new HashMap<>();

	if (result.hasErrors()) {

		List<String> errors = result.getFieldErrors().stream()
				.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
				.collect(Collectors.toList());

		response.put("errors", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}

	try {

		cliNew = clientserv.save(cliente);
	
	} catch (DataAccessException e) {

		response.put("mensaje", "Error al realizar el insert en la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	response.put("mensaje", "el cliente ha sido creado con éxito!");
	response.put("user", cliNew);


	
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
}





@PutMapping("/clienteupdate/{id}")
@ResponseStatus(HttpStatus.CREATED)

public ResponseEntity<?> update(@Validated @RequestBody Client clientes, BindingResult result, @PathVariable Long id) {

	Client cliActual =  clientserv.findById(id);

	Client cliUpdated = null;

Map<String, Object> response = new HashMap<>();

if(result.hasErrors()) {

	List<String> errors = result.getFieldErrors()
			.stream()
			.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
			.collect(Collectors.toList());
	
	response.put("errors", errors);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
}

if (cliActual == null) {
	response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
			.concat(id.toString().concat(" no existe en la base de datos!")));
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
}

try {

	cliActual.setName(clientes.getName());
	
	cliActual.setLastname(clientes.getLastname());
cliActual.setAddress(clientes.getAddress());
	
	cliActual.setEmail(clientes.getEmail());
cliActual.setBirthdate(clientes.getBirthdate());
	
	cliActual.setPhone(clientes.getPhone());
	cliUpdated =  clientserv.save(cliActual);

} catch (DataAccessException e) {
	response.put("mensaje", "Error al actualizar la falta en la base de datos");
	response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
}

response.put("mensaje", "El cliente ha sido actualizado con éxito!");
response.put("cliente", cliUpdated);

return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
}


}
