<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<%@ include file="../_include/head.jsp"%>
	</head>
	<body>
		<div class="container">
			<!-- Header -->
			<%@ include file="../_include/header.jsp"%>

			<section>
				<s:if test="#session.user">
					<!-- Photo et pseudo de l'utilisateur -->
					<div class="row">
						<div class="col-xs-offset-4 col-xs-4 col-sm-offset-4 col-sm-4 col-md-offset-4 col-md-4 col-lg-offset-4 col-lg-4 text-center">
							<s:a data-toggle="modal" href="#form-update-photo-utilisateur">
								<s:if test="%{nomPhoto!=null && nomPhoto!=''}">
									<img src="<s:property value="nomPhoto"/>" class="photo-profil-utilisateur" alt="Photo utilisateur" width=100px height=100px/>
								</s:if>
								<s:else>
									<s:if test="%{civilite=='Monsieur'}">
										<img src="jsp/assets/images/utilisateur/avatar_profil_homme_anonyme.png" class="photo-profil-utilisateur" 
										alt="Photo utilisateur anonyme" width=100px height=100px/>
									</s:if>
									<s:else>
										<img src="jsp/assets/images/utilisateur/avatar_profil_femme_anonyme.png"  class="photo-profil-utilisateur" 
										alt="Photo utilisateur anonyme" width=100px height=100px/>
									</s:else>
								</s:else>
							</s:a>				
							<span id="pseudo-utilisateur"><s:property value="pseudo"/></span>
						</div>
					</div>
					
					<div class="modal fade" id="form-update-photo-utilisateur">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
				              		<button type="button" class="close" data-dismiss="modal">x</button>
	         						<h4 class="modal-title text-center">Modifier la photo</h4>
								</div>
								<div class="modal-body">
									<s:form action="update_photo_util" method="POST" enctype="multipart/form-data">
										<p class="text-center"><label for="upload">Sélectionner une photo :</label></p>
										<s:hidden name="id" label="Utilisateur Id :"></s:hidden>
										<s:file name="fileUpload" id="upload"></s:file>	
										<div class="text-center">							
												<s:submit value="Valider" class="btn btn-success"/>
										</div>
									</s:form>
								</div>
							</div>
						</div>
					</div>						
					
							
					<!-- Menu de navigation -->
					<nav id="nav-profil-utilisateur">
						<ul>
							<li><s:a action="page_utilisateur_coord" id="mes-coordonnees">Mes coordonnées</s:a></li>
							<li><s:a action="page_utilisateur_mdp">Mon mot de passe</s:a></li>
							<li><s:a action="page_utilisateur_activites_avis">Activités et avis</s:a></li>
							<li><s:a action="page_utilisateur_param">Paramètres</s:a></li>
						</ul>
					</nav>
					<s:actionerror/>
		
		
					<!-- Section comportant les coordonnées de l'utilisateur sélectionné -->
					<s:form id="form-utilisateur-coord" action="page_utilisateur_coord" method="POST">
		
						<div class="row">
							<div class="col-md-6 col-lg-6">
								<s:hidden name="id" label="Id" />
								<s:hidden name="nomPhoto" label="Nom photo" />
								<s:hidden name="validationFormulaire" label="Validation Formulaire" />
								<div class="row">
									<div class="col-md-12 col-lg-12">
										<div class="row">
											<div class="col-md-4 col-lg-4">
												<s:select name="civilite" label="Civilité" list="#{'Monsieur':'Monsieur','Madame':'Madame'}"
													emptyOption="false" requiredLabel="true" value="civilite" />
											</div>
											<div class="col-md-8 col-lg-8">
												<s:textfield name="nom" label="Nom" requiredLabel="true" />
											</div>
										</div>
		
										<s:textfield name="prenom" label="Prénom" requiredLabel="true" />
										<s:textfield name="pseudo" label="Pseudo" requiredLabel="true" />
										<s:textfield name="adresseMail" label="Adresse e-mail" requiredLabel="true" />
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-6">
								<div class="row">
									<div class="col-md-12 col-lg-12">
										<s:textfield name="telephone" label="Téléphone (XX-XX-XX-XX-XX)" />
										<s:textfield name="dateNaissance" label="Date de naissance (JJ/MM/AAAA)" />
										<s:textfield name="adresse" label="Adresse" />
										<div class="row">
											<div class="col-md-4 col-lg-4">
												<s:textfield name="codePostal" label="Code Postal" />
											</div>
											<div class="col-md-4 col-lg-4">
												<s:textfield name="ville" label="Ville" />
											</div>
											<div class="col-md-4 col-lg-4">
												<s:textfield name="pays" label="Pays"/>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
		
						<div class="row">
							<div class="col-md-offset-5 col-md-2 col-lg-offset-5 col-lg-2">
								<s:submit value="Valider" class="btn btn-success btn-block" />
							</div>
						</div>
		
					</s:form>
				</s:if>
			</section>
			
			<!-- Pied de page -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>