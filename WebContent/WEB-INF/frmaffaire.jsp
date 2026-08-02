<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Link rel="stylesheet" type="text/css" href="style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gestion Tribunal</title>
</head>
<body>
		<%@ include file="/WEB-INF/menu.jsp" %>
	<fieldset>	
	<legend>Enregistrement Affaire</legend>
		<form action="Enregistreraffaire" method="post">
			<p>
				<label for="numaf">NUM_AF :</label>
				<input type="text" name="numaf" id="numaf" />
			</p>
			<p>
				<label for="datedebut">Date Debut :</label>
				<input type="text" name="datedebut" id="datedebut"  />
			</p>
			<p>
				<label for="nature">Nature :</label>
				<input type="text" name="nature" id="nature" />
			</p>
			<p>
				<label for="typeaf">Type Affaire :</label>
				<input type="text" name="typeaf" id="typeaf" />
			</p>
			<p>
				<label for="typeaf">ID Magistrat :</label>
				<select name="idmag">
						<option value="#">Choisir un Magistrat</option>
							<c:forEach items="${lmag}" var="mag">
				 			<option value="${mag.idmag}">${mag.nommag}</option>
							</c:forEach>
				</select>
			</p>
			<p id="btn">
				<input type="submit" value="Ajouter" />
				<input type="reset" value="Annuler" />
			</p>
		</form>
	</fieldset>	
		<br/><hr/><br/>
		<table border="1">
			<caption>Liste des Affaires</caption>
			<thead>
				<tr>
					<th>Num</th>
					<th>Date</th>
					<th>Nature</th>
					<th>Type</th>
					<th>ID_mag</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${laff}" var="aff"> 
					<tr> 
						<td>${aff.numaf}</td>
						<td>${aff.datedebut}</td>
						<td>${aff.nature}</td>
						<td>${aff.typeaf}</td>
						<td>${aff.idmag}</td>
						<td>
							<a href="Modifaffaire?param=${aff.numaf}">Modifier</a>
							<a href="suppaffaire?param=${aff.numaf}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>