package com.bolsadeideas.springboot.web.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.web.models.entity.Plato;

public interface IPlatoDao extends JpaRepository<Plato, Long> {

}
