<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- CORRECTION 1 : Importation obligatoire de la JSTL Core pour faire fonctionner <c:forEach> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<Link rel="stylesheet" type="text/css" href="style.css" />
<title>Gestion Tribunal</title>
</head>
<body>
		<%@ include file="/WEB-INF/menu.jsp" %>
		<fieldset>
		<h2>Formulaire de Modification</h2>
		<form action="Enregistreraffaire" method="post">
			<p>
				<label for="numaf">NUM_AF :</label>
				<input type="text" name="numaf" id="numaf" value="${aff.numaf}" readonly/>
			</p>
			<p>
				<label for="datedebut">Date Debut :</label>
				<%-- CONSEIL : Vous pouvez utiliser type="date" pour avoir un calendrier natif au format yyyy-MM-dd --%>
				<input type="text" name="datedebut" id="datedebut" value="${aff.datedebut}" />
			</p>
			<p>
				<label for="nature">Nature :</label>
				<input type="text" name="nature" id="nature" value="${aff.nature}"/>
			</p>
			<p>
				<label for="typeaf">Type Affaire :</label>
				<input type="text" name="typeaf" id="typeaf" value="${aff.typeaf}"/>
			</p>
			<p>
				<label for="idmag">ID MAG :</label>
				<input type="text" name="idmag" id="idmag" value="${aff.idmag}"/>
			</p>
			<p id="btn">
				<input type="submit" value="Enregistrer" />
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
							<%-- CORRECTION 2 : Changement de aff.numaff en aff.numaf pour correspondre au getter --%>
							<a href="suppaffaire?param=${aff.numaf}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>
