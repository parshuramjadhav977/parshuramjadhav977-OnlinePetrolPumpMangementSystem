package org.petrolpump.admin.controller;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.petrolpump.admin.model.MachineModel;
import org.petrolpump.admin.service.*;


@WebServlet("/newmachine")
public class MachineController extends HttpServlet {
MachineServiceImpl machineService=new MachineServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();

	String machineCode=request.getParameter("machineCode");
	String ftypeId[]=request.getParameterValues("ftype");
	String capArray[]=request.getParameterValues("capacity");
	
	MachineModel model=new MachineModel();
	model.setMachinecode(machineCode);
	
boolean flag =false;

		
	boolean b=machineService.isAddNewMachine(model,ftypeId,capArray);
	if(b)
	{
		out.println("<h1> machine added SUccessfully</h1>");

	}
		
		
	
		
		else
		{
			out.println("<h1> machine  not Added Successfully...</h1>");

		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
