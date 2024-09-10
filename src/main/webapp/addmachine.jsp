<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="org.petrolpump.admin.model.*,org.petrolpump.admin.service.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/adminstyle.css" rel="stylesheet">
<style type="text/css">

.col
{
	background-size: 100% 100%;
	background-image: url("https://trak.in/wp-content/uploads/2021/08/Untitled-design-17.jpg");

}
.formarea
{

background-color: red;
border-radius: 10px;
padding:10px;
}
.formarea tr
{
border-radius: 10px;

}

</style>
</head>
<body>
	<%@include file="admindashboard.jsp"%>
	<div class="col py-3">
		<center>
		<form class="formarea" name ="frm" action="newmachine" method="POST">
			<div class="form-group ">
				<label for="exampleInputEmail1">Machine Code</label> 
				<br/><br/>
				<input type="text" class="form-control control" name="machineCode" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter Machine Code">
					<br/><br/>
					<table>
					<%
					FuelService fService=new FuelTypeServiceImpl();
						List<FuelTypeModel>list =	fService.geAllFuelTypes();
					for(FuelTypeModel m:list)
					{
						%>
						<tr>
						<td> <input type='checkbox' name='ftype' value='<%=m.getId()%>'/>&nbsp; &nbsp;<%=m.getName()%></td>
						<td align='right'> <input type='text' name='capacity' value='' '/></td>
						</tr>
						<% 
			
					}
					%>
					
					</table>
					
			</div>
				<br/><br/>
				

			<button type="submit" class="btn btn-primary">Add New Machine</button>
		</form>
		</center>
		
	</div>
	
	</div>

</body>
</html>

