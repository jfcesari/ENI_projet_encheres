<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<%@ include file="../html/entete.html" %>

	<h1 class="text-center">Liste des enchères</h1>

	<form action="<%=request.getContextPath()%>/ServletAccueil" method="post">
		<ul>
			<li>
				<label class="txtLabel" for="recherche">Filtrer :</label>
				<input class="champs" type="text" id="recherche" name="recherche" placeholder="Le nom de l'article contient..."/> <!-- L'identifiant peut être le mail ou le pseudo -->
				<button class="" type="submit">Rechercher</button>
			</li>
			<li>
				<label class="txtLabel" for="categorie">Catégories</label>
				<input class="champs" type="text" id="categorie" name="categorie"/> <!-- Paramétrer le fait que le mdp apparaisse en * -->
			</li>
		</ul>
	
	</form>
	
	
	
</body>
</html>