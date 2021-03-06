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
						<s:a action="moderation_avis">Avis en attente de modération</s:a>
						<s:a action="moderation_activite_avis"><img src="jsp/assets/images/fleche_retour_bleu.png" alt ="Image flèche retour" class="pull-right" ></s:a>
					</h1>
					<s:actionmessage/>
					
					<!-- Section permettant d'afficher la liste des avis en cours de modération -->
					<s:iterator value="listAvis">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h2 class="panel-title">
											<s:property value="utilisateur.pseudo"/> a ajouté un avis le <s:property value="datePosteAvis"/>
										</h2>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p class ="text-justify" id="appreciation-utilisateur">Appréciation : </p>
												<p>
													<s:if test="%{appreciation=='Excellent'}">
														<img src="jsp/assets/images/notation/notation_5_etoiles.png" alt ="Image notation 5 étoiles">
													</s:if>
													<s:elseif test="%{appreciation=='Très bon'}">
														<img src="jsp/assets/images/notation/notation_4_etoiles.png" alt ="Image notation 4 étoiles">
													</s:elseif>
													<s:elseif test="%{appreciation=='Bon'}">
														<img src="jsp/assets/images/notation/notation_3_etoiles.png" alt ="Image notation 3 étoiles">
													</s:elseif>
													<s:elseif test="%{appreciation=='Moyen'}">
														<img src="jsp/assets/images/notation/notation_2_etoiles.png" alt ="Image notation 2 étoiles">
													</s:elseif>
													<s:else>
														<img src="jsp/assets/images/notation/notation_1_etoile.png" alt ="Image notation 1 étoile">
													</s:else>
												</p>																				
											</div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p class ="text-justify" id="commentaire-utilisateur">Commentaire : </p>
												<p class ="text-justify"><s:property value="commentaire"/></p>
											</div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="bloc-validation-refus-avis">
												<div class="row">
													<div class="col-xs-6 col-sm-offset-4 col-sm-2 col-md-offset-4 col-md-2 col-lg-offset-4 col-lg-2">
														<s:a class="btn btn-primary btn-block" action="validation_avis">
															<s:param name="avisId" value="id"></s:param>
															Valider
														</s:a> 
													</div>												
													<div class="col-xs-6 col-sm-2 col-md-2 col-lg-2">
														<s:a class="btn btn-primary btn-block" action="refus_avis">
															<s:param name="avisId" value="id"></s:param>
															Refuser
														</s:a> 
													</div>													
												</div>
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