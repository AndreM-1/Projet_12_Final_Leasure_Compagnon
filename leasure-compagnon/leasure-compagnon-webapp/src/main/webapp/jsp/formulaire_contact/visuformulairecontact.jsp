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
					<h1 id="visu-form-contact-utilisateur">
						<s:a action="visu_formulaire_contact">Formulaires de contact reçus</s:a>
					</h1>
		
					<!-- Section permettant d'afficher la liste des formulaires de contact reçues -->
					<div class="row">
						<s:iterator value="listFormulaireContact">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h2 class="panel-title">
											Message reçu le <s:property value="dateFormContact"/>
										</h2>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p class ="text-justify"> <span class="attr-form-contact">Nom ou Pseudo :</span> <s:property value="nomNa"/> <s:property value="utilisateur.pseudo"/> </p>											
											</div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p class ="text-justify"> <span class="attr-form-contact">Adresse Mail :</span> <s:property value="adresseMailNa"/> <s:property value="utilisateur.adresseMail"/> </p>											
											</div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p class ="text-justify"> <span class="attr-form-contact">Objet :</span> <s:property value="objet"/></p>											
											</div>
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
												<p class ="text-justify"> <span class="attr-form-contact">Message :</span> <s:property value="message"/></p>											
											</div>																																																							
										</div>
									</div>	
								</div>
							</div>
						</s:iterator>
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