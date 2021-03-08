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

	<h1>Créer mon profil</h1>
	
	<form action="<%=request.getContextPath()%>" method="post"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label class="txtLabel" for="pseudo">Pseudo :</label>
				<input class="champs" type="text" id="pseudo" name="pseudo"/>
			</li>
			<li>
				<label class="txtLabel" for="nom">Nom :</label>
				<input class="champs" type="text" id="nom" name="nom"/>
			</li>
			<li>
				<label class="txtLabel" for="prenom">Prénom :</label>
				<input class="champs" type="text" id="prenom" name="prenom"/>
			</li>
			<li>
				<label class="txtLabel" for="email">Email :</label>
				<input class="champs" type="email" id="email" name="email"/>
			</li>
			<li>
				<label class="txtLabel" for="telephone">Téléphone :</label>
				<input class="champs" type="text" id="telephone" name="telephone"/>
			</li>
			<li>
				<label class="txtLabel" for="rue">Rue :</label>
				<input class="champs" type="text" id="rue" name="rue"/>
			</li>
			<li>
				<label class="txtLabel" for="codePostal">Code postal :</label>
				<input class="champs" type="text" id="codePostal" name="codePostal"/>
			</li>
			<li>
				<label class="txtLabel" for="ville">Ville :</label>
				<input class="champs" type="text" id="ville" name="ville"/>
			</li>
			<li>
				<label class="txtLabel" for="motDePasse">Mot de passe :</label>
				<input class="champs" type="password" id="motDePasse" name="motDePasse"/>
			</li>
			<li>
				<label class="txtLabel" for="confirmationMotDePasse">Confirmation :</label>
				<input class="champs" type="password" id="confirmationMotDePasse" name="confirmationMotDePasse"/>
			</li>
		</ul>
			
	</form>

	<a href="<%=request.getContextPath()%>/ServletConnexion"><button>Annuler</button></a>
			
	<button type="submit">Créer</button>
		

</body>
</html>