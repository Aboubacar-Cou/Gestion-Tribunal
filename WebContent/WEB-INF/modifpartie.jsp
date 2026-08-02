<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    <form action="Modifpartie" method="post">
        <p>
            <label for="idpartie">ID Partie (Non modifiable) :</label>
            <input type="text" name="idpartie" id="idpartie" value="${part.idpartie}" readonly="readonly" style="background-color: #eee;" />
        </p>
        
        <p>
            <label for="libpartie">Libellé Partie :</label>
            <input type="text" name="libpartie" id="libpartie" value="${part.libpartie}" />
        </p>
        
        <p>
            <label for="adrpartie">Adresse :</label>
            <input type="text" name="adrpartie" id="adrpartie" value="${part.adrpartie}" />
        </p>
        
        <p>
            <label for="telpartie">Téléphone :</label>
            <input type="text" name="telpartie" id="telpartie" value="${part.telpartie}" />
        </p>
        	<p id="btn">
				<input type="submit" value="Enregistrer les modifications" />
				<input type="reset" value="Annuler" />
			</p>
    </form>
	</fieldset>
	<br/><hr/><br/>
    <%-- Tableau d'affichage dynamique en bas de page --%>
    <table border="1">
        <caption>Liste de contrôle des Parties</caption>
        <thead>
            <tr>
                <th>ID</th>
                <th>Libellé</th>
                <th>Adresse</th>
                <th>Téléphone</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lpart}" var="p"> 
                <tr> 
                    <td>${p.idpartie}</td>
                    <td>${p.libpartie}</td>
                    <td>${p.adrpartie}</td>
                    <td>${p.telpartie}</td>
                    <td>
                        <a href="Modifpartie?param=${p.idpartie}">Modifier</a>
                        <a href="suppPartie?param=${part.idpartie}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>
