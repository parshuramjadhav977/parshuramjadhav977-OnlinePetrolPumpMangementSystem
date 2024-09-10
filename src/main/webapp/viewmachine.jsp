<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.petrolpump.admin.service.*,java.util.*,org.petrolpump.admin.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.table  tr
{
	color: white;
}


.col
{
	background-size: 100% 100%;
	background-image: url("https://trak.in/wp-content/uploads/2021/08/Untitled-design-17.jpg");
	color: orange;

}
</style>
</head>
<body>
<%! 
MachineService machineService=new MachineServiceImpl();
%>
	<%@include file="admindashboard.jsp"%>
	<div class="col py-3">
	<br/><br/>	<br/><br/>
	<h1>Machine Details</h1>
	
<table class="table">
  <thead>
    <tr>
      <th scope="col">Sr.no</th>
      <th scope="col">Machine Code</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
    </tr>
  </thead>
  <tbody>
  <%
  List<MachineModel> list =machineService.getAllMachine();
  int count=0;
  for(MachineModel m:list)
  {
	  %>
	      <tr>
      <th scope="row"><%=++count%></th>
      <td><%=m.getMachinecode()%> </td>
      <td><a href='del?machineid=<%=m.getId()%>'> <img src="images/delete.png" alt="33"> </a></td>
          <td><a href='updmachine?mid=<%= m.getId()%>&mcode=<%=m.getMachinecode()%>'> <img src="images/update.png"alt="33"> </a></td>
    
    </tr>
	  <%  
  }
  %>

      
  </tbody>
</table>
	</div>
	</div>
	</div>
</body>
</html>