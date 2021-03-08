<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<title>Création de compte</title>
</head>
<body>

<%@ include file="../html/entete.html" %>

	<h1>Mon profil</h1>
	
	<form action="<%=request.getContextPath()%>" method="post"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label for="pseudo">Pseudo :</label>
				<input class="champs" type="text" id="pseudo" name="pseudo"/>
			</li>
			<li>
				<label for="nom">Nom :</label>
				<input class="champs" type="text" id="nom" name="nom"/>
			</li>
			<li>
				<label for="prenom">Prénom :</label>
				<input class="champs" type="text" id="prenom" name="prenom"/>
			</li>
			<li>
				<label for="email">Email :</label>
				<input class="champs" type="email" id="email" name="email"/>
			</li>
			<li>
				<label for="telephone">Téléphone :</label>
				<input class="champs" type="text" id="telephone" name="telephone"/>
			</li>
			<li>
				<label for="rue">Rue :</label>
				<input class="champs" type="text" id="rue" name="rue"/>
			</li>
			<li>
				<label for="codePostal">Code postal :</label>
				<input class="champs" type="text" id="codePostal" name="codePostal"/>
			</li>
			<li>
				<label for="ville">Ville :</label>
				<input class="champs" type="text" id="ville" name="ville"/>
			</li>
			<li>
				<label for="motDePasse">Mot de passe :</label>
				<input class="champs" type="text" id="motDePasse" name="motDePasse"/>
			</li>
			<li>
				<label for="confirmationMotDePasse">Confirmation :</label>
				<input class="champs" type="text" id="confirmationMotDePasse" name="confirmationMotDePasse"/>
			</li>
		</ul>
			
		<button type="submit">Créer</button>
		
		<button onclick="">Annuler</button> <!-- Dois renvoyer à la page d'accueil -->
		
	</form>

</body>
</html>