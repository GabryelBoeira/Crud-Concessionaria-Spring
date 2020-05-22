package br.com.gabryel.concessionaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabryel.concessionaria.dao.VehicleDao;
import br.com.gabryel.concessionaria.model.Vehicle;
import br.com.gabryel.concessionaria.service.VehicleService;

@Service
public class ImplVehicleService implements VehicleService{

	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public boolean addOrUpdateVehicle(Vehicle vehicle) {
		return getVehicleDao().save(vehicle) != null ? true : false;
	}

	@Override
	public void deleteVehicle(String idVehicle) {
		Long id = Long.parseLong(idVehicle);
		getVehicleDao().deleteById(id);
	}
	
	@Override
	public List<Vehicle> listVehicle() {		
		return (List<Vehicle>) getVehicleDao().findAll();		
	}
	
	@Override
	public Vehicle selectVehicleForId(String idVehicle) {
		Long id = Long.parseLong(idVehicle);
		return getVehicleDao().findById(id).get();
	}	
	
	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}
}
