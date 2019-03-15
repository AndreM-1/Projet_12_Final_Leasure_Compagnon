<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<%@ include file="../_include/head.jsp"%>
	</head>
	<body>
		<div class="container">
			<!-- Header -->
			<%@ include file="../_include/header.jsp"%>
		
			<section>
				<!-- Formulaire de contact -->
				<div class="row" id="row-form-contact">
					<div class="col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6" id="div-form-contact">
						<h1 class="text-center">Formulaire de contact</h1>
						<s:form action="page_formulaire_contact" method="POST">
							<s:actionerror/>
							<s:hidden name="validationFormulaire" label="Validation Formulaire" />
							<s:if test="#session.user">
								<s:textfield name="#session.user.pseudo" label="Nom ou Pseudo" requiredLabel="true"/>
							</s:if>
							<s:else>
								<s:textfield name="nomNa" label="Nom ou Pseudo" requiredLabel="true"/>
							</s:else>
					        <div class="row">
						        <div class="col-md-6 col-lg-6">
						        	<s:if test="#session.user">
						        		<s:textfield name="#session.user.adresseMail" label="Adresse e-mail" requiredLabel="true"/>
						        	</s:if>
						        	<s:else>
						        		<s:textfield name="adresseMailNa" label="Adresse e-mail" requiredLabel="true"/>
						        	</s:else>
								</div>
								 <div class="col-md-6 col-lg-6">
									<s:select headerKey="-1" headerValue="Sélectionner un objet" name="objet" label="Objet" list="#{'Contacter l’administrateur':'Contacter l’administrateur','Remonter un bug':'Remonter un bug',
									'Proposer une amélioration':'Proposer une amélioration','Proposer une nouvelle catégorie':'Proposer une nouvelle catégorie','Autre':'Autre'}"
								  	emptyOption="false" requiredLabel="true" value="objet" />
								</div>
						  	</div>
					      	<s:textarea name="message" class="form-control" rows="4" label="Votre message" requiredLabel="true"/>
							<s:submit value="Envoyer le formulaire" class="btn btn-success"/>
			 			</s:form>	
		 			</div>
				</div>
			</section>
			
			<!-- Pied de page -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>