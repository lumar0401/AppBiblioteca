package com.Biblioteca.App.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "prestamo")
public class PrestamoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	
	@Size(max = 10)
	private String isbn;
	
	@Size(max = 10)
	private String identificacionUsuario;
	
	private int tipoUsuario;
	
	private String fechaMaximaDevolucion;
	
	public PrestamoModel() {}

	public PrestamoModel(long id, @Size(max = 10) String isbn, @Size(max = 10) String identificacionUsuario,
			int tipoUsuario, String fechaMaximaDevolucion) {
		this.id = id;
		this.isbn = isbn;
		this.identificacionUsuario = identificacionUsuario;
		this.tipoUsuario = tipoUsuario;
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the identificacionUsuario
	 */
	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	/**
	 * @param identificacionUsuario the identificacionUsuario to set
	 */
	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}

	/**
	 * @return the tipoUsuario
	 */
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the fechaMaximaDevolucion
	 */
	public String getFechaMaximaDevolucion() {
		return fechaMaximaDevolucion;
	}

	/**
	 * @param fechaMaximaDevolucion the fechaMaximaDevolucion to set
	 */
	public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
		this.fechaMaximaDevolucion = fechaMaximaDevolucion;
	}
}
