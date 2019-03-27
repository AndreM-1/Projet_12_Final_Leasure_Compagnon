<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>

	<!-- Barre de navigation -->
	<nav class="navbar navbar-static-top" role="navigation" id="barre-navigation">
		<div class="container" id="container-barre-navigation">
		 	<div class="navbar-header">
				<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#recentrer" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- Le logo comprend l'image + le nom de l'application. Dans ce cas là, on peut utiliser la classe navbar-brand -->
				<s:a action="index" class="navbar-brand" id="logo">
					<img src="jsp/assets/images/logo_leasure_compagnon_1.png" alt="Logo Leasure Compagnon">
				</s:a>
		 	</div>
			<div class="navbar-collapse collapse" id="recentrer" aria-expanded="false">
				<ul class="nav navbar-nav navbar-right">
					<li><s:a action="page_generique_qsn">Qui sommes-nous?</s:a></li>
					<s:if test="#session.user">
						<li>
							<a class="btn btn-primary bouton-connexion dropdown-toggle" data-toggle="dropdown"><s:property value="#session.user.pseudo"/></a>
							<ul class="dropdown-menu">
								<li><s:a action="page_utilisateur_coord">Mes coordonnées</s:a></li>
								<li class="divider"></li>
								<li><s:a action="page_utilisateur_mdp">Mon mot de passe</s:a></li>
								<li class="divider"></li>
								<li><s:a action="page_utilisateur_activites_avis">Activités et avis</s:a></li>
								<li class="divider"></li>
								<li><s:a action="page_utilisateur_param">Mes Paramètres</s:a></li>
								<li class="divider"></li>
								<s:if test="#session.user.administrateur==true">
									<li><s:a action="visu_formulaire_contact">Formulaires de contact</s:a></li>
									<li class="divider"></li>
									<li><s:a action="moderation_activite_avis">Modération</s:a></li>
									<li class="divider"></li>
								</s:if>															
								<li><s:a action="deconnexion">Déconnexion</s:a></li>
							</ul>
						</li>
					</s:if>
					<s:else>
						<li><s:a action="connexion" class="btn btn-primary bouton-connexion">Connexion</s:a></li>
					</s:else>
					<li><s:a action="ajout_activite" class="btn btn-primary bouton-activite">Ajouter une activité</s:a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	
	
	<!-- Bannière image avec zone de recherche -->
	<div id="banniere-image">
		<div id="zone-recherche">
			<!-- Pas besoin de formulaire Struts ici. -->
			<form action="recherche_ville_activite" method="POST">
				<div class="input-group">
					<input id="zone-recherche-input" type="text" autocomplete="off" class="form-control input-lg" name="nomRecherche" placeholder="Recherche une ville ou une activité..."/>
					<span class="input-group-btn">
						<button class="btn btn-default btn-lg" type="submit"><span class="glyphicon glyphicon-search"></span></button>
					</span>				
				</div>	
				<div id="suggestions" class="input-group form-control input-lg"></div>		
			</form>
		</div>
	</div>
	

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

	<!-- Javascript de Bootstrap -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- Fichier Javascript pour les appels asynchrones -->
	<script src="js/ajax.js"></script>
	
	<script>	
		var listSuggestions;
		
		//URL de l'action struts
		var urlActionStruts = "<s:url action="appel_ajax_getListVilleActivite"/>";
		
		//Appel asynchrone pour récupérer la liste de l'ensemble des noms de villes et d'activités.
		ajaxGet(urlActionStruts, function(reponseActionStruts){
			console.log("Réponse du serveur JSON : "+reponseActionStruts);
			listSuggestions=JSON.parse(reponseActionStruts);
			console.log("Réponse du serveur JS: "+reponseActionStruts);
		});
		
		var zoneRechercheElt=document.getElementById("zone-recherche-input");
		var suggestionsElt=document.getElementById("suggestions");
		
		//On ajoute l'EventListener pour la saisie en temps réel.
		zoneRechercheElt.addEventListener("input",function(event){
			suggestionsElt.innerHTML="";
			var affichageSuggestions=false;
			var countNbElement=0;
			listSuggestions.forEach(function(suggestion){
				//On affiche au maximum 8 suggestions.
				if(event.target.value.length!==0 && suggestion.toLowerCase().indexOf(event.target.value.toLowerCase())!==-1 && countNbElement<8){
					suggestionsElt.style.visibility="visible";
					var divElt=document.createElement("div");
					divElt.classList.add("suggestion");
					divElt.textContent=suggestion;
					divElt.addEventListener("click",function(event1){
						zoneRechercheElt.value=divElt.textContent;
						suggestionsElt.innerHTML="";
						suggestionsElt.style.visibility="hidden";
					});
									
					suggestionsElt.appendChild(divElt);
					affichageSuggestions=true;
					countNbElement++;
				}
			});	
			if(!affichageSuggestions){
				suggestionsElt.style.visibility="hidden";
			}
		});
	</script>
</header>