package org.petrolpump.admin.repository;

import org.petrolpump.admin.confing.*;

import org.petrolpump.admin.model.MachineModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
public class MachineRepositoryImpl extends DBConfig implements MachineRepository{
	List<MachineModel> list;
	
	int mid;
	public int getMachineIdAutomatic()
	{
		try
		{
			stmt=conn.prepareStatement("select max(mid) from machineinfo");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				mid=rs.getInt(1);
			 
			}
			++mid;
			return mid;
		}
		catch(Exception ex)
		{
			System.out.println("eroor is"+ex);
			return -1;
		}
	}
	
	@Override
	public boolean isAddNewMachine(MachineModel model ,String typeid[],String []capacity) {
		try
		{
			 mid=this.getMachineIdAutomatic();
			String mchineCode=model.getMachinecode();
			
			stmt=conn.prepareStatement("insert into machineinfo values("+mid+",'"+mchineCode+"')");
	int value=stmt.executeUpdate();
			
			if(value>0)
			{
				for(int i=0;i<capacity.length;i++)
				{
					
				if(capacity[i]!=null)
				{
					stmt=conn.prepareStatement("insert into machinetypejoin values(?,?,?)");
					stmt.setInt(1, mid);
					stmt.setInt(2, Integer.parseInt(typeid[i]));
					stmt.setInt(3, Integer.parseInt(capacity[i]));


					value =stmt.executeUpdate();
				}
					
					
				
			}
return value > 0?true:false;
		}
			
			else
			{
				return false;
			}
		}
		catch (Exception ex) {
			System.out.println("Error is "+ex);
			return false;
		}
		}
			
			


	@Override
	public List<MachineModel> getAllMachine() {
try
{
	list=new ArrayList<MachineModel>();
	stmt=conn.prepareStatement("select * from machineinfo");
	rs=stmt.executeQuery();
	while(rs.next())
	{
		MachineModel model=new MachineModel();
		model.setId(rs.getInt(1));
		model.setMachinecode(rs.getString(2));
		list.add(model);
		
	}
	return list.size()>0?list:null;
}
catch(Exception ex)
{
	System.out.println("Error is "+ex);
}
		return null;
	}

	@Override
	public boolean isDeleteMachineById(int mid) {
try
{
	stmt=conn.prepareStatement("delete from machineinfo where mid=?");
	stmt.setInt(1, mid);
	int value = stmt.executeUpdate();
	return value>0?true:false;
	
} 
catch(Exception ex)
{
	System.out.println("Error is"+ex);
	return false;
}

	
}

	@Override
	public boolean isUpdateMachine(MachineModel model) {

		
		try
		{
			stmt=conn.prepareStatement("update machineinfo set machinecode=? where mid=?");
		stmt.setString(1, model.getMachinecode());
		stmt.setInt(2, model.getId());
		int value=stmt.executeUpdate();
		return value>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return false;
		}
	}
	}


