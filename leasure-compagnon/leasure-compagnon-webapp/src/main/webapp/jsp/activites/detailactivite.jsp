<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<%@ include file="../_include/head.jsp"%>
		
  		<!-- Chargement du CDN CSS de la bibliothèque Leaflet (pré-requis pour les cartes OpenStreetMap). --> 
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css"/>
							
	</head>
	<body>
		<div class="container">
			<!-- Header -->
			<%@ include file="../_include/header.jsp"%>
			
			<!-- Chargement du CDN JS de la bibliothèque Leaflet (pré-requis pour les cartes OpenStreetMap). -->
			<script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js"></script>		
	
			<section id="section-activite">
				<h1 class="text-center">
					<s:property value="activiteAppliWeb.activite.nomActivite" />
				</h1>
				
				<!-- Description et photos de l'activité -->
				<h2 id="titre-description-activite">Description de l'activité</h2>
				<div class="row" id="row-activite">															
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5 text-justify">
						<p id="para-description-activite"><s:property value="activiteAppliWeb.activite.description"/></p>	
					</div>
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-7">
						<div class="row">
							<s:iterator value="activiteAppliWeb.activite.listPhotoActivite" status="rowstatus">
								<s:if test="#rowstatus.first">
									<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8" id="photo-principale-activite">
										<a data-toggle="modal" href="#modal-dialog-photo"><img src="<s:property value="nomPhoto"/>" alt="Photo principale activité" class="img-responsive"/></a>
									</div>
								 </s:if>
								 <s:else>
									<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4" id="photo-annexe-activite">
										<a data-toggle="modal" href="#modal-dialog-photo"><img src="<s:property value="nomPhoto"/>" alt="Photo annexe Activité" class="img-responsive"/></a>
									</div>							 
								 </s:else>						
							</s:iterator>					
						</div>																								
					</div>																					
				</div>
				
				<!-- Boîte de dialogue modale permettant d'afficher les photos de l'activités au premier plan -->
				<div class="modal fade" id="modal-dialog-photo">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">x</button>
								<h4 class="modal-title text-center">Photos de l'activité</h4>
							</div>
							<div class="modal-body">
								<!-- Carroussel intégré dans la boîte de dialogue modale. -->
								<div id="carousel" class="carousel slide" data-ride="carousel">
							 		<div class="carousel-inner">
										<s:iterator value="activiteAppliWeb.activite.listPhotoActivite" status="rowstatus">
											<s:if test="#rowstatus.first">
					    						 <div class="item active"><img src="<s:property value="nomPhoto"/>" alt="Photo principale activité" class="img-responsive"/></div>
								      		</s:if>
								      		<s:else>
								      			<div class="item"><img src="<s:property value="nomPhoto"/>" alt="Photo annexe activité" class="img-responsive"/></div>
								      		</s:else>
							      		</s:iterator>								 
								 	</div>
									<a class="left carousel-control" href="#carousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
									<a class="right carousel-control" href="#carousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>																	      	
						      	</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Localisation du lieu de l'activité avec utilisation de l'API OpenStreetMap. -->
				<h2 id="localisation-activite">Localisation de l'activité</h2>	
				<s:hidden id="latitude-activite" name="latitude" label="Latitude" />
				<s:hidden id="longitude-activite" name="longitude" label="Longitude" />
																						
				<div class="row" id="row-localisation-activite">	
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">				
						<!-- Ici s'affichera la carte OpenStreetMap suite au traitement effectué ci-dessous en Javascript. -->
						<div id="map-localisation-activite">					
						</div>		
					</div>
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-7" id="description-localisation-activite">
						<s:if test="%{activiteAppliWeb.activite.adresse!=null}">
							<p class="text-justify">Adresse : <s:property value="activiteAppliWeb.activite.adresse"/></p>
						</s:if>
						<p class="text-justify">Code Postal : <s:property value="activiteAppliWeb.activite.ville.codePostal"/></p>
						<p class="text-justify">Ville : <s:property value="activiteAppliWeb.activite.ville.nomVille"/></p>												
						<p class="text-justify">Département : <s:property value="activiteAppliWeb.activite.ville.departement.nomDepartement"/></p>
						<p class="text-justify">Région : <s:property value="activiteAppliWeb.activite.ville.departement.region.nomRegion"/></p>
						<p class="text-justify">Pays : <s:property value="activiteAppliWeb.activite.ville.departement.region.pays.nomPays"/></p>								
					</div>				
				</div>
				
				<!-- Informations pratiques au sujet de l'activité. -->
				<h2 id="infos-pratiques-activite">Informations pratiques</h2>					
				<div class="row" id="row-infos-pratiques-activite">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-justify">
						<s:if test="%{activiteAppliWeb.activite.lienHoraireOuverture!=null}">
							<p><a href="<s:property value="activiteAppliWeb.activite.lienHoraireOuverture"/>" target="_blank">Horaires d'ouverture</a></p>
						</s:if>
						<s:else>
							<p>Pas d'horaires disponibles pour cette activité.</p>
						</s:else>
						<s:if test="%{activiteAppliWeb.activite.duree.dureeConseillee!='Non applicable'}">
							<p>Durée conseillée : <s:property value="activiteAppliWeb.activite.duree.dureeConseillee"/></p>
						</s:if>
						<s:else>
							<p>Pas de durée conseillée pour cette activité.</p>
						</s:else>
						<p>Saison conseillée : <s:property value="activiteAppliWeb.activite.saison.nomSaison"/></p>					
					</div>			
				</div>
								
				<!-- Avis des utilisateurs au sujet de l'activité -->
				<h2 id="avis-activite">
					Avis
					<s:if test="%{activiteAppliWeb.nombreAvis!=0}">
						<span id="appreciation-moyenne-activite">											
							<s:if test="%{activiteAppliWeb.appreciationMoyenneDouble>=4.5}">
								<img src="jsp/assets/images/notation/notation_5_etoiles_petit_format.png" alt ="Image notation 5 étoiles">
							</s:if>
							<s:elseif test="%{activiteAppliWeb.appreciationMoyenneDouble>=4.0 && appreciationMoyenneDouble<4.5 }">
								<img src="jsp/assets/images/notation/notation_4_etoiles_petit_format.png" alt ="Image notation 4 étoiles">
							</s:elseif>
							<s:elseif test="%{activiteAppliWeb.appreciationMoyenneDouble>=3.5 && appreciationMoyenneDouble<4.0 }">
								<img src="jsp/assets/images/notation/notation_4_etoiles_petit_format.png" alt ="Image notation 4 étoiles">
							</s:elseif>											
							<s:elseif test="%{activiteAppliWeb.appreciationMoyenneDouble>=3.0 && appreciationMoyenneDouble<3.5 }">
								<img src="jsp/assets/images/notation/notation_3_etoiles_petit_format.png" alt ="Image notation 3 étoiles">
							</s:elseif>
							<s:elseif test="%{activiteAppliWeb.appreciationMoyenneDouble>=2.5 && appreciationMoyenneDouble<3.0 }">
								<img src="jsp/assets/images/notation/notation_3_etoiles_petit_format.png" alt ="Image notation 3 étoiles">
							</s:elseif>
							<s:elseif test="%{activiteAppliWeb.appreciationMoyenneDouble>=2.0 && appreciationMoyenneDouble<2.5 }">
								<img src="jsp/assets/images/notation/notation_2_etoiles_petit_format.png" alt ="Image notation 2 étoiles">
							</s:elseif>											
							<s:elseif test="%{activiteAppliWeb.appreciationMoyenneDouble>=1.5 && appreciationMoyenneDouble<2.0 }">
								<img src="jsp/assets/images/notation/notation_2_etoiles_petit_format.png" alt ="Image notation 2 étoiles">
							</s:elseif>
							<s:else>
								<img src="jsp/assets/images/notation/notation_1_etoile_petit_format.png" alt ="Image notation 1 étoiles">
							</s:else>	
						</span>	
					</s:if>	
					<s:a class="btn btn-success btn-sm pull-right" action="page_ajout_avis">
						<s:param name="activiteId" value="activiteAppliWeb.activite.id"></s:param>
						<s:param name="nomActivite" value="activiteAppliWeb.activite.nomActivite"></s:param>
						Rédiger un avis
					</s:a>														
				</h2>
				<s:if test="%{activiteAppliWeb.nombreAvis!=0}">
					<s:iterator value="activiteAppliWeb.activite.listAvis">
						<div class="row" id="row-avis-activite">						
							<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
								<s:if test="%{utilisateur.photoUtilisateur!=null}">
									<p class="text-center"><img src="<s:property value="utilisateur.photoUtilisateur.nomPhoto"/>" alt="Photo profil utilisateur" width=100px height=100px class="img-avis-activite-util"/></p>
								</s:if>
								<s:else>
									<p class="text-center">
										<s:if test="%{utilisateur.civilite=='Monsieur'}">
											<img src="jsp/assets/images/utilisateur/avatar_profil_homme_anonyme.png" alt="Photo utilisateur anonyme" width=100px height=100px class="img-avis-activite-util"/>
										</s:if>
										<s:else>
											<img src="jsp/assets/images/utilisateur/avatar_profil_femme_anonyme.png" alt="Photo utilisateur anonyme" width=100px height=100px  class="img-avis-activite-util"/>
										</s:else>
									<p>
								</s:else>							
								<p class="text-center"><s:property value="utilisateur.pseudo"/></p>
							</div>					
							<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10 text-justify">										
								<p id="appreciation-activite-utilisateur">
									<s:if test="%{appreciation=='Excellent'}">
										<img src="jsp/assets/images/notation/notation_5_etoiles_petit_format.png" alt ="Image notation 5 étoiles">
									</s:if>
									<s:elseif test="%{appreciation=='Très bon'}">
										<img src="jsp/assets/images/notation/notation_4_etoiles_petit_format.png" alt ="Image notation 4 étoiles">
									</s:elseif>
									<s:elseif test="%{appreciation=='Bon'}">
										<img src="jsp/assets/images/notation/notation_3_etoiles_petit_format.png" alt ="Image notation 3 étoiles">
									</s:elseif>
									<s:elseif test="%{appreciation=='Moyen'}">
										<img src="jsp/assets/images/notation/notation_2_etoiles_petit_format.png" alt ="Image notation 2 étoiles">
									</s:elseif>
									<s:else>
										<img src="jsp/assets/images/notation/notation_1_etoile_petit_format.png" alt ="Image notation 1 étoile">
									</s:else>
								</p>							
								<p><s:property value="commentaire"/></p>												
							</div>						
						</div>
					</s:iterator>
				</s:if>
				<s:else>
				Aucun avis sur cette activité pour le moment.
				</s:else>
				
				<!-- Traitement effectué en Javascript lié à l'affichage de la carte OpenStreetMap. -->
				<script type="text/javascript">
					//On récupère les valeurs de la latitude et de la longitude de l'activité.
					var latElt=document.getElementById("latitude-activite");
					var longElt=document.getElementById("longitude-activite");
					
					console.log("Latitude : "+latElt.value);
					console.log("Longitude : "+longElt.value);
					
					// On initialise la latitude et la longitude de l'activité choisie.
					var lat = latElt.value;
					var lon = longElt.value;
					var macarte = null;
					// Fonction d'initialisation de la carte
					function initMap() {
						// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
		                macarte = L.map('map-localisation-activite').setView([lat, lon], 11);
		                // Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
		                L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
		                    // Il est toujours bien de laisser le lien vers la source des données
		                    attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
		                    minZoom: 1,
		                    maxZoom: 20
		                }).addTo(macarte);
		             	// Nous ajoutons un marqueur
		                var marker = L.marker([lat, lon]).addTo(macarte);
		            }
					window.onload = function(){
						// Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
						initMap(); 
					};
				</script>																													
			</section>
	
			<!-- Footer -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>
