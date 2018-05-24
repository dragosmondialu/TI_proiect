<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Insert title here</title>
</head>
<body id="body">
	<header>
			<%@ include file= "menu.jsp" %>
	</header>
	<div id="addForm">
	<h2>Adaugă carte</h2>
	<form method="post" action="AddBookServlet">
	
		<input type="text" name="id" placeholder="ID">
		<br>
		<input type="text" name="isbn" placeholder="ISBN">
		<br>
		<input type="text" name="titlu" placeholder="TITLU">
		<br>
		<input type="text" name="autor" placeholder="AUTOR">
		<br>
		<input type="text" name="gen" placeholder="GEN">
		<p id="dispon">Disponibilitate: <input type="checkbox" name="disponibilitate" > </p>
		<br>
		
		
		<input type="submit" value="Adauga">
		
		
		<!--  <table border="0">
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td width="10%">ID:</td><td width="90%"><input type="text" name="id"></td>
        </tr>
        
        <tr>
            <td width="10%">ISBN:</td><td width="90%"><input type="text" name="isbn"></td>
        </tr>
        <tr>
            <td>TITLU:</td><td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td width="10%">AUTOR:</td><td width="90%"><input type="text" name="autor"></td>
        </tr>
        <tr>
            <td width="10%">GEN:</td><td width="90%"><input type="text" name="gen"></td>
        </tr>
        <tr>
            <td width="10%">DISPONIBILITATE:</td><td width="90%"><input type="checkbox" name="disponibilitate"></td>
        </tr>
        
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Adauga">
            </td>
        </tr>
    </table>-->
    </form>
    </div>
</body>
</html>

