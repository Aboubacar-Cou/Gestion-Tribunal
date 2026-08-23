<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Gestion Tribunal</title>
</head>
<style>
	/* ===== style.css - Gestion Tribunal ===== */
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Segoe UI', Arial, sans-serif;
    background-color: #f4f4f4;
    color: #333;
    padding-bottom: 80px;
}

/* ===== HERO (page d'accueil) ===== */
.hero {
    background: linear-gradient(135deg, #1a2a4a, #2c4a7c);
    color: white;
    text-align: center;
    padding: 70px 20px 60px;
}

.hero h1 {
    font-size: 2.2rem;
    margin-bottom: 15px;
}

.hero p {
    max-width: 700px;
    margin: 0 auto;
    color: #dbe4f0;
    font-size: 1.05rem;
    line-height: 1.6;
}

/* ===== CARTES FONCTIONNALITES (page d'accueil) ===== */
.features {
    max-width: 1100px;
    margin: -30px auto 40px;
    padding: 0 20px;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    gap: 20px;
}

.card {
    background: white;
    border-radius: 12px;
    padding: 25px 20px;
    text-align: center;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
    transition: transform 0.2s ease;
    text-decoration: none;
    display: block;
}

.card:hover {
    transform: translateY(-5px);
}

.card .icon {
    font-size: 2rem;
    margin-bottom: 12px;
}

.card h3 {
    font-size: 1.1rem;
    margin-bottom: 8px;
    color: #1a2a4a;
}

.card p {
    font-size: 0.9rem;
    color: #555;
    line-height: 1.5;
}

@media (max-width: 600px) {
    .hero h1 { font-size: 1.6rem; }
}

/* ===== FIELDSET / FORMULAIRE ===== */
fieldset {
    max-width: 750px;
    margin: 30px auto;
    background: white;
    border: none;
    border-radius: 12px;
    padding: 30px 35px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
}

legend {
    font-size: 1.3rem;
    font-weight: 600;
    color: #1a2a4a;
    padding: 0 10px;
}

fieldset form p {
    display: flex;
    flex-direction: column;
    margin-bottom: 16px;
}

fieldset form label {
    font-size: 0.85rem;
    font-weight: 600;
    color: #1a2a4a;
    margin-bottom: 6px;
}

fieldset form input[type="text"],
fieldset form select {
    padding: 10px 12px;
    border: 1px solid #d0d5dd;
    border-radius: 8px;
    font-size: 0.9rem;
    font-family: inherit;
    color: #333;
    background-color: #fafafa;
}

fieldset form input[type="text"]:focus,
fieldset form select:focus {
    outline: none;
    border-color: #2c4a7c;
    background-color: white;
}

#btn {
    flex-direction: row !important;
    justify-content: flex-end;
    gap: 12px;
    margin-top: 10px;
}

#btn input[type="submit"],
#btn input[type="reset"] {
    padding: 11px 26px;
    border-radius: 8px;
    border: none;
    font-size: 0.9rem;
    font-weight: 600;
    cursor: pointer;
}

#btn input[type="submit"] {
    background-color: #2c4a7c;
    color: white;
}
#btn input[type="submit"]:hover {
    background-color: #1a2a4a;
}

#btn input[type="reset"] {
    background-color: #eee;
    color: #333;
}
#btn input[type="reset"]:hover {
    background-color: #ddd;
}

/* ===== SEPARATEUR ===== */
hr {
    max-width: 750px;
    margin: 20px auto;
    border: none;
    border-top: 1px solid #ddd;
}

/* ===== TABLEAU DE LISTE ===== */
table {
    width: 90%;
    max-width: 1000px;
    margin: 20px auto 40px;
    border-collapse: collapse;
    background: white;
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
}

table caption {
    caption-side: top;
    text-align: left;
    font-size: 1.2rem;
    font-weight: 600;
    color: #1a2a4a;
    padding: 15px 20px;
    background: white;
}

table thead,
table tr:first-child {
    background-color: #1a2a4a;
}

table th {
    color: white;
    text-align: left;
    padding: 12px 16px;
    font-size: 0.85rem;
    text-transform: uppercase;
    letter-spacing: 0.03em;
}

table td {
    padding: 12px 16px;
    border-bottom: 1px solid #eee;
    font-size: 0.9rem;
}

table tbody tr:hover {
    background-color: #f7f9fc;
}

table td a {
    text-decoration: none;
    font-size: 0.85rem;
    font-weight: 600;
    margin-right: 12px;
    padding: 5px 10px;
    border-radius: 6px;
}

table td a[href*="Modif"],
table td a[href*="modif"] {
    color: #2c4a7c;
    background-color: #e8edf5;
}
table td a[href*="Modif"]:hover,
table td a[href*="modif"]:hover {
    background-color: #d5deed;
}

table td a[href*="supp"],
table td a[href*="Supp"] {
    color: #b3261e;
    background-color: #fbe9e8;
}
table td a[href*="supp"]:hover,
table td a[href*="Supp"]:hover {
    background-color: #f6d3d1;
}

/* ===== FOOTER ===== */
footer {
    width: 100%;
    height: 50px;
    background-color: white;
    border-top: 1px solid #e0e0e0;
    position: fixed;
    bottom: 0;
    left: 0;
    text-align: center;
    padding-top: 15px;
    font-size: 0.85rem;
    color: #666;
}

@media (max-width: 600px) {
    fieldset, table {
        width: 92%;
    }
}
	

</style>
<body>
	<%@ include file="/WEB-INF/menu.jsp" %>

	<section class="hero">
		<h1>Bienvenue sur la Plateforme de Gestion du Tribunal</h1>
		<p>
			Gérez efficacement les dossiers judiciaires, les audiences, les affaires
			et les intervenants du tribunal, le tout depuis une interface simple et centralisée.
		</p>
	</section>

	<section class="features">
		<a href="Enregistreraffaire" class="card">
			<div class="icon">⚖️</div>
			<h3>Affaires</h3>
			<p>Enregistrer et consulter <br>
			 les affaires judiciaires.</p>
		</a>
		<a href="Enregistrermagistrat" class="card">
			<div class="icon">👨‍⚖️</div>
			<h3>Magistrats</h3>
			<p>Gérer la liste des <br> 
			magistrats du tribunal.</p>
		</a>
		<a href="Enregistrerpartie" class="card">
			<div class="icon">👥</div>
			<h3>Parties</h3>
			<p>Enregistrer les parties <br> 
			concernées par une affaire.</p>
		</a>
		<a href="Enregistrerparticiper" class="card">
			<div class="icon">📋</div>
			<h3>Participer</h3>
			<p>Associer une partie à <br>
			une affaire et son rôle.</p>
		</a>
	</section>

	<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>
