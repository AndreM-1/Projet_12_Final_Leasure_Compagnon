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
				<s:if test="#session.user.administrateur==true">
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
				
					<!-- Titre -->
					<h1 id="titre-moderation-activites-avis">
						<s:a action="moderation_activite_avis">Modération des activités et des avis</s:a>
					</h1>
					
					<!-- Section permettant d'afficher les images correspondant aux activités et avis à modérer -->
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" id="div-activites">
							<div class="row">				
								<div class="col-xs-offset-2 col-xs-8 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">							
									<s:a action="moderation_activite">
										<img src="jsp/assets/images/img_activite_1.jpg" alt="Image activité" class="img-responsive" id="image-activites">
									</s:a>								
								</div>												
							</div>							
				 		</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" id="div-avis">
							<div class="row">				
								<div class="col-xs-offset-2 col-xs-8 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">																		
									<s:a action="moderation_avis">
										<img src="jsp/assets/images/img_avis_1.jpg" alt="Image avis" class="img-responsive" id="image-avis">
									</s:a>
								</div>												
							</div>																					
				 		</div>
				 	</div>								
				</s:if>
				<s:else>
					<h1 class="text-center">Vous n'avez pas accès à cette page.</h1>
				</s:else>					
			</section>
			
			<!-- Pied de page -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>