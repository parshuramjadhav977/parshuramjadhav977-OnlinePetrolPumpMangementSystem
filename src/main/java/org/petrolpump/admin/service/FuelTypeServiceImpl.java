package org.petrolpump.admin.service;

import java.util.List;


import org.petrolpump.admin.model.FuelTypeModel;

import org.petrolpump.admin.repository.*;

public class FuelTypeServiceImpl implements FuelService {
FuelRepository fuelRepo=new FuelRepositoryImpl();
	@Override
	public boolean isAddFuelModel(FuelTypeModel model) {
		return fuelRepo.isAddFuelType(model);
	}
	
	
	@Override
	public List<FuelTypeModel> geAllFuelTypes() {

		
		return fuelRepo.geAllFuelTypes();
	}

}
