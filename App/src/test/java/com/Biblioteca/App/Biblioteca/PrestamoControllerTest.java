package com.Biblioteca.App.Biblioteca;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Biblioteca.App.Biblioteca.Models.prestamo;
import com.Biblioteca.App.Biblioteca.Models.responseTest;
import com.Biblioteca.App.Services.PrestamoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class PrestamoControllerTest {
	public static final int USUARIO_AFILIADO = 1;
    public static final int USUARIO_EMPLEADO = 2;
    public static final int USUARIO_INVITADO = 3;
    public static final int USUARIO_DESCONOCIDO = 5;
	
	@Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    PrestamoService prestamoservice;
    
//    @Test
//    public void testCrearPrestamoUsuarioAfiliado() throws Exception {
//    	MvcResult resultadoLibroPrestado = mvc.perform(
//                MockMvcRequestBuilders.post("/prestamo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new prestamo("ISBN01", "1107522851", USUARIO_AFILIADO))))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
//                .andReturn();
//    	
//    	responseTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), responseTest.class);
//    	
//    	mvc.perform(MockMvcRequestBuilders
//                .get("/prestamo/" + resultadoPrestamo.getId())
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.fechaMaximaDevolucion", is("2024-08-16")))
//                .andExpect(jsonPath("$.isbn", is("ISBN01")))
//                .andExpect(jsonPath("$.identificacionUsuario", is("1107522851")))
//                .andExpect(jsonPath("$.tipoUsuario", is(USUARIO_AFILIADO)));
//    }
    
    @Test
    public void testCrearPrestamoUsuarioEmpleado() throws Exception {
    	MvcResult resultadoLibroPrestado = mvc.perform(
                MockMvcRequestBuilders.post("/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new prestamo("ISBN02", "1107522852", USUARIO_EMPLEADO))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
                .andReturn();
    	
    	responseTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), responseTest.class);
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/prestamo/" + resultadoPrestamo.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fechaMaximaDevolucion", is("2024-08-14")))
                .andExpect(jsonPath("$.isbn", is("ISBN02")))
                .andExpect(jsonPath("$.identificacionUsuario", is("1107522852")))
                .andExpect(jsonPath("$.tipoUsuario", is(USUARIO_EMPLEADO)));
    }
//
//    @Test
//    public void testCrearPrestamoUsuarioInvitado() throws Exception {
//    	MvcResult resultadoLibroPrestado = mvc.perform(
//                MockMvcRequestBuilders.post("/prestamo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new prestamo("ISBN03", "1107522853", USUARIO_INVITADO))))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
//                .andReturn();
//    	
//    	responseTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), responseTest.class);
//    	
//    	mvc.perform(MockMvcRequestBuilders
//                .get("/prestamo/" + resultadoPrestamo.getId())
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.fechaMaximaDevolucion", is("2024-08-13")))
//                .andExpect(jsonPath("$.isbn", is("ISBN03")))
//                .andExpect(jsonPath("$.identificacionUsuario", is("1107522853")))
//                .andExpect(jsonPath("$.tipoUsuario", is(USUARIO_INVITADO)));
//    }
//    
//    @Test
//    public void testCrearPrestamoUsuarioInvitadoVariasVeces() throws Exception {
//    	MvcResult resultadoLibroPrestado = mvc.perform(
//                MockMvcRequestBuilders.post("/prestamo")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(new prestamo("ISBN04", "1107522854", USUARIO_INVITADO))))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.fechaMaximaDevolucion").exists())
//                .andReturn();
//    	
//    	responseTest resultadoPrestamo = objectMapper.readValue(resultadoLibroPrestado.getResponse().getContentAsString(), responseTest.class);
//    	
//    	mvc.perform(MockMvcRequestBuilders
//                .post("/prestamo")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new prestamo("EQWQW8545", "1111111111", USUARIO_INVITADO))))
//                .andDo(print())
//                .andExpect(status().is4xxClientError())
//                .andExpect(jsonPath("$.mensaje", is("El usuario con identificación 1111111111 ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo")));
//    }
//    
//    @Test
//    public void testCrearPrestamoUsuarioDesconocido() throws Exception {    	
//    	mvc.perform(MockMvcRequestBuilders
//                .post("/prestamo")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new prestamo("ISBN05", "1107522856", USUARIO_DESCONOCIDO))))
//                .andDo(print())
//                .andExpect(status().is4xxClientError())
//                .andExpect(jsonPath("$.mensaje", is("Tipo de usuario no permitido en la biblioteca")));
//    }
}
