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
				<!-- Formulaire permettant à l'utilisateur d'ajouter une activité. -->
				<div class="row" id="row-ajout-activite">
					<div class="col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6" id="div-ajout-activite">
						<h1 class="text-center">Ajouter une activité</h1>
						<s:form action="ajout_activite" method="POST" enctype="multipart/form-data">
							<s:actionerror />
							<div id="div-message-erreur" class="text-justify"></div>
							<s:hidden name="validationFormulaire" label="Validation Formulaire" />
							<!-- Section liée à la localisation. -->
							<h2>Localisation</h2>
							
							<s:select name="activite.ville.departement.region.pays.nomPays" label="Pays" list="#{'France':'France'}"
							emptyOption="false" requiredLabel="true"/>	
																								
							<s:select name="activite.ville.departement.region.nomRegion" label="Région" list="#{'Auvergne-Rhône-Alpes':'Auvergne-Rhône-Alpes'}"
							emptyOption="false" requiredLabel="true"/>								
							
							<s:select name="activite.ville.departement.nomDepartement" label="Département" list="#{'Haute-Savoie':'Haute-Savoie'}" 
							emptyOption="false" requiredLabel="true"/>							
						
							<s:select name="activite.ville" label="Ville" list="listVille" listKey="id" listValue="nomVille" requiredLabel="true"/>								
														
							<s:textfield name="activite.adresse" label="Adresse (100 caractères max)" placeholder="N° et nom de la rue" id="adresse-activite"/>
							
							<s:textfield name="latitude" label="Latitude du lieu de l'activité" placeholder="Ex : 45.900696" requiredLabel="true" id="latitude-activite"/>
							
							<s:textfield name="longitude" label="Longitude du lieu de l'activité" placeholder="Ex : 6.128474" requiredLabel="true" id="longitude-activite"/>
							
							<!-- Section liée à la description de l'activité. -->
							<h2>Description de l'activité</h2>			
						
							<s:textfield name="activite.nomActivite" label="Nom de l'activité (entre 1 et 50 caractères)" requiredLabel="true" id="nom-activite"/>		
							<s:textarea name="activite.description" label="Description de l'activité (entre 1 et 800 caractères)" requiredLabel="true" rows="4" id="description-activite"/>	
							
							<s:checkboxlist label="Type d'activités (au moins 1 choix)" list="listNomTypeActivite" requiredLabel="true" name="nomTypesActivitesChoisis" 
							value="nomTypesActivitesChoisis"/>	
							
							<!-- Section liée aux informations pratiques. -->
							<h2>Informations pratiques</h2>		
							
							<s:textfield name="activite.lienHoraireOuverture" label="Horaire" placeholder="Lien vers les horaires d'ouverture" id="lien-horaire-ouverture"/>
								
							<s:select name="activite.duree" label="Durée conseillée pour pratiquer l'activité" list="listDuree" listKey="id" listValue="dureeConseillee" 
							 requiredLabel="true" />		
							
							<s:select name="activite.saison" label="Saison(s) conseillée(s) pour pratiquer l'activité" list="listSaison" listKey="id" 
							listValue="nomSaison" requiredLabel="true" />							
										
							<!-- Section liée à l'ajout de photos. -->
							<h2>Photos</h2>		
							<s:file name="fileUpload" id="fileUpload1" label="Ajouter la photo principale" requiredLabel="true"></s:file>				
							<s:select headerKey="-1" headerValue="Sélectionner la provenance de la photo" name="provenancePhoto" label="Provenance de la photo" 
							list="#{'Personnelle':'Personnelle','Libre de droits':'Libre de droits','Autre':'Autre'}" emptyOption="false" requiredLabel="true"
							id="provenancePhotoUn"/>							
							
							<div id="div-lien-provenance-photo-un"><s:textfield name="lienProvenancePhoto" label="Lien vers la photo d'origine" requiredLabel="true" 
							id="lien-provenance-photo-un"/></div>
												
							<s:file name="fileUpload" id="fileUpload2" label="Ajouter une deuxième photo" requiredLabel="true"></s:file>
							<s:select headerKey="-1" headerValue="Sélectionner la provenance de la photo" name="provenancePhoto" label="Provenance de la photo" 
							list="#{'Personnelle':'Personnelle','Libre de droits':'Libre de droits','Autre':'Autre'}" emptyOption="false" requiredLabel="true"
							id="provenancePhotoDeux"/>							
							
							<div id="div-lien-provenance-photo-deux"><s:textfield name="lienProvenancePhoto" label="Lien vers la photo d'origine" requiredLabel="true"
							id="lien-provenance-photo-deux"/></div>						
							
							<s:file name="fileUpload" id="fileUpload3" label="Ajouter une troisième photo" requiredLabel="true"></s:file>
							<s:select headerKey="-1" headerValue="Sélectionner la provenance de la photo" name="provenancePhoto" label="Provenance de la photo" 
							list="#{'Personnelle':'Personnelle','Libre de droits':'Libre de droits','Autre':'Autre'}" emptyOption="false" requiredLabel="true"
							id="provenancePhotoTrois"/>							
							
							<div id="div-lien-provenance-photo-trois"><s:textfield name="lienProvenancePhoto" label="Lien vers la photo d'origine" requiredLabel="true" 
							id="lien-provenance-photo-trois"/></div>								
							
							<!-- Validation de l'ensemble du formulaire d'ajout d'activités. -->						
							<p class="text-center">
								<s:submit value="Ajouter une activité" class="btn btn-success" id="submit-form-ajout-activite" />
							
							</p>
							
							
						</s:form>
					</div>
				</div>
				
				<script>
					//Initialisation des variables.
					var divMessageErreurElt=document.getElementById("div-message-erreur");
					var nomActiviteElt=document.getElementById("nom-activite");
					var descriptionActiviteElt=document.getElementById("description-activite");	
					var adresseActiviteElt=document.getElementById("adresse-activite");	
					var latitudeActiviteElt=document.getElementById("latitude-activite");
					var longitudeActiviteElt=document.getElementById("longitude-activite");
					var lienHoraireOuvertureElt=document.getElementById("lien-horaire-ouverture");
					
					
					var fileUploadElts=document.getElementsByName("fileUpload");
					
					var provenancePhotoElts=document.getElementsByName("provenancePhoto");				
					var provenancePhotoEltUn=document.getElementById("provenancePhotoUn");
					var provenancePhotoEltDeux=document.getElementById("provenancePhotoDeux");
					var provenancePhotoEltTrois=document.getElementById("provenancePhotoTrois");
										
					var divLienProvenancePhotoEltUn=document.getElementById("div-lien-provenance-photo-un");
					var divLienProvenancePhotoEltDeux=document.getElementById("div-lien-provenance-photo-deux");
					var divLienProvenancePhotoEltTrois=document.getElementById("div-lien-provenance-photo-trois");
					
					var lienProvenancePhotoElts=document.getElementsByName("lienProvenancePhoto");
					var lienProvenancePhotoEltUn=document.getElementById("lien-provenance-photo-un");
					var lienProvenancePhotoEltDeux=document.getElementById("lien-provenance-photo-deux");
					var lienProvenancePhotoEltTrois=document.getElementById("lien-provenance-photo-trois");
					
					var submitElt=document.getElementById("submit-form-ajout-activite");
					var desactivationEnvoiForm=true;
					var activationEnvoiForm;
					
					divMessageErreurElt.style.display="none";
					
					for(var i=0;i<provenancePhotoElts.length;i++){
						provenancePhotoElts[i].value="-1";
						
					}
					
					for(var i=0;i<lienProvenancePhotoElts.length;i++){
						lienProvenancePhotoElts[i].value="";
						
					}
						
					divLienProvenancePhotoEltUn.style.display="none";
					divLienProvenancePhotoEltDeux.style.display="none";
					divLienProvenancePhotoEltTrois.style.display="none";
					
					submitElt.disabled=desactivationEnvoiForm;
				
					//Définition des Event Listener.
					nomActiviteElt.addEventListener("blur",function(event){
						if(nomActiviteElt.value.trim().length===0 || nomActiviteElt.value.length>50){
							divMessageErreurElt.style.display="block"
							divMessageErreurElt.textContent="Veuillez renseigner le nom de l'activité en respectant le nombre de caractères demandés.";
						}else{
							divMessageErreurElt.style.display="none";
							divMessageErreurElt.textContent="";
						}
					});
					
					descriptionActiviteElt.addEventListener("blur",function(event){
						if(descriptionActiviteElt.value.trim().length===0 || descriptionActiviteElt.value.length>800){
							divMessageErreurElt.style.display="block"
							divMessageErreurElt.textContent="Veuillez renseigner la description de l'activité en respectant le nombre de caractères demandés.";
						}else{
							divMessageErreurElt.style.display="none";
							divMessageErreurElt.textContent="";
						}						
					});
										
					latitudeActiviteElt.addEventListener("blur",function(event){
						var regexLatitude=/[0-9]{2}\.[0-9]{6}/;	
						console.log(event.target.value);
						if(!regexLatitude.test(event.target.value) || event.target.value.length >9){
							divMessageErreurElt.style.display="block"
							divMessageErreurElt.textContent="Veuillez renseigner la latitude avec le format demandé.";
						}else{
							divMessageErreurElt.style.display="none";
							divMessageErreurElt.textContent="";
						}
					});
					
					longitudeActiviteElt.addEventListener("blur",function(event){
						var regexLongitude=/[0-9]{1}\.[0-9]{6}/;	
						if(!regexLongitude.test(event.target.value) || event.target.value.length >8){
							divMessageErreurElt.style.display="block"
							divMessageErreurElt.textContent="Veuillez renseigner la longitude avec le format demandé.";
						}else{
							divMessageErreurElt.style.display="none";
							divMessageErreurElt.textContent="";
						}
					});
															
					provenancePhotoEltUn.addEventListener("change", function(event){
						if(event.target.value==="Autre"){
							divLienProvenancePhotoEltUn.style.display="block";
						}else{
							divLienProvenancePhotoEltUn.style.display="none";
							lienProvenancePhotoEltUn.value="";
						}
					});
					
					provenancePhotoEltDeux.addEventListener("change", function(event){
						if(event.target.value==="Autre"){
							divLienProvenancePhotoEltDeux.style.display="block";
						}else{
							divLienProvenancePhotoEltDeux.style.display="none";
							lienProvenancePhotoEltDeux.value="";
						}
					});
					
					provenancePhotoEltTrois.addEventListener("change", function(event){
						if(event.target.value==="Autre"){
							divLienProvenancePhotoEltTrois.style.display="block";
						}else{
							divLienProvenancePhotoEltTrois.style.display="none";
							lienProvenancePhotoEltTrois.value="";
						}
					});
					
					//Fonction permettant de vérifier que les champs du formulaire sont bien renseignés.
					//Si c'est le cas, le formulaire peut être envoyé.
					function verifValidationForm(){
						var verifNomActivite=true;
						var verifDescriptionActivite=true;
						var verifAdresseActivite=true;
						var verifLatitude = true;
						var regexLatitude=/[0-9]{2}\.[0-9]{6}/;	
						var verifLongitude = true;
						var regexLongitude=/[0-9]{1}\.[0-9]{6}/;	
						var verifLienHoraireOuverture=true;
						var verifUploadPhoto=true;
						var verifSelectProvenancePhoto=true;
						var verifTextLienPhoto=true;
						

						//Vérification du nom de l'activité, de la description de l'activité, de l'adresse postale, ainsi que des coordonnées GPS.
						if(nomActiviteElt.value.trim().length===0 || nomActiviteElt.value.length>50){
							verifNomActivite=false;
						}
						
						if(descriptionActiviteElt.value.trim().length===0 || descriptionActiviteElt.value.length>800){
							verifDescriptionActivite=false;
						}
						
						if(adresseActiviteElt.value.length>100){
							verifAdresseActivite=false;
						}
						
						if(!regexLatitude.test(latitudeActiviteElt.value) || latitudeActiviteElt.value.length >9) {
							verifLatitude=false;
						}
						
						if(!regexLongitude.test(longitudeActiviteElt.value) || longitudeActiviteElt.value.length >8) {
							verifLongitude = false;
						}
						
						//Vérification que le lien vers les horaires d'ouverture ne dépasse pas la taille autorisée en nombre de caractères.
						if(lienHoraireOuvertureElt.value.length>300){
							verifLienHoraireOuverture=false;
						}
											
						//Vérification que les trois photos ont bien été uploadés.
						for(var i=0; i<fileUploadElts.length;i++){
							if(fileUploadElts[i].value.length===0){
								verifUploadPhoto=false;
							}
						}
					
						//Vérification des éléments de type Select pour la provenance de la photo.
						for(var i=0;i<provenancePhotoElts.length;i++){
							if(provenancePhotoElts[i].value==="-1"){
								verifSelectProvenancePhoto=false;
							}
						}
												
						//Vérification que le lien vers la photo d'origine pour chaque photo n'est pas vide ou supérieure au nombre de caractères autorisée.
						if(divLienProvenancePhotoEltUn.style.display==="block" &&  (lienProvenancePhotoEltUn.value.trim().length===0 || lienProvenancePhotoEltUn.value.length>300)){
							verifTextLienPhoto=false;
						}
						
						if(divLienProvenancePhotoEltDeux.style.display==="block" &&  (lienProvenancePhotoEltDeux.value.trim().length===0 || lienProvenancePhotoEltDeux.value.length>300)){
							verifTextLienPhoto=false;
						}
						
						if(divLienProvenancePhotoEltTrois.style.display==="block" &&  (lienProvenancePhotoEltTrois.value.trim().length===0 || lienProvenancePhotoEltTrois.value.length>300)){
							verifTextLienPhoto=false;
						}
														
						activationEnvoiForm=verifNomActivite&&verifDescriptionActivite&&verifAdresseActivite&&verifLatitude&&verifLongitude&&verifLienHoraireOuverture&&
						verifUploadPhoto&&verifSelectProvenancePhoto&&verifTextLienPhoto;
						
						if(activationEnvoiForm===true){
							submitElt.disabled=!desactivationEnvoiForm;
						}else {
							submitElt.disabled=desactivationEnvoiForm;
						}
					}
						
					//On appel la fonction verifValidationForm() toutes les secondes pour vérifier régulièrement le formulaire.
					setInterval(verifValidationForm, 1000);	
				</script>								
			</section>

			<!-- Pied de page -->
			<%@ include file="../_include/footer.jsp"%>
		</div>
	</body>
</html>