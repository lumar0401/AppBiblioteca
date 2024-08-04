package com.Biblioteca.App.Utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class utilsTest {
	@Autowired
	utils util;

	@Test
	void test() {
		int tipoUsuario = 2;
		
        String fechaEsperada = "2024-08-14";

        String fechaCalculada = util.calculoFecha(tipoUsuario);

        assertEquals(fechaEsperada.toString(), fechaCalculada, "La fecha calculada no coincide con la fecha esperada para el tipo de usuario 1");
	}

}
