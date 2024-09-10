package org.petrolpump.admin.repository;

import java.util.ArrayList;
import java.util.List;

import org.petrolpump.admin.confing.DBConfig;
import org.petrolpump.admin.model.FuelTypeModel;

public class FuelRepositoryImpl extends DBConfig implements FuelRepository {

	List<FuelTypeModel> list =new ArrayList<FuelTypeModel>();
	@Override
	public boolean isAddFuelType(FuelTypeModel model) {
try
{
	stmt=conn.prepareStatement("insert into fueltype values('0',?)");
	stmt.setString(1, model.getName());
	return stmt.executeUpdate()>0?true:false;
}
catch(Exception ex)
{
	System.out.println("Error is"+ex);
	return false;
}
	}

	@Override
	public List<FuelTypeModel> geAllFuelTypes() {
try
{
	stmt=conn.prepareStatement("select * from fueltype");
	rs=stmt.executeQuery();
	while(rs.next())
	{
		FuelTypeModel  model=new FuelTypeModel();
		model.setId(rs.getInt(1));
		model.setName(rs.getString(2));
		list.add(model);
		
		
	}
	return list.size()>0?list:null;
	
}
catch(Exception ex)
{
	return null;

}
	}

}
