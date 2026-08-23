<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://googleapis.com" rel="stylesheet">
    <link rel="stylesheet" href="https://cloudflare.com">
<title>Connexion</title>
</head>
<style>
	/* Thème Justice et Tribunal de la République du Mali */
:root {
    --bg-gradient: linear-gradient(135deg, #071912 0%, #0d2836 100%); /* Vert et bleu nuit profonds */
    --card-bg: rgba(255, 255, 255, 0.05);
    --card-border: rgba(255, 255, 255, 0.08);
    --primary-gold: #fccb45; /* Jaune Or national pour le bouton et les focus */
    --accent-green: #008751; /* Vert de la République */
    --text-main: #ffffff;
    --text-muted: #94a3b8;
    --input-bg: rgba(15, 23, 42, 0.6);
}


* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Inter', sans-serif;
}

body {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background: linear-gradient(135deg, #071912 0%, #0d2836 100%);
    padding: 20px;
    overflow-x: hidden;
}

/* Conteneur principal (Effet Glassmorphism moderne) */
.login-container {
    width: 100%;
    max-width: 450px;
    background: rgba(255, 255, 255, 0.05);
    border: 1px solid rgba(255, 255, 255, 0.08);
    backdrop-filter: blur(16px);
    -webkit-backdrop-filter: blur(16px);
    border-radius: 24px;
    padding: 40px;
    box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
    animation: fadeIn 0.6s ease-out;
}

/* En-tête */
.login-header {
    text-align: center;
    margin-bottom: 35px;
}

.logo-icon {
    font-size: 2rem;
    color: #fccb45;
    margin-bottom: 15px;
    display: inline-block;
    background: rgba(0, 135, 81, 0.25); /* Fond vert républicain transparent */
    padding: 15px;
    border-radius: 50%;
    border: 1px solid rgba(252, 203, 69, 0.3); /* Liseré doré */
}


.login-header h1 {
    color:  #ffffff;
    font-size: 1.75rem;
    font-weight: 600;
    letter-spacing: -0.5px;
    margin-bottom: 8px;
}

.login-header p {
    color: #94a3b8;
    font-size: 0.9rem;
    line-height: 1.4;
}

/* Groupes de saisie */
.login-form .input-group {
    margin-bottom: 20px;
}

.login-form label {
    display: block;
    color: #ffffff;
    font-size: 0.85rem;
    font-weight: 500;
    margin-bottom: 8px;
    text-transform: uppercase;
    letter-spacing: 0.5px;
}

.input-wrapper {
    position: relative;
    display: flex;
    align-items: center;
}

.input-icon {
    position: absolute;
    left: 16px;
    color: #94a3b8;
    font-size: 1.1rem;
    pointer-events: none;
    transition: color 0.3s;
}

.input-wrapper input {
    width: 100%;
    padding: 14px 16px 14px 48px;
    background: rgba(15, 23, 42, 0.6);
    border: 1px solid rgba(255, 255, 255, 0.08);
    border-radius: 12px;
    color: #ffffff;
    font-size: 0.95rem;
    outline: none;
    transition: all 0.3s ease;
}

/* États Focus */
.input-wrapper input:focus {
    border-color: #fccb45;
    box-shadow: 0 0 0 3px rgba(197, 168, 128, 0.15);
}

.input-wrapper input:focus + .input-icon {
    color: #fccb45;
}

/* Options */
.form-options {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 30px;
    font-size: 0.85rem;
}

.remember-me {
    color: #94a3b8;
    display: flex;
    align-items: center;
    gap: 8px;
    cursor: pointer;
    text-transform: none !important;
}

.remember-me input {
    accent-color: #fccb45;
}

.forgot-pass {
    color: #fccb45;
    text-decoration: none;
    transition: opacity 0.3s;
}

.forgot-pass:hover {
    text-decoration: underline;
}

/* Bouton de validation */
.btn-submit {
    width: 100%;
    padding: 16px;
    background: #fccb45;
    border: none;
    border-radius: 12px;
    color: #0f172a;
    font-size: 1rem;
    font-weight: 600;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    transition: all 0.3s ease;
}

.btn-submit:hover {
    transform: translateY(-2px);
    box-shadow: 0 8px 20px rgba(197, 168, 128, 0.3);
    background: #d4bda1;
}

.btn-submit:active {
    transform: translateY(0);
}

/* Animation d'apparition */
@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}
	

</style>
<body>
	
    <div class="login-container">
        <!-- Section Header avec votre message d'accueil -->
        <div class="login-header">
            <div class="logo-icon">
                <i class="fa-solid fa-scale-balanced"></i>
            </div>
            <h1>Bonjour Administrateur</h1>
            <p>Veuillez vous identifier pour accéder au système de gestion du tribunal.</p>
        </div>

        <!-- Formulaire de saisie -->
        <form action="Accueil.jsp" method="POST" class="login-form">
            
            <!-- Champ Nom -->
            <div class="input-group">
                <label for="nom">Nom</label>
                <div class="input-wrapper">
                    <i class="fa-regular fa-user input-icon"></i>
                    <input type="text" id="nomuser" name="nomuser" placeholder="Entrez votre nom" required>
                </div>
            </div>

            <!-- Champ Prénom -->
            <div class="input-group">
                <label for="prenom">Prénom</label>
                <div class="input-wrapper">
                    <input type="text" id="prenomuser" name="prenomuser" placeholder="Entrez votre prénom" required>
                </div>
            </div>

            <!-- Champ Mot de passe -->
            <div class="input-group">
                <label for="password">Mot de passe</label>
                <div class="input-wrapper">
                    <input type="password" id="motdepasse" name="motdepasse" placeholder="••••••••" required>
                </div>
            </div>
            <button type="submit" class="btn-submit">
                <span>Se connecter</span>
            </button>
        </form>
    </div>
</body>
</html>