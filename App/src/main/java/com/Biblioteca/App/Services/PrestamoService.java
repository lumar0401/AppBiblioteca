package com.Biblioteca.App.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Repository.PrestamoRepository;
import com.Biblioteca.App.Utils.utils;
import com.Biblioteca.App.models.PrestamoModel;

@Service
public class PrestamoService {
	@Autowired
	PrestamoRepository prestamorepository;

	public Map<String, Object> crearPrestamo(PrestamoModel prestamo) {
		Map<String, Object> response = new HashMap<String, Object>();

		String fechaCalculada = utils.calculoFecha(prestamo.getTipoUsuario());

		if (prestamo.getTipoUsuario() == 3) {
			response.put("mensaje", "Tipo de usuario no permitido en la biblioteca");
			return response;
		}

		if (prestamo.getTipoUsuario() == 3 && !consultarPrestamoPorUsuario(prestamo.getIdentificacionUsuario()).isEmpty()) {
			response.put("mensaje", "El usuario con identificación " + prestamo.getIdentificacionUsuario()
					+ " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");

			return response;
		}
		
		prestamo.setFechaMaximaDevolucion(fechaCalculada);
		
		PrestamoModel prestamoNuevo = prestamorepository.save(prestamo);
		
		response.put(String.valueOf(prestamoNuevo.getId()), fechaCalculada);
		
		return response;
	}
	
	public Optional<PrestamoModel> consultarPrestamoPorId(@NotNull PrestamoModel prestamo) {
        return prestamorepository.findById(prestamo.getId());
    }
	
	private List<PrestamoModel> consultarPrestamoPorUsuario(String idUsuario) {
        return prestamorepository.findByidentificacionUsuario(idUsuario);
    }
}
