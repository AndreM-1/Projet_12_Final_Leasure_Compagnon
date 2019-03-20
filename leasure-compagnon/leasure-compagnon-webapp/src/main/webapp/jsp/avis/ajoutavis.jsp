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
				<!-- Formulaire permettant d'ajouter un avis utilisateur. -->
				<div class="row" id="row-ajout-avis">
					<div class="col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6" id="div-ajout-avis">
						<h1 class="text-center">Ajouter un avis</h1>
						<s:form action="page_ajout_avis" method="POST">
							<s:actionerror />
							<s:hidden name="activiteId" label="Activité id" />
							<s:hidden name="nomActivite" label="Nom de l'activité" />
							<p><strong>Activité concernée : </strong></p>
							<p><s:property value="nomActivite"/></p>
							<s:select headerKey="-1" headerValue="Sélectionner une appréciation" name="appreciation" label="Appréciation" list="#{'Excellent':'Excellent','Très bon':'Très bon',
							'Bon':'Bon','Moyen':'Moyen','Déconseillé':'Déconseillé'}" emptyOption="false" requiredLabel="true" value="appreciation" />						
							<s:textarea name="commentaire" label="Commentaire" requiredLabel="true" rows="4" />
							<s:submit value="Ajouter un avis" class="btn btn-success" />
						</s:form>
					</div>
				</div>
			</section>

			<!-- Pied de page -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>