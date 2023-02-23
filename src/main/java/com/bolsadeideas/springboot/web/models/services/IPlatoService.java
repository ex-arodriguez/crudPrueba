package com.bolsadeideas.springboot.web.models.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bolsadeideas.springboot.web.models.entity.Plato;

public interface IPlatoService {
	public ResponseEntity<?>Save(Plato plato);
	public ResponseEntity<?>Delete(Long Id);
	public ResponseEntity<?>Update(Plato plato, Long Id);
	public List<Plato>Gets();

}
