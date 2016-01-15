<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
<title>Edit</title>
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
 
 
 
 <b>Edit User Details </b>
 

  <div>
   <form:form method="post" action="update" modelAttribute="user">
    <table>
   
   
     <tr>
      <td> Name :</td>
      <td><form:input path="custName"
        value="${map.user.custName}" />
      </td>
     </tr>
    
    
      <tr>
      <td> Address Line 1 :</td>
      <td><form:input path="custAddr1" class="form-control" value="${map.user.custAddr1}"/></td>
     </tr>
    
    
      <tr>
      <td> Address Line 2 :</td>
     <td><form:input path="custAddr1" class="form-control" value="${map.user.custAddr2}"/></td>
       
     </tr>
   
     <tr>
      <td> Pin  :</td>
      <td><form:input path="custPin"
        value="${map.user.custPin}" />
      </td>
     </tr>
    
    
      <tr>
      <td>Email : </td>
      <td><form:input path="email"
        value="${map.user.email}" />
      </td>
     </tr>
    
    
    
      <tr>
      <td> Contact :</td>
      <td><form:input path="contact"
        value="${map.user.contact}" />
      </td>
     </tr>
    
    
      <tr>
      <td> Primary Contact :</td>
      <td><form:input path="primaryContactPerson"
        value="${map.user.primaryContactPerson}" />
      </td>
     </tr>
    
    
      <tr>
      <td> Flag :</td>
      
         <td><form:select path="flag">
          <form:option value="A">ACTIVE</form:option>
         <form:option value="I">INACTIVE</form:option>
          </form:select></td>
                        
      </td>
     </tr>
    
   
    
    
    
     

     <tr>
      <td> </td>
      <td><input type="submit" value="Save" />
      </td>
     </tr>
    </table>
    <form:hidden path="custId" value="${map.user.custId}" />

   </form:form>
  </div>
  <div>
    <a href="logout" class="btn btn-danger" role="button">Logout</a>
    </div>
 </center>
 
</body>
</html>


