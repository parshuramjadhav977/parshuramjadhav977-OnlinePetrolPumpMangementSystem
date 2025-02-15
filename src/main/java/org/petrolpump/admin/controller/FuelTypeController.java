package org.petrolpump.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.petrolpump.admin.model.FuelTypeModel;
import org.petrolpump.admin.service.FuelService;
import org.petrolpump.admin.service.FuelTypeServiceImpl;


@WebServlet("/fueltype")
public class FuelTypeController extends HttpServlet {
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out =response.getWriter();
String  fuelType=request.getParameter("type");
FuelTypeModel model=new FuelTypeModel();
model.setName(fuelType);
FuelService fService =new FuelTypeServiceImpl();
boolean b=fService.isAddFuelModel(model);
if(b)
{
	RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
	r.include(request, response);
	out.println("<center> Fuel Type added Sucessfully....</center>");
}
else
{
	RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
	r.include(request, response);
	out.println("<center> some problem is there....</center>");

}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
