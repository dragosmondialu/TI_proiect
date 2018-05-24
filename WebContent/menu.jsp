<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
<nav id="nav-bar">
	<img src="images/logo.png" alt="Logo" onclick="index.jsp" id="logo">
	<form action="index.jsp" style='display:inline;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="ACASĂ" id="submit" style='display:inline;'>
	</form>
	<form action="GetBooks" method="get" style='display:inline;'>
	<input type="submit" value="CĂRȚI" id="submit" style='display:inline;'></form>
	<form action="informatii.jsp" style='display:inline;'>
	<input type="submit" value="INFORMAȚII" id="submit" style='display:inline;'>
	</form>
	<form action="contact.jsp" style='display:inline;'style='display:inline;'>
	<input type="submit" value="CONTACT" id="submit" style='display:inline;'>
	</form>
	<form action="login.jsp" style='display:inline;'>
	<input type="submit" value="AUTENTIFICARE" id="submit" style='display:inline;'>
	</form>
</nav>
