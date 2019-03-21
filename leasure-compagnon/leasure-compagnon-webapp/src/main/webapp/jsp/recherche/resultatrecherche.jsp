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
				<h1 class="text-center">Résultat de la recherche</h1>
				
				<!-- Résultat de la recherche pour les villes. -->
				<h2 id="titre-resultat-recherche-ville">Ville</h2>
				<s:property value="messageInformatifVille"/>
				<s:iterator value="listVille">
					<div class="row" id="row-resultat-recherche-ville">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" id="resultat-recherche-ville">															
							<!-- Les images doivent être responsives. Pour cela : 
					     	- Il ne faut surtout pas leur imposer une taille.
					     	- Les images doivent avoir les mêmes dimensions. C'est un pré-requis indispensable.
					     	- Il faut par contre bien mettre l'image dans une balise div qui applique les classes de type col-*-*
				     		- Il faut appliquer la classe img-responsive directement au niveau de l'image. -->
							<div class="col-xs-6 col-sm-5 col-md-5 col-lg-5">
								<img src="<s:property value="photoVille.nomPhoto"/>" alt="Photo Ville" class="img-responsive"/>
							</div>									
							<div class="col-xs-6 col-sm-7 col-md-7 col-lg-7 text-justify">
								<p>
									<s:a action="page_activites_ville">
										<s:param name="villeId" value="id"/>
										<s:param name="nomVille" value="nomVille"/>
										<s:property value="nomVille"/>
									</s:a>
								</p>
								<p class="resultat-recherche-hide">Code postal : <s:property value="codePostal"/></p>
								<p><span class="resultat-recherche-hide">Département : </span><s:property value="departement.nomDepartement"/></p>
							</div>										
						</div>						
					</div>
				</s:iterator>
				
				<!-- Résultat de la recherche pour les activités. -->
				<h2 id="titre-resultat-recherche-activite">Activités</h2>
				<s:property value="messageInformatifActivite"/>
				<s:iterator value="listActiviteAppliWeb">
					<div class="row" id="row-resultat-recherche-activite">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6" id="resultat-recherche-activite">	
							<!-- Les images doivent être responsives. Pour cela : 
					     	- Il ne faut surtout pas leur imposer une taille.
					     	- Les images doivent avoir les mêmes dimensions. C'est un pré-requis indispensable.
					     	- Il faut par contre bien mettre l'image dans une balise div qui applique les classes de type col-*-*
				     		- Il faut appliquer la classe img-responsive directement au niveau de l'image. -->
							<div class="col-xs-6 col-sm-5 col-md-5 col-lg-5">
								<img src="<s:property value="nomPhotoPrincipale"/>" alt="Photo principale activité" class="img-responsive" />	
							</div>	
							<div class="col-xs-6 col-sm-7 col-md-7 col-lg-7 text-justify">
								<p>
									<s:a action="page_detail_activite">
										<s:param name="activiteId" value="activite.id"></s:param>
										<s:property value="activite.nomActivite" />
									</s:a>
								</p>
								<s:if test="%{nombreAvis!=0}">
									<p class="text-justify">									
										<s:if test="%{appreciationMoyenneDouble>=4.5}">
											<img src="jsp/assets/images/notation/notation_5_etoiles.png" alt ="Image notation 5 étoiles" class="img-responsive">
										</s:if>
										<s:elseif test="%{appreciationMoyenneDouble>=4.0 && appreciationMoyenneDouble<4.5 }">
											<img src="jsp/assets/images/notation/notation_4_etoiles.png" alt ="Image notation 4 étoiles" class="img-responsive">
										</s:elseif>
										<s:elseif test="%{appreciationMoyenneDouble>=3.5 && appreciationMoyenneDouble<4.0 }">
											<img src="jsp/assets/images/notation/notation_4_etoiles.png" alt ="Image notation 4 étoiles" class="img-responsive">
										</s:elseif>											
										<s:elseif test="%{appreciationMoyenneDouble>=3.0 && appreciationMoyenneDouble<3.5 }">
											<img src="jsp/assets/images/notation/notation_3_etoiles.png" alt ="Image notation 3 étoiles" class="img-responsive">
										</s:elseif>
										<s:elseif test="%{appreciationMoyenneDouble>=2.5 && appreciationMoyenneDouble<3.0 }">
											<img src="jsp/assets/images/notation/notation_3_etoiles.png" alt ="Image notation 3 étoiles" class="img-responsive">
										</s:elseif>
										<s:elseif test="%{appreciationMoyenneDouble>=2.0 && appreciationMoyenneDouble<2.5 }">
											<img src="jsp/assets/images/notation/notation_2_etoiles.png" alt ="Image notation 2 étoiles" class="img-responsive">
										</s:elseif>											
										<s:elseif test="%{appreciationMoyenneDouble>=1.5 && appreciationMoyenneDouble<2.0 }">
											<img src="jsp/assets/images/notation/notation_2_etoiles.png" alt ="Image notation 2 étoiles" class="img-responsive">
										</s:elseif>
										<s:else>
											<img src="jsp/assets/images/notation/notation_1_etoile.png" alt ="Image notation 1 étoiles" class="img-responsive">
										</s:else>																																																												
									</p>
									<p class="text-justify resultat-recherche-hide">
										Nombre d'avis : <s:property value="nombreAvis" /> avis
									</p>
								</s:if>
								<s:else>
									<p class="text-justify resultat-recherche-hide">Pas d'avis disponibles pour le moment.</p>
								</s:else>								
							</div>																	
						</div>
					</div>
				</s:iterator>			
			</section>
			
			<!-- Footer -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>
