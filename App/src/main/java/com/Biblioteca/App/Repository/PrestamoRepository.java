package com.Biblioteca.App.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.App.models.PrestamoModel;

@Repository
public interface PrestamoRepository extends CrudRepository<PrestamoModel, Long>{
	List<PrestamoModel> findByidentificacionUsuario(String identificacion);
}
