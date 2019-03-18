<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<%@ include file="_include/head.jsp"%>	
	</head>
	<body>
		<div class="container">
			<!-- Header -->
			<%@ include file="_include/header.jsp"%>
			
			<section>
				<s:iterator value="listVille" status="rowstatus">
					<div class="row accueil-ville">
						<s:if test="#rowstatus.odd == true">
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 text-justify">
								<p class="accueil-nom-ville">
									<s:a action="page_activites_ville">
										<s:param name="villeId" value="id"/>
										<s:param name="nomVille" value="nomVille"/>
										<s:property value="nomVille"/>
									</s:a>
								</p>
								<p class="accueil-description-ville"><s:property value="description"/></p>
							</div>
							<!-- Les images doivent être responsives. Pour cela : 
					     	- Il ne faut surtout pas leur imposer une taille.
					     	- Les images doivent avoir les mêmes dimensions. C'est un pré-requis indispensable.
					     	- Il faut par contre bien mettre l'image dans une balise div qui applique les classes de type col-*-*
				     		- Il faut appliquer la classe img-responsive directement au niveau de l'image. -->
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<img src="<s:property value="photoVille.nomPhoto"/>" alt="Photo Ville" class="img-responsive"/>
							</div>
						</s:if>
						<s:else>
							<!-- Les images doivent être responsives. Pour cela : 
					     	- Il ne faut surtout pas leur imposer une taille.
					     	- Les images doivent avoir les mêmes dimensions. C'est un pré-requis indispensable.
					     	- Il faut par contre bien mettre l'image dans une balise div qui applique les classes de type col-*-*
				     		- Il faut appliquer la classe img-responsive directement au niveau de l'image. -->
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
								<img src="<s:property value="photoVille.nomPhoto"/>" alt="Photo Ville" class="img-responsive"/>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 text-justify">
								<p class="accueil-nom-ville">
									<s:a action="page_activites_ville">
										<s:param name="villeId" value="id"/>
										<s:param name="nomVille" value="nomVille"/>
										<s:property value="nomVille"/>
									</s:a>
								</p>
								<p class="accueil-description-ville"><s:property value="description"/></p>
							</div>							
						</s:else>
					</div>
				</s:iterator>
			</section>
			
			<!-- Footer -->
			<%@ include file="_include/footer.jsp"%>
		</div>
	</body>
</html>
