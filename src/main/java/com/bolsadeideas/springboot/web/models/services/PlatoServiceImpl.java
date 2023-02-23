package com.bolsadeideas.springboot.web.models.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.web.models.dao.IPlatoDao;
import com.bolsadeideas.springboot.web.models.entity.Plato;

@Service
public class PlatoServiceImpl implements IPlatoService {
	@Autowired
	private IPlatoDao platodao;
	@Override
	public ResponseEntity<?> Save(Plato plato) {
		// TODO Auto-generated method stub
		Map<String,Object> response=new HashMap<>();
		Plato platoNuevo=null;
		try {
			platoNuevo=platodao.save(plato);
		}catch(DataAccessException e) {
			response.put("mensaje","Error al guardar el plato de la base de datos!");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje","El plato ha sido creado con éxito!");
		response.put("plato", platoNuevo);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<?> Delete(Long Id) {
		// TODO Auto-generated method stub
		Map<String,Object> response=new HashMap<>();
		try {
			platodao.deleteById(Id);
		}catch(DataAccessException e) {
			response.put("mensaje","Error al eliminar el plato de la base de datos!");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje","El plato ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> Update(Plato plato, Long Id) {
		// TODO Auto-generated method stub
		Map<String,Object> response=new HashMap<>();
		Plato platoNuevo=null;
		try {
			platoNuevo=platodao.findById(Id).orElse(null);
			platoNuevo.setColor(plato.getColor());
			platoNuevo.setPrecio(plato.getPrecio());
			platoNuevo.setNombre(plato.getNombre());
			platodao.save(platoNuevo);
			
		}catch(DataAccessException e) {
			response.put("mensaje","Error al actualizar el plato de la base de datos!");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje","El plato ha sido actualizado con éxito!");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);	}

	@Override
	@Transactional(readOnly = true)
	public List<Plato> Gets() {
		// TODO Auto-generated method stub
		return platodao.findAll();
	}

}
