package com.Biblioteca.App.Controllers;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Biblioteca.App.Services.PrestamoService;
import com.Biblioteca.App.models.PrestamoModel;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
	@Autowired
	PrestamoService prestamoservice;
	
	@GetMapping(path = "/{idPrestamo}")
    public Optional<PrestamoModel> getUserById(@PathVariable("idPrestamo") long id) {
        PrestamoModel prestamo = new PrestamoModel();
        prestamo.setId(id);

        return prestamoservice.consultarPrestamoPorId(prestamo);
    }
	
	@PostMapping()
    public Map<String, ?> crearPrestamo(@RequestBody PrestamoModel prestamo, HttpServletResponse responsePeticion) {
        Map<String, Object> response = prestamoservice.crearPrestamo(prestamo);
        Object[] llaves = response.keySet().toArray();
        String id = (String) llaves[0];
        String fechaDevolucion = (String) response.get(id);

        if (response.containsKey("mensaje")) {
        	responsePeticion.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            return response;
        }

        response.put("id", Integer.parseInt(id));
        response.put("fechaMaximaDevolucion", fechaDevolucion);
        response.remove(id);

        responsePeticion.setStatus(HttpServletResponse.SC_OK);
        
        return response;
    }
}
