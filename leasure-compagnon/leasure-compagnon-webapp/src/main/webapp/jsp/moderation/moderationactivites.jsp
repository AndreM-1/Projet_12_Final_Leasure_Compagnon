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
						<s:a action="moderation_activite">Activités en attente de modération</s:a>
						<s:a action="moderation_activite_avis"><img src="jsp/assets/images/fleche_retour_bleu.png" alt ="Image flèche retour" class="pull-right" ></s:a>
					</h1>
					<s:actionmessage/>
					
					<!-- Section permettant d'afficher la liste des activités en cours de modération -->
					<s:iterator value="listActivite">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h2 class="panel-title">
											<s:property value="utilisateur.pseudo"/> a ajouté une activité le <s:property value="dateDemandeAjout"/>
										</h2>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-3 col-lg-3">
												<s:iterator value="listPhotoActivite" begin="0" end="0">
													<img src="<s:property value="nomPhoto"/>" alt="Photo principale de l'activité" class="img-responsive"/>
												</s:iterator>									
											</div>
											<div class="col-xs-8 col-sm-8 col-md-9 col-lg-9">
												<p>Nom de l'activité : <s:property value="nomActivite"/></p>
												<p id="adresse-moderation-activite">
													<s:if test="%{adresse!=null}">
														Adresse : <s:property value="adresse"/>
													</s:if>
													<s:else>
														Aucune adresse spécifiée par l'utilisateur.
													</s:else>
												</p>
												<p id="code-postal-moderation-activite">Code Postal : <s:property value="ville.codePostal"/></p>
												<p id="ville-moderation-activite">Ville : <s:property value="ville.nomVille"/></p>										
											</div>						
										</div>
										<div class="row" id="bloc-visu-detail-activite-moderation">
											<div class="col-xs-offset-2 col-xs-8 col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4 col-lg-offset-4 col-lg-4">
												<s:a class="btn btn-primary btn-block" action="page_detail_activite_moderation_admin">
													<s:param name="activiteId" value="id"></s:param>
													Visualiser le détail de l'activité
												</s:a> 
											</div>																								
										</div>						
									</div>	
								</div>
							</div>
			 			</div>		
			 		</s:iterator>							
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