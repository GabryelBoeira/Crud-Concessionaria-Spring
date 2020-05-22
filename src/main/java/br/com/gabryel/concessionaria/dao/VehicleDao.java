package br.com.gabryel.concessionaria.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gabryel.concessionaria.model.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Long> {
	
}
