<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<title>Accueil</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>
	<%@ include file="menuNavigation.jspf" %>

	<h1 class="text-center">Enchères en cours</h1>

	<section class="filtre">
	<form action="<%=request.getContextPath()%>/ServletAccueil" method="post">
		<ul>
			<li>
				<label class="txtLabel" for="recherche">Filtrer ma recherche</label>
			</li>
			<li>
				<select name="categorie">
					<option value="toutesCategories">Toutes catégories</option>
					<option class="categorie" value="categorieInformatique">Informatique</option>
					<option class="categorie" value="categorieAmeublement">Ameublement</option>
					<option class="categorie" value="categorieVetement">Vêtement</option>
					<option class="categorie" value="categorieSport&Loisirs">Sport&Loisirs</option>
				</select>
				<input class="champs" type="search" id="recherche" name="recherche" placeholder="Le nom de l'article contient..."/> <!-- L'identifiant peut être le mail ou le pseudo -->
				<button class="btnRecherche" type="submit">Rechercher</button>
			</li>
		</ul>
	</form>
	</section>
	
	
	
</body>
</html>