package com.bolsadeideas.springboot.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.web.models.entity.Plato;
import com.bolsadeideas.springboot.web.models.services.IPlatoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")

public class PlatoController {
@Autowired
private IPlatoService platoservice;

@GetMapping("/platos")
public List<Plato> get(){
	return platoservice.Gets();
}

@PostMapping("/platos")
public ResponseEntity<?> save(Plato plato){
	return platoservice.Save(plato);
}

@DeleteMapping("/platos/{id}")
public ResponseEntity<?> delete(@PathVariable Long Id){
	return platoservice.Delete(Id);
}

@PutMapping("/platos/{id}")
public ResponseEntity<?> update(Plato plato,@PathVariable Long Id){
	return platoservice.Update(plato, Id);
}
}
