<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>
	
	<form action="" method="post"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label for="identifiant">Identifiant :</label>
				<input type="text" id="identifiant" name="identifiant"/> <!-- L'identifiant peut être le mail ou le pseudo -->
			</li>
			<li>
				<label for="motDePasse">Mot de passe :</label>
				<input type="text" id="motDePasse" name="motDePasse"/> <!-- Paramétrer le fait que le mdp apparaisse en * -->
			</li>
		</ul>
			
		<button type="submit">Connexion</button>
		
		<div class="checkbox">
			<label for="">
				<input type="checkbox" id="souvenirUtilisateur" name="souvenirUtilisateur" value=""/> <!-- Quelle valeur attribuer ? -->
				Se souvenir de moi
			</label>
		</div>
	
		<a href="">Mot de passe oublié</a> <!-- Vers quoi renvoit ce lien ? -->
		
	</form>

	
	
	<div class="button">
		<button onclick="">Créer un compte</button> <!-- Ajouter le lien vers la page de création du compte utilisateur -->
	</div>


</body>
</html>