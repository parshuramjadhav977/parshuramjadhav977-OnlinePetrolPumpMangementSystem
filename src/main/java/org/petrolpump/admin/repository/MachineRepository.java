package org.petrolpump.admin.repository;

import java.util.List;

import org.petrolpump.admin.model.MachineModel;

public interface MachineRepository {

	public boolean isAddNewMachine(MachineModel model,String typeid[],String  []capacity);
	public List<MachineModel>getAllMachine();
	public boolean isDeleteMachineById(int mid);
	public boolean isUpdateMachine(MachineModel model );
}
