<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<h1>Enchères en cours</h1>

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
		
		
		<form action="<%=request.getContextPath()%>/ServletAccueil" method="post">
			<div>
				<input type="radio" id="achats" name="filtre" value="1"  disabled="disable()"/>
				<label class="txtLabel" for="achats">Achats</label>
			
				<ul>
					<li>
						<label class="txtCheckbox" for="filtreCheckbox">
						<input type="checkbox" id="encheresEnCours" value="1"/>
						Enchères en cours</label>
					</li>
					
					<li>
						<label class="txtCheckbox" for="filtreCheckbox">
						<input type="checkbox" id="encheresEnCours" value="2"/>
						Mes enchères en cours</label>
					</li>
					
					<li>
						<label class="txtCheckbox" for="filtreCheckbox">
						<input type="checkbox" id="encheresEnCours" value="3"/>
						Mes enchères remportées</label>
					</li>
				</ul>
			</div>
			
			<div>
				<input type="radio" id="ventes" name="filtre" value="2"/>
				<label class="txtLabel" for="ventes">Mes ventes</label>
			
				<ul>
					<li>
						<label class="txtCheckbox" for="filtreCheckbox">
						<input type="checkbox" id="ventesEnCours" value="1"/>
						Mes ventes en cours</label>
					</li>
					
					<li>
						<label class="txtCheckbox" for="filtreCheckbox">
						<input type="checkbox" id="encheresEnCours" value="2"/>
						Enchères non débutées</label>
					</li>
					
					<li>
						<label class="txtCheckbox" for="filtreCheckbox">
						<input type="checkbox" id="encheresEnCours" value="3"/>
						Ventes terminées</label>
					</li>
				</ul>
			</div>
			
			<script>
				function disable() {
  					document.getElementById("ventesEnCours").disabled = true;
				}
			</script>
			
	
		<!--<c:if test="${isConnected}">-->	
			
		<!--</c:if>-->
		
	</form>
	</section>
	
	
</body>
</html>