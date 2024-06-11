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

import com.example.demo.entity.Factura;

import com.example.demo.interfaces.FacturaClientService;

@RestController
@RequestMapping("/factura")

public class ControllerFactura {
@Autowired
private FacturaClientService facturaserv;
@GetMapping("/listarfactura")
public List<Factura > index() {
	return facturaserv.findAll();

}

@GetMapping("/findfactura/{id}")
public Factura showe(@PathVariable Long id)  {
	return facturaserv.findById(id);
}



@PostMapping("/facturasave")
@ResponseStatus(HttpStatus.CREATED)	
public ResponseEntity<?> createproductos(@Validated @RequestBody Factura  factura, BindingResult result) {
	
	Factura  facturaNew = null;


	Map<String, Object> response = new HashMap<>();

	if (result.hasErrors()) {

		List<String> errors = result.getFieldErrors().stream()
				.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
				.collect(Collectors.toList());

		response.put("errors", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}

	try {

		facturaNew = facturaserv.save(factura);
	
	} catch (DataAccessException e) {

		response.put("mensaje", "Error al realizar el insert en la base de datos");
		response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	response.put("mensaje", " ha sido creado con éxito!");
	response.put("factura", facturaNew);


	
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
}





@PutMapping("/facturaupdate/{id}")
@ResponseStatus(HttpStatus.CREATED)

public ResponseEntity<?> update(@Validated @RequestBody Factura  factura, BindingResult result, @PathVariable Long id) {

	Factura  fucActual = facturaserv.findById(id);

	Factura  fucUpdated = null;

Map<String, Object> response = new HashMap<>();

if(result.hasErrors()) {

	List<String> errors = result.getFieldErrors()
			.stream()
			.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
			.collect(Collectors.toList());
	
	response.put("errors", errors);
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
}

if (fucActual == null) {
	response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
			.concat(id.toString().concat(" no existe en la base de datos!")));
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
}

try {

	fucActual.setDate(factura.getDate());

	fucActual.setClient(factura.getClient());
	fucActual.setPayment(factura.getPayment());
	fucUpdated = facturaserv.save(fucActual);

} catch (DataAccessException e) {
	response.put("mensaje", "Error al actualizar la falta en la base de datos");
	response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
}

response.put("mensaje", "El cliente ha sido actualizado con éxito!");
response.put("cliente", fucUpdated);

return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
}


}
