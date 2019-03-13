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
							<span id="pseudo-utilisateur"><s:property value="pseudo"/></span>
						</div>
					</div>					
				
				
					<!-- Menu de navigation -->
					<nav id="nav-profil-utilisateur">
						<ul>
							<li><s:a action="page_utilisateur_coord">Mes coordonnées</s:a></li>
							<li><s:a action="page_utilisateur_mdp">Mon mot de passe</s:a></li>
							<li><s:a action="page_utilisateur_activites_avis">Activités et avis</s:a></li>
							<li><s:a action="page_utilisateur_param" id="mes-parametres">Paramètres</s:a></li>
						</ul>
					</nav>
					<s:actionerror />
					<s:actionmessage/>
		
					<!-- Section permettant à l'utilisateur de changer ses paramètres -->
					<s:form id="form-utilisateur-param" action="page_utilisateur_param" method="POST">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<s:hidden name="id" label="Id" />
								<s:hidden name="pseudo" label="Pseudo" />
								<s:hidden name="nomPhoto" label="Nom photo" />
								<s:hidden name="civilite" label="Civilite" />							
								<s:hidden name="validationFormulaire" label="Validation Formulaire" />
							 	<s:checkbox type="checkbox" name="envoiMailInformatif" label="Activer/désactiver l'option de réception de mails informatifs" /> 
					 		</div>
					 	</div>
					 	<div class="row">
					 		<div class="col-xs-4 col-sm-3 col-md-3 col-lg-3">
					 			<s:submit value="Confirmer" class="btn btn-success btn-block"/>
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