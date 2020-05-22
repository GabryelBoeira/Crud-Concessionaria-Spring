package br.com.gabryel.concessionaria.service;

import java.util.List;

import br.com.gabryel.concessionaria.model.Vehicle;

public interface VehicleService {	

	boolean addOrUpdateVehicle(Vehicle vehicle);
	
	void deleteVehicle(String idVehicle);
	
	List<Vehicle> listVehicle();
	
	Vehicle selectVehicleForId(String idVehicle);
}
