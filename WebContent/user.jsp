<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<Link rel="stylesheet" type="text/css" href="style.css" />
<title>Connexion</title>
</head>
<body>
	
    <fieldset>
    <legend>Connexion</legend>
    <form action="Sconnecteruser" method="post">
        <p>
            <label for="nomuser">Nom :</label>
            <input type="text" name="nomuser" id="nomuser" />
        </p>
        <p>
            <label for="prenomuser">Prenom :</label>
            <input type="text" name="prenomuser" id="prenomuser" />
        </p>
        <p>
            <label for="motdepasse">Mot de passe :</label>
            <input type="password" name="motdepasse" id="motdepasse" />
        </p>
        <p id="btn">
            <input type="submit" value="Valider" />
        </p>
    </form>
    </fieldset>
</body>
</html>