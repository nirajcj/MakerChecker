<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width-device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
nav.navbar-findcond { background: #fff; border-color: #ccc; box-shadow: 0 0 2px 0 #ccc; }
nav.navbar-findcond a { color: #f14444; }
nav.navbar-findcond ul.navbar-nav a { color: #f14444; border-style: solid; border-width: 0 0 2px 0; border-color: #fff; }
nav.navbar-findcond ul.navbar-nav a:hover,
nav.navbar-findcond ul.navbar-nav a:visited,
nav.navbar-findcond ul.navbar-nav a:focus,
nav.navbar-findcond ul.navbar-nav a:active { background: #fff; }
nav.navbar-findcond ul.navbar-nav a:hover { border-color: #f14444; }
nav.navbar-findcond li.divider { background: #ccc; }
nav.navbar-findcond button.navbar-toggle { background: #f14444; border-radius: 2px; }
nav.navbar-findcond button.navbar-toggle:hover { background: #999; }
nav.navbar-findcond button.navbar-toggle > span.icon-bar { background: #fff; }
nav.navbar-findcond ul.dropdown-menu { border: 0; background: #fff; border-radius: 4px; margin: 4px 0; box-shadow: 0 0 4px 0 #ccc; }
nav.navbar-findcond ul.dropdown-menu > li > a { color: #444; }
nav.navbar-findcond ul.dropdown-menu > li > a:hover { background: #f14444; color: #fff; }
nav.navbar-findcond span.badge { background: #f14444; font-weight: normal; font-size: 11px; margin: 0 4px; }
nav.navbar-findcond span.badge.new { background: rgba(255, 0, 0, 0.8); color: #fff; }
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
 text-align: left;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}

.error{
color:red;
}

</style>

<title>
Login Page
</title>

<body>
<nav class="navbar navbar-findcond navbar-fixed-top">
    <div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Maker</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="nav navbar-nav navbar-right"><!-- 
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-fw fa-bell-o"></i> Bildirimler <span class="badge">0</span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="fa fa-fw fa-tag"></i> <span class="badge">Music</span> sayfası <span class="badge">Video</span> sayfasında etiketlendi</a></li>
						<li><a href="#"><i class="fa fa-fw fa-thumbs-o-up"></i> <span class="badge">Music</span> sayfasında iletiniz beğenildi</a></li>
						<li><a href="#"><i class="fa fa-fw fa-thumbs-o-up"></i> <span class="badge">Video</span> sayfasında iletiniz beğenildi</a></li>
						<li><a href="#"><i class="fa fa-fw fa-thumbs-o-up"></i> <span class="badge">Game</span> sayfasında iletiniz beğenildi</a></li>
					</ul>
				</li> -->
				<li class="active"><a href="register" >Add User<span class="sr-only">(current)</span></a></li>
				<li class="active"><a href="getList" >User List <span class="sr-only">(current)</span></a></li>
				<li class="active"><a href="getMasterList">Master List <span class="sr-only">(current)</span></a></li>
				<li class="active"><a href="logout">Logout <span class="sr-only">(current)</span></a></li>
				<!-- <li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Admin <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Geri bildirim</a></li>
						<li><a href="#">Yardım</a></li>
						<li class="divider"></li>
						<li><a href="#">Ayarlar</a></li>
						<li><a href="#exit">Çıkış yap</a></li>
					</ul>
				</li>
			 --></ul><!-- 
			<form class="navbar-form navbar-right search-form" role="search">
				<input type="text" class="form-control" placeholder="Search" />
			</form> -->
		</div>
	</div>
</nav>

<br>
<br>
<div>
<center>

 <form:form action="insert" name="insertForm" method="post" commandName="user" >
                <table>
                    <tr>
                        <td>Customer Code :</td>                       
                        <td><form:input path="custCode"></form:input></td>
                        <td><form:errors path="custCode" cssClass="error" />${msg}</td>
                       
                    </tr>
                    <tr>
                        <td>Customer Name :</td>
                        <td><form:input path="custName" /></td>
                        <td><form:errors path="custName" cssClass="error" /></td>
                       
                    </tr>
                    <tr>
                        <td>Customer Address1 :</td>
                        <td><form:textarea path="custAddr1" class="form-control"></form:textarea></td>
                        <td><form:errors path="custAddr1" cssClass="error" /></td>
                       
                    </tr>
                    <tr>
                        <td>Customer Address2 :</td>
                        <td><form:textarea path="custAddr2" class="form-control"></form:textarea></td>
                        <td><form:errors path="custAddr2" cssClass="error" /></td>
                       
                    </tr>
                    <tr>
                        <td>Customer PinCode : </td>                       
                        <td><form:input path="custPin" /></td>
                        <td><form:errors path="custPin" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>Email address :</td>
                        <td><form:input path="email" /></td>
                        <td><form:errors path="email" cssClass="error" /></td>
                       
                    </tr>
                    <tr>
                        <td>Contact Number : </td>                       
                        <td><form:input path="contact" /></td>
                        <td><form:errors path="contact" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td>Primary Contact Person :</td>
                        <td><form:input path="primaryContactPerson" /></td>
                        <td><form:errors path="primaryContactPerson" cssClass="error" /></td>
                       
                    </tr>
                    <tr>
                        <td>Flag :</td>
                        <td><form:select path="flag">
                                <form:option value="A">ACTIVE</form:option>
                                <form:option value="I">INACTIVE</form:option>
                            </form:select></td>
                            <td><form:errors path="flag" cssClass="error" /></td>
                            
                            
                       
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>
                    <br>
                    <br>
                   
                    <tr>
                    
                       
                        <td><a href="getList" class="btn btn-info" role="button">User List</a></td>
                        <td><a href="getMasterList" class="btn btn-info" role="button">Request</a></td>
                        <td><a href="logout" class="btn btn-danger" role="button">Logout</a></td>
                    </tr>
                </table>
            </form:form>
            
            </center>

</div>



</body>
</html>