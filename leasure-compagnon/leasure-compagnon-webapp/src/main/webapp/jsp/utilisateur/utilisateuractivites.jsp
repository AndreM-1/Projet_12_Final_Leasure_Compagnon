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
				
				
					<!-- Titre -->
					<h1 id="activites-avis-utilisateur">
						<s:a action="page_utilisateur_activites">Activités</s:a>
						<s:a action="page_utilisateur_activites_avis"><img src="jsp/assets/images/fleche_retour_bleu.png" alt ="Image flèche retour" class="pull-right" ></s:a>
					</h1>
					<s:actionerror />
					<s:actionmessage/>
		
					<!-- Section permettant d'afficher la liste des activités postées par l'utilisateur -->
					<div class="row">
						<s:iterator value="listActivite">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h2 class="panel-title">
											<s:property value="utilisateur.pseudo"/> a ajouté une activité le <s:property value="dateMiseEnLigne"/>
										</h2>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"><p><s:a action=""><s:property value="nomActivite"/></s:a></p></div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p><s:property value="adresse"/> <s:property value="ville.codePostal"/> <s:property value="ville.nomVille"/></p>
											</div>	
											<s:iterator value="listPhotoActivite">
												<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
													<img src="<s:property value="nomPhoto"/>" alt="Photo Activite" class="img-responsive"/>
												</div>
											</s:iterator>																
										</div>
									</div>	
								</div>
							</div>
						</s:iterator>
			 		</div>			
				</s:if>
			</section>
			
			<!-- Pied de page -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>