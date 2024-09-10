package org.petrolpump.admin.service;

import java.util.List;

import org.petrolpump.admin.model.MachineModel;

public interface MachineService {
	public boolean isAddNewMachine(MachineModel model,String typeId[],String [] capacity);
public List<MachineModel>getAllMachine();
public boolean  isDeleteMachineById(int mid);
public boolean isUpdateMachine(MachineModel model);

}
