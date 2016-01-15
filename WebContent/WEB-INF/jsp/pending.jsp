
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <%@ page import="java.util.*" %>
    <%@ page import="java.lang.*" %>
    <%@ page import="com.bean.*" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
<title>List</title>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 160px;
 height: 30px;
 text-align: center;
}
.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
 <center>
 
 
 
 <b>User
   List </b>
 

  
 

  <table border="1">
   <tr>
    <td class="heading">Customer Id</td>
    <td class="heading">Name</td>
    <td class="heading">Address</td>
    <td class="heading">Pin</td>
    <td class="heading">Email</td>
    <td class="heading">Contact</td>
    <td class="heading">Primary Contact</td>
    <td class="heading">Flag</td>
    <td class="heading">Record Status</td>
    <td class="heading">Authorize</td>
	<td class="heading">Reject</td>
   </tr>
  
  
  
   <% Iterator it = ((List)request.getAttribute("userList")).iterator();
                                                while(it.hasNext())
                                                {
                                                       
                                                User user = (User) it.next();%>
                                                        <tr><td> <%= user.getCustId()%></td>
                                                         <td><%= user.getCustName()%></td>
                                                        <td><%= user.getCustAddr1()+" "+user.getCustAddr2()%></td>
                                                        <td><%= user.getCustPin()%></td>
                                                        <td><%= user.getEmail()%></td>
                                                        <td><%= user.getContact()%></td>
                                                        <td><%= user.getPrimaryContactPerson()%></td>
                                                        <td><%= user.getFlag()%></td>
                                                        <td><%= user.getRecordStatus()%></td>
                                                 
                                                        <td><a href="authorize?id=<%= user.getCustId()%>">Approve</a></td>
                                                         <td><a href="reject?id=<%= user.getCustId()%>">Reject</a></td>
                                            

                                                       
                                                       
                                                <% }%>

 
   <!-- <tr><td colspan="7"><a href="register">Add New User</a></td></tr> -->
  </table>
  <div>
    <a href="logout" class="btn btn-danger" role="button">Logout</a></div>

 </center>
</body>
</html>
