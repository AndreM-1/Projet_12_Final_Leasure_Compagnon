-- *********************************************************************
-- statut_activite_avis
-- *********************************************************************
INSERT INTO public.statut_activite_avis (statut_activite_avis) VALUES ('En cours de modération'),('Validé'),('Refusé'),('Mise en ligne');

-- *********************************************************************
-- saison
-- *********************************************************************
INSERT INTO public.saison (nom_saison) VALUES ('Printemps'),('Eté'),('Automne'),('Hiver'),
											  ('Printemps - Eté'),('Printemps - Automne'),('Printemps - Hiver'),('Eté - Automne'),('Eté - Hiver'),('Automne - Hiver'),
											  ('Toutes saisons');

-- *********************************************************************
-- duree
-- *********************************************************************
INSERT INTO public.duree (duree_conseillee) VALUES ('Moins de 30 minutes'),('Entre 30 minutes et 1 heure'),('Entre 1 heure et 2 heures'),('Entre 2 heures et 3 heures'),
												   ('Entre 3 heures et 4 heures'),('1 demi-journée'),('1 journée'),('1 semaine'),('Non applicable');

-- *********************************************************************
-- type_activite
-- *********************************************************************
INSERT INTO public.type_activite (type_activite) VALUES ('Les incontournables'),('Sites et monuments'),('Musées'),('Nature et parcs'),('Activités sportives'),
														('Restauration'),('Jeux et divertissement'),('Shopping'),('Vie nocturne');

-- *********************************************************************
-- pays
-- *********************************************************************
INSERT INTO public.pays (nom_pays) VALUES ('France');

-- *********************************************************************
-- region
-- *********************************************************************
INSERT INTO public.region (nom_region,pays_id) VALUES ('Auvergne-Rhône-Alpes',1);

-- *********************************************************************
-- departement
-- *********************************************************************
INSERT INTO public.departement (nom_departement,region_id) VALUES ('Haute-Savoie',1);

-- *********************************************************************
-- ville
-- *********************************************************************
INSERT INTO public.ville(nom_ville,code_postal,description,nb_habitant,departement_id)
VALUES 
-- Annecy
('Annecy','74000','Annecy est une ville des Alpes située dans le sud-est de la France. C''est là que le lac d''Annecy se déverse dans le Thiou. Elle est réputée pour sa vieille ville 
avec ses rues pavées, ses canaux sinueux et ses maisons aux couleurs pastel. Surplombant la ville, le château médiéval d''Annecy, ancienne résidence des comtes de Genève, abrite un 
musée proposant des objets régionaux, tels que du mobilier alpin ou des œuvres religieuses, ainsi qu''une exposition sur l''histoire naturelle.',126419,1),

-- Chamonix
('Chamonix','74400','Chamonix est une commune française située dans le département de la Haute-Savoie, en région Auvergne-Rhône-Alpes. Enserrée entre les massifs montagneux des Aiguilles Rouges 
et du Mont Blanc, Chamonix est très prisée des amateurs d''alpinisme et des sportifs de montagne en général. Le site du Mont Blanc étant le troisième site naturel le plus visité au monde, cet 
atout touristique confère un visage très cosmopolite à la ville.',8759,1),

-- Sixt-Fer-à-Cheval
('Sixt-Fer-à-Cheval','74740','Sixt-Fer-à-Cheval est une commune française située dans le département de la Haute-Savoie, en région Auvergne-Rhône-Alpes, à environ 765 mètres d''altitude. 
Sixt-Fer-à-Cheval est reliée par une seule route au reste de la vallée par le passage des gorges des Tines. La majorité de la commune, occupée par la réserve naturelle de Sixt-Fer-à-Cheval, 
est donc partiellement inhabitée, hormis par des exploitations pastorales en été. Sixt est la deuxième commune la plus étendue de Haute-Savoie, après Chamonix.',773,1),

-- Samoëns
('Samoëns','74340','Samoëns est une commune française située dans le sud du département de la Haute-Savoie, en région Auvergne-Rhône-Alpes, jouxtant la frontière suisse. Cette commune de 
montagne est une des plus étendues du département de la Haute-Savoie. La vallée de Samoëns et ses neuf hameaux se distinguent par la richesse de son patrimoine et une activité continue tout 
au long de l''année, principalement emmenée par le tourisme hivernal et estival.',2451,1),

-- Évian-les-Bains
('Évian-les-Bains','74500','Évian-les-Bains, ou plus communément appelée Évian, est une commune française de Haute-Savoie en région Auvergne-Rhône-Alpes, chef-lieu du canton d''Évian-les-Bains 
et ville centre de la communauté de communes Pays d''Évian Vallée d''Abondance, située sur les bords du lac Léman. Évian est surtout connue comme ville thermale et son eau minérale Évian. 
En toutes saisons, la ville, outre son cadre naturel exceptionnel, offre une multitude d’activités et d’hébergements ouverts au tourisme.',9074,1),

-- Thonon-les-Bains
('Thonon-les-Bains','74200','Capitale historique de la petite province savoyarde du Chablais, la ville de Thonon se divise en deux parties bien distinctes ː la ville haute avec ses belvédères 
situés près du musée du Chablais et le terminus du Funiculaire avec un centre-ville sillonné par des rues devenues essentiellement piétonnes avec ses petites maisons et des bâtiments de faible 
ou de moyenne hauteurs et où l''on trouve de nombreux lieux historiques, notamment des bâtiments religieux; et la ville basse, au bord du Léman et dont le port de Rives est le point central 
avec son vieux village de pécheur.',35132,1),

-- Megève
('Megève','74120','La commune de Megève se situe au carrefour entre les massifs préalpins du massif du Giffre au nord, et de la chaîne des Aravis à l''ouest et du massif alpin du Beaufortain 
au sud-est. Le bourg est bâti sur un col qui sépare les bassins versants de l''Arly au sud-ouest de celui de l''Arbon au nord-est. Située dans le canton de Sallanches en Haute-Savoie, son 
important essor touristique remonte aux années 1910 lorsque la famille Rothschild décida d''en faire un de ses lieux de villégiature.',3123,1),

-- Sallanches
('Sallanches','74700','Sallanches est une commune française, située dans le département de la Haute-Savoie en région Auvergne-Rhône-Alpes. La ville occupe la partie nord du bassin de 
Sallanches, large plaine glaciaire traversée par l''Arve et bordée par le massif des Aravis, le massif du Mont-Blanc et le massif du Faucigny. Ce vaste bassin aux versants peu raides 
contraste avec les hauts sommets qui l''entourent. La ville de Sallanches est dominée à l''ouest par une partie de la chaîne des Aravis, avec en particulier le sommet des Quatre Têtes 
et la Miaz.',15902,1),

-- Lovagny 
('Lovagny','74330','Lovagny est une commune française située dans le département de la Haute-Savoie, en région Auvergne-Rhône-Alpes. Le territoire de la commune est situé à 5 kilomètres à 
l''ouest du centre-ville d''Annecy, sur une zone de hautes collines des Préalpes. Parmi les activités à faire sur place figurent le château de Montrottier (ancienne maison forte, du 
XIIIe siècle, remaniée plusieurs fois et restaurée au XIXe siècle) ainsi que les gorges du Fier (gorge très étroite et profonde que l''on peut visiter grâce à une passerelle fixée à flanc de 
rocher, aménagée au milieu du XIXe siècle).',1301,1),

-- Annemasse
('Annemasse','74100','Annemasse est le centre de la deuxième agglomération de Haute-Savoie. Elle est située aux abords de la frontière franco-suisse, dans le nord des Alpes françaises, à 
2 km du canton de Genève et à 45 km d''Annecy, la préfecture de Haute-Savoie. La ville est entourée par le mont Salève (alt. 1300 m au sud) et la rivière Arve au sud-ouest puis à l''ouest, 
les Voirons (alt. 1480 m à l''est) et la frontière suisse à l''ouest et à 26 km de Thonon-les-Bains. Elle constitue l''entrée de la vallée de l''Arve.',35041,1);

-- *********************************************************************
-- utilisateur
-- *********************************************************************
INSERT INTO public.utilisateur(civilite,nom,prenom,pseudo,adresse_mail,salt,mot_de_passe_securise,date_inscription,telephone,date_naissance,adresse,code_postal,ville,pays,
envoi_mail_informatif,administrateur)
VALUES
-- Mot de passe non sécurisé :M0tp@SAdM83!!
('Monsieur', 'Monnier','André','André M.','andre_monnier@yahoo.fr','duWHFkUYaDVcIY2F52OFhYM08rSp2U','ukdUT1hmMrcHbEC2lFb5/3CoeH1hSJyhWlslAs6k0GU=','2019-02-20 08:10:25',
'07-74-13-52-09','1983-09-03','667 Chemin de sur la ville','74000','ANNECY','France',true,true),

-- Mot de passe non sécurisé :M@rt1R@778?
('Monsieur', 'Durand','Martin','Martin D','andre.monnier@hotmail.fr','nwhMGwRv5k1HTLIGjmrdyQsoBSYmcb','96MJCGUsI6yzRM53HIugWIF/s1E5ykiQ+GIe1BXi8XM=','2019-02-20 12:30:28',
'06-31-47-36-82','1982-10-03','1 AVENUE BERTHOLLET','74000','ANNECY','France',true,false),

-- Mot de passe non sécurisé :oli3vier4!
('Monsieur', 'Lockla','Olivier','OF','vifierlockla@gmail.com','7tUIJCF58zl3zEbo5qDDjoN8yCn77c','nWABl2PGos+lblFFaPU1vAARDgLA9779NAtImeHomA4=','2019-02-21 00:01:15',
NULL,'1943-10-03',NULL,NULL,'Strasbourg','France',true,false),

-- Mot de passe non sécurisé :GEsc@L@Dais?
('Monsieur', 'Gallet','Romuald','Romu G.','romuald.gallet@yahoo.fr','lLGSalPUNp8LaK5YezAzvGiuqvH5Va','QYWhASzYFe0L1TYrKNMovzj9hQ5fLfEaYlqkjP5iKFc=','2019-02-21 21:01:15',
NULL,NULL,NULL,NULL,NULL,'France',true,false);

-- *********************************************************************
-- activite
-- *********************************************************************
INSERT INTO public.activite(nom_activite,description,adresse,lien_horaire_ouverture,date_demande_ajout,date_moderation_admin,date_mise_en_ligne,utilisateur_id,ville_id,duree_id,
saison_id,statut_activite_avis_id)
VALUES
-- Lac d'Annecy
('Lac d''Annecy','Le lac d''Annecy est un lac de France situé dans les Alpes, en Haute-Savoie et en région Auvergne-Rhône-Alpes. Par sa superficie, il est le deuxième lac d''origine 
glaciaire de France après celui du Bourget, très proche, et exception faite de la partie française du lac Léman. Le lac déverse son trop-plein d’eau dans le Thiou qui alimente le Fier 
au nord-ouest de la commune d''Annecy, celui-ci se jetant ensuite directement dans le Rhône. Le lac est un site touristique très attractif, connu pour ses nombreuses activités nautiques, 
le parapente, et ses qualités environnementales permettant l''observation d''une nature préservée.',NULL,NULL,'2019-02-22 09:16:38','2019-02-23 10:16:38','2019-02-24 00:01:00',1,1,4,11,4),

-- La Vieille Ville
('La Vieille Ville','Une grande partie du centre-ville et de la vieille ville est constituée de rues rendues piétonnes en 1973. Les plus grandes et les plus fréquentées sont la rue 
Sainte-Claire, la rue Carnot et la rue Royale. Une autre rue piétonne, la rue Louis-Armand, se situe dans le nord de la commune, dans le quartier de Novel. Grâce à ses canaux qui parcourent 
la vieille ville, Annecy a pour surnom flatteur « la Venise des Alpes ». Historiquement, la ville est née une première fois sur la colline d''Annecy-le-Vieux (villa Aniciaca) au VIIIe siècle, 
puis une seconde fois au pied d''une tour de défense édifiée sur le dernier contrefort du Semnoz (Annecy-le-Neuf) au XIe siècle et s''est ensuite développée le long des émissaires naturels 
et canalisés du lac : le Thiou, le principal, et aussi le Vassé.',NULL,NULL,'2019-02-22 10:20:38','2019-02-23 11:30:38','2019-02-24 00:01:00',1,1,9,11,4),

-- Pont des amours
('Pont des amours','Le pont des Amours est une passerelle située au bord du lac d''Annecy à l''entrée du canal du Vassé ; son nom officiel est « Passerelle du Jardin public » mais les Annéciens 
l''ont depuis très longtemps rebaptisé « Pont des Amours ». Il permet de relier le Pâquier aux Jardins de l''Europe où les amoureux avait l''habitude d''aller y trouver refuge et tranquillité. 
Ce pont reste aujourd''hui un passage très fréquenté dans un cadre absolument romantique avec des vues magnifiques sur la ville, les canaux et le lac. Cette passerelle piétonne marque une des 
deux entrées, avec le Thiou, des eaux du lac à l’intérieur de la ville.',NULL,NULL,'2019-02-22 11:20:50','2019-02-23 12:40:38','2019-02-24 00:01:00',1,1,9,11,4),

-- Château d'Annecy
('Château d''Annecy','Le château d''Annecy est un ancien château fort, du XIIe siècle, remanié à plusieurs reprises, notamment par les ducs de Savoie entre 1430 et 1487 et entre 1533 et 1571 
par les Savoie-Nemours, qui se dresse sur la commune d''Annecy dans le département de la Haute-Savoie, en région Auvergne-Rhône-Alpes. Ancienne résidence des comtes de Genève puis des ducs de 
Savoie-Nemours, le château d''Annecy est depuis 1953 la propriété de la ville qui l''a restauré et transformé en musée. Le château d''Annecy fait l’objet d’un classement au titre des monuments 
historiques par arrêté du 12 octobre 1959.','Place du château','http://musees.agglo-annecy.fr/Informations-pratiques/Horaires-des-trois-sites','2019-02-22 12:20:50','2019-02-23 13:40:38',
'2019-02-24 00:01:00',1,1,9,11,4),

-- Palais de l'isle
('Palais de l''isle','Le palais de l''Île est une ancienne maison forte, du XIIe siècle, remaniée à plusieurs reprises, située sur un îlot formé par le Thiou, qui se dresse sur la commune 
d''Annecy dans le département de la Haute-Savoie, en région Auvergne-Rhône-Alpes. Utilisé notamment comme prison, aujourd''hui lieu d''exposition sur l''architecture et le patrimoine du 
territoire de l''agglomération d''Annecy, il offre un parcours permanent sur l''histoire, le patrimoine de ce territoire. Les anciennes salles d''audience, les anciennes cellules et cachots 
des prisonniers ainsi que l''ancienne chapelle se visitent. Le palais fait l''objet d''un classement au titre des monuments historiques par arrêté du 16 février 1900.','3 Passage de l''Île',
'http://musees.agglo-annecy.fr/Informations-pratiques/Horaires-des-trois-sites','2019-02-22 13:20:40','2019-02-23 14:40:38','2019-02-24 00:01:00',1,1,9,11,4),

-- Château de Montrottier
('Château de Montrottier','Le château de Montrottier est une ancienne maison forte, du XIIIe siècle, remaniée plusieurs fois et restaurée au XIXe siècle, qui se dresse sur la commune de 
Lovagny, à une douzaine de kilomètres à l''ouest d''Annecy, près des gorges du Fier. Du chemin de ronde, la vue embrasse la campagne vallonnée et s''étend au-delà des montagnes qui dominent 
le lac d''Annecy jusqu''au mont Blanc. Élevé sur un piton rocheux, qu''encercle l''ancien lit du Fier ; « la Grande-Fosse », il surveillait le passage de la rivière Le Fier sur la route 
reliant Chambéry à Genève.','60, Allée du Château','http://www.chateaudemontrottier.com/visite/','2019-02-22 14:20:40','2019-02-23 15:44:31','2019-02-24 00:01:00',1,9,4,11,4),

-- Basilique de la Visitation
('Basilique de la Visitation','La basilique de la Visitation fut bâtie de 1909 à 1930 dans le style typique de la fin du XIXe siècle. Le clocher a une hauteur de 72 mètres et il est surmonté 
d''une croix de bronze de 7 mètres. La nef repose sur une crypte aux arcs surbaissés, dessinée par Henri Adé. La voûte a été construite en plein cintre. Les vitraux de la basilique évoquent 
la vie des deux saints fondateurs. Elle possède un carillon de 38 cloches pesant 8 tonnes. Le bourdon, une cloche qui se nomme Marie Françoise, pèse 4 tonnes. Le carillon est classé aux 
monuments historiques.', '20 avenue de la Visitation | Recteur du Sanctuaire','http://www.tourisme-annecy.net/basilique-visitation-annecy.html','2019-02-22 15:20:40','2019-02-23 16:34:31',
'2019-02-24 00:01:00',1,1,9,11,4),

-- Notre-Dame de Liesse
('Notre-Dame de Liesse','Fondée et construite dans la seconde partie du XIVe siècle par les comtes de Genève Amédée III et Robert, l’église Notre-Dame-de-Liesse fut construite sur 
l''emplacement d’un ancien oratoire et sur celui d''une place médiévale à proximité d’un hospice médiéval. Cet endroit présentait alors un caractère religieux affirmé. Ce sanctuaire religieux 
est connu sous les traits d''un modeste oratoire marial cité dès le XIe siècle. Mais la véritable fondation de Notre-Dame-de-Liesse date de 1360, grâce au comte Amédée III de Genève qui 
souhaitait faire de cette nouvelle église la nécropole de sa lignée. Le comte Robert continua la construction qui fut achevée en 1394. Le sanctuaire fut consacré en 1398.','12 Place Notre Dame',
'https://messes.info/lieu/74/annecy/notre-dame-de-liesse','2019-02-22 16:25:40','2019-02-23 17:41:31','2019-02-24 00:01:00',1,1,2,11,4),

-- Cathédrale Saint-Pierre
('Cathédrale Saint-Pierre','La Cathédrale Saint-Pierre a été classée monument historique par arrêté du 30 octobre 1906. La façade exceptionnelle, de 1535, déjà strictement Renaissance, est 
sans doute, comme l''a montré Marcel Grandjean, inspirée d''un modèle romain, à savoir l''église Sainte-Marie-du-Peuple. Cette composition, qui cache un édifice basilical, est rythmée de 
pilastres toscans, sommée d''un fronton et ajourée notamment d''une rose encore dans la tradition gothique, imitant la rose supérieure de la tour sud de la cathédrale Saint-Pierre de Genève,
due au même architecte.','Rue Jean-Jacques Rousseau','http://musees.annecy.fr/Patrimoines/Decouvrez-nos-patrimoines/Annecy/Cathedrale-Saint-Pierre','2019-02-22 17:28:40','2019-02-23 18:48:31',
'2019-02-24 00:01:00',1,1,2,11,4),

-- Montagne du Semnoz
('Montagne du Semnoz','Le Semnoz est une montagne de moyenne altitude (1699 mètres) longue de 16 kilomètres au nord du massif des Bauges, dont il fait partie, entre Annecy et Allèves 
(cluse de Banges) dans une direction nord-est/sud-ouest. Il est situé en Haute-Savoie. Le Semnoz est formé d''un anticlinal de calcaires urgoniens. Géologiquement, c''est un typique mont 
jurassien. Les cartographes romains baptisèrent la montagne « Saumon » à cause de sa forme qui leur rappelait celle de ce poisson.',NULL,NULL,'2019-02-22 18:28:02','2019-02-23 19:48:25',
'2019-02-24 00:01:00',1,1,9,11,4),

-- Voie Verte du Lac d'Annecy
('Voie Verte du Lac d''Annecy','La voie verte du lac d''Annecy est un aménagement urbain réservé aux modes de déplacement doux gérée par le SILA. Longue de 33 kilomètres, elle longe le lac 
d''Annecy sur sa rive occidentale entre Annecy et Marlens, dans le département de la Haute-Savoie sur l''emprise de l''ancienne ligne d''Annecy à Albertville. Celle-ci est réservée aux piétons 
ainsi qu''à tout engin non motorisé. La première partie ouverte de la voie verte, d''Annecy à Doussard, reprend le tracé de l’ancienne voie de chemin de fer qui longeait le lac. Des travaux 
ont été réalisés en 2004 afin de relier l''extrémité nord de l''ancienne voie ferrée au port d''Annecy. La section sud a été réalisée plus récemment de 2005 à 2007 et permet donc maintenant 
de relier en continu Annecy à Marlens.',NULL,NULL,'2019-02-22 19:28:02','2019-02-23 20:48:25','2019-02-24 00:01:00',1,1,6,5,4),

-- Jardins de l'Europe
('Jardins de l''Europe','Les Jardins de l''Europe, à Annecy, sont un vaste parc destiné à la promenade. Ils se situent sur les rives du lac d''Annecy. Le jardin est inscrit à 
l''Inventaire général du patrimoine culturel. Les berges des Jardins d''Europe sont agrémentées de bancs. On y trouve aussi une zone d''amarrage constituée de 270 emplacements. Ceux-ci sont 
établis entre le canal du Vassé, les jardins de l''Europe et le quai de la Tournette. Le Pont des Amours, disposé au-dessus du canal du Vassé, relie les jardins de l''Europe au Pâquier.',
'quai Napoleon III',NULL,'2019-02-22 20:32:02','2019-02-23 21:50:25','2019-02-24 00:01:00',1,1,3,5,4),

-- La Tournette
('La Tournette','La Tournette, 2351 m, est un sommet du massif des Bornes. Le chaînon de la Tournette sépare le lac d''Annecy de la dépression de Thônes. L''été, deux sentiers de randonnée 
permettent l''ascension du massif de la Tournette. En hiver, des randonnées en raquettes et en ski de randonnée peuvent être entreprises à partir de Belchamp, en passant par le refuge de 
Rosairy. C''est le seul chemin praticable en hiver.',NULL,NULL,'2019-02-22 21:30:02','2019-02-23 23:00:25','2019-02-24 00:01:00',1,1,9,11,4),

-- Aiguille du Midi
('Aiguille du Midi','L''aiguille du Midi se situe dans le massif du Mont-Blanc. Culminant à 3842 mètres, elle est la plus haute des aiguilles de Chamonix. Sur le sommet principal, s''élève
une tour, portant des antennes de télécommunication, qui représente le point culminant actuel. L''aiguille est le point d''arrivée d''un téléphérique — le téléphérique de l''aiguille du Midi.
Sa gare supérieure est située à 3777 mètres d''altitude. L''aiguille abrite le plus haut centre d''émission hertzien de France. Elle est le point de départ de la descente de la vallée Blanche 
et de la télécabine Panoramic Mont-Blanc qui traverse le glacier du Géant jusqu''à la pointe Helbronner sur le versant italien à (3 462 mètres), avec sa vue imprenable sur la vallée d''Aoste 
et tout le Piémont.',NULL,NULL,'2019-02-25 08:00:00','2019-02-26 09:00:00','2019-02-27 00:01:00',1,2,4,11,4),

-- Mer de Glace
('Mer de Glace','La Mer de Glace est un glacier de vallée alpin situé sur le versant septentrional du massif du Mont-Blanc, dans le département français de la Haute-Savoie. Il est formé par 
la confluence du glacier du Tacul et du glacier de Leschaux et s''épanche dans la vallée de l''Arve, sur le territoire de la commune de Chamonix-Mont-Blanc, donnant naissance à l''Arveyron. 
Le glacier s''étend sur sept kilomètres de long, son bassin d''alimentation possède une longueur maximale de douze kilomètres et une superficie de 40 km2, alors que son épaisseur atteint 
300 mètres.',NULL,NULL,'2019-02-25 09:00:00','2019-02-26 10:00:00','2019-02-27 00:01:00',1,2,9,11,4),

-- Mont Blanc
('Mont Blanc','Le Mont Blanc est le point culminant de la chaîne des Alpes. Avec une altitude de 4809 mètres, il est le plus haut sommet d''Europe occidentale. Le sommet, objet de fascination 
dans de nombreuses œuvres culturelles, a depuis plusieurs siècles représenté un objectif pour toutes sortes d''aventuriers, depuis sa première ascension en 1786. De nombreux itinéraires 
fréquentés permettent désormais de le gravir avec une préparation sérieuse.',NULL,NULL,'2019-02-25 10:00:00','2019-02-26 11:00:00','2019-02-27 00:01:00',1,2,9,11,4),
 
-- Téléphérique du Brévent
('Téléphérique du Brévent','Le téléphérique du Brévent est un téléphérique qui relie le plateau de Planpraz au sommet du Brévent à proximité de Chamonix-Mont-Blanc. Il fait suite à la 
télécabine de Planpraz qui relie Chamonix à Planpraz et permet d''accéder au sommet du Brévent, à 2 525 mètres d''altitude.','29, route Henriette d’Angeville | Mont-Blanc',
'https://www.montblancnaturalresort.com/fr/horaires-tarifs-brevent','2019-02-25 11:08:00','2019-02-26 12:09:00','2019-02-27 00:01:00',1,2,9,9,4),

-- Eglise Saint Michel 
('Eglise Saint Michel','L''église Saint-Michel de Chamonix-Mont-Blanc est une église catholique de style Baroque savoyard ou alpin à clocher à bulbe, des XIIe siècle et XIXe siècle, 
placée sous le patronage de l''archange Michel, à Chamonix-Mont-Blanc, en Haute-Savoie. L''édifice est classé aux monuments historiques depuis le 28 décembre 1979. La place de l''église 
accueille, chaque année, la cérémonie traditionnelle de la Fête des Guides : appel des nouveaux guides, hommage à ceux qui ont disparu en montagne, messe.','82, Rue de la Mollard',
NULL,'2019-02-25 12:08:00','2019-02-26 13:10:00','2019-02-27 00:01:00',1,2,9,11,4),

-- Glacier des Bossons
('Glacier des Bossons','Le glacier des Bossons est une cascade de glace (la plus grande d''Europe) qui descend du sommet du Mont Blanc (Alpes). Il prend naissance sur le versant français 
du Mont Blanc (4 810 m), entre les roches Rouges (4 364 m) et le dôme du Goûter (4 304 m). Il s''épanche dans la vallée de Chamonix-Mont-Blanc, au-dessus du village des Bossons qui lui 
donne son nom.',NULL,NULL,'2019-02-25 13:11:00','2019-02-26 14:12:00','2019-02-27 00:01:00',1,2,9,11,4),

-- Vallée Blanche
('Vallée Blanche','La vallée Blanche est une vallée glaciaire située au cœur du massif du Mont-Blanc, en contrebas de l''aiguille du Midi, à plus de 3400 m d''altitude. C''est également 
le nom donné à deux itinéraires de haute montagne au départ de l''aiguille du Midi : une descente à ski jusqu''au Montenvers ou même à Chamonix et une randonnée glaciaire jusqu''à la 
pointe Helbronner. Le tunnel du Mont-Blanc passe très exactement sous la vallée Blanche, à environ 1300 m d''altitude.',NULL,NULL,'2019-02-25 14:15:00','2019-02-26 15:15:04',
'2019-02-27 00:01:00',1,2,9,11,4),

-- Lac Blanc
('Lac Blanc','Le lac Blanc est un lac d''altitude du massif des aiguilles Rouges, situé sur la commune de Chamonix-Mont-Blanc à une altitude de 2352 m. Il est accessible après deux bonnes 
heures de marche de montagne à partir du téléphérique de la Flégère. Le lac est situé dans le périmètre de la réserve naturelle des aiguilles Rouges. Un refuge est installé à proximité du lac. 
Le lac est composé de deux parties. Il arrive régulièrement que la partie « arrière » du lac reste enneigée, même en été. Depuis ses rives, à l''aplomb de Chamonix, il offre un panorama 
exceptionnel sur le massif du Mont-Blanc.',NULL,NULL,'2019-02-25 15:15:00','2019-02-26 16:15:04','2019-02-27 00:01:00',1,2,9,11,4),

-- Les Grands Montets
('Les Grands Montets','L''aiguille des Grands Montets, dans le massif du Mont-Blanc, est le nom donné à l''un des sommets dominant le village d''Argentière (1200 mètres), sur la commune 
de Chamonix-Mont-Blanc. Elle culmine à 3295 mètres. Depuis 1963, un téléphérique grimpe jusqu''au sommet de l''aiguille, en passant par la station intermédiaire de Lognan.',NULL,NULL,
'2019-02-25 16:15:00','2019-02-26 17:15:04','2019-02-27 00:01:00',1,2,9,11,4),

-- Aiguilles Rouges
('Aiguilles Rouges','Les aiguilles Rouges sont un massif montagneux des Alpes françaises du Nord. Le qualificatif de « rouge » est justifié par la teinte caractéristique due à l''état 
d''oxydation du fer des gneiss. Les aiguilles Rouges offrent une vue magnifique sur toutes les aiguilles de Chamonix, les glaciers du mont Blanc et le toit de l''Europe. Sur la partie 
orientale du massif se trouvent de nombreux lacs de montagne dont le plus remarquable est le lac Blanc au pied de l''aiguille du Belvédère.',NULL,NULL,'2019-02-25 17:15:00',
'2019-02-26 18:15:04','2019-02-27 00:01:00',1,2,9,11,4),

-- Cirque du Fer à Cheval
('Cirque du Fer à Cheval','Le cirque du Fer-à-Cheval est un cirque naturel formant un hémicycle calcaire de 4 à 5 km de développement. Avec des parois de 500 à 700 m de hauteur, couronnées 
par des sommets approchant 3000 mètres d''altitude, il s''agit du plus grand cirque montagneux alpin. Parmi les sommets qui l''entourent figurent le pic de Tenneverge (2987 m), 
le Cheval Blanc (2831 m) et le Grenier de Commune (2775 m). Au mois de juin, plus de trente cascades assez impressionnantes jaillissent de ses falaises abruptes et de ses névés. 
Le cirque fait partie de la réserve naturelle nationale de Sixt-Passy, et est également classé Grand Site de France.','Fer à Cheval',NULL,'2019-02-25 18:20:00','2019-02-26 19:41:04',
'2019-02-27 00:01:00',1,3,9,11,4),

-- Cascade du Rouget
('Cascade du Rouget','La cascade du Rouget est une cascade de la Vallée du Giffre (France) qui s''écoule toute l''année depuis le torrent de Salles en amont et qui rejoint le 
Giffre des Fonds en aval pour constituer le Petit Giffre sur la commune de Sixt-Fer-à-Cheval. Elle représente une chute d''une centaine de mètres avec un ressaut qui peut-être impressionnant 
au moment de la fonte des neiges. Elle est accessible directement par une petite route ce qui en fait un site touristique très fréquenté. Elle est l''un des deux sites référencés de la 
commune avec le cirque du Fer-à-Cheval.','Cascade du Rouget',NULL,'2019-02-25 20:35:00','2019-02-26 22:49:04','2019-02-27 00:01:00',1,3,9,11,4);

-- *********************************************************************
-- activite_type_activite
-- *********************************************************************
INSERT INTO public.activite_type_activite(activite_id,type_activite_id) 
VALUES (1,1),(1,4),(2,1),(2,2),(3,1),(3,2),(4,1),(4,2),(4,3),(5,1),(5,3),(6,1),(6,2),(7,2),(8,2),(9,2),(10,4),(10,5),(11,4),(11,5),(12,4),(13,4),(13,5),
	   (14,1),(14,2),(14,4),(14,5),(15,1),(15,2),(16,1),(16,4),(16,5),(17,2),(17,5),(18,2),(19,4),(19,5),(20,4),(20,5),(21,4),(21,5),(22,4),(23,4),(23,5),
	   (24,1),(24,4),(25,1),(25,4);

-- *********************************************************************
-- coordonnee_gps
-- *********************************************************************
INSERT INTO public.coordonnee_gps(latitude,longitude,ville_id,activite_id)
VALUES (45.900696,6.128474,1,NULL),
	   (45.924325,6.870103,2,NULL),
	   (46.054694,6.777579,3,NULL),
	   (46.084146,6.727914,4,NULL),
	   (46.401727,6.586105,5,NULL),
	   (46.373420,6.483612,6,NULL),
	   (45.857376,6.619806,7,NULL),
	   (45.936178,6.638237,8,NULL),
	   (45.903781,6.033808,9,NULL),
	   (46.193192,6.235853,10,NULL),
	   (45.869171,6.165934,NULL,1),
	   (45.898795,6.125739,NULL,2),
	   (45.900219,6.131378,NULL,3),
	   (45.897545,6.126206,NULL,4),
	   (45.898572,6.127335,NULL,5),
	   (45.898721,6.039597,NULL,6),
	   (45.892705,6.127548,NULL,7),
	   (45.899970,6.125986,NULL,8),
	   (45.899189,6.125578,NULL,9),
	   (45.797241,6.104722,NULL,10),
	   (45.901044,6.130834,NULL,11),
	   (45.899207,6.131309,NULL,12),
	   (45.826401,6.286387,NULL,13),
	   (45.879349,6.887419,NULL,14),
	   (45.920389,6.928201,NULL,15),
	   (45.832650,6.865168,NULL,16),
	   (45.924029,6.863527,NULL,17),
	   (45.923921,6.868069,NULL,18),
	   (45.877266,6.864545,NULL,19),
	   (45.875789,6.908973,NULL,20),
	   (45.982869,6.889089,NULL,21),
	   (45.948344,6.961111,NULL,22),
	   (45.955721,6.859141,NULL,23),
	   (46.078570,6.842688,NULL,24),
	   (46.027047,6.771859,NULL,25);

-- *********************************************************************
-- avis
-- *********************************************************************
INSERT INTO public.avis(commentaire,appreciation,date_poste_avis,date_moderation_admin_avis,date_mise_en_ligne_avis,utilisateur_id,activite_id,statut_activite_avis_id)
VALUES 
-- Lac d'Annecy
('Le lac d''Annecy est très propre et ses contours sont bien aménagés. Lorsque l''on se promène autour du lac, la vue est impressionnante avec le contraste du lac avec les chaînes de montagnes 
environnantes. Le lac est idéal pour se baigner l''été et il y a une multitude de restaurants aux alentours.','Excellent','2019-02-28 07:30:00','2019-03-02 10:00:00','2019-03-02 10:00:00',
2,1,4),
('Quel magnifique décor général qu’offre le lac d’Annecy, avec une promenade, des espaces verts, de quoi se détendre, prendre l’eau, l’ombre ou le soleil. Même au cœur de 
l’automne quand il fait à peine plus de 10 degrés, les lumières sont superbes, et les montagnes alentours sont reposantes.','Excellent','2019-02-28 07:38:00','2019-03-02 10:05:00',
'2019-03-02 10:05:00',3,1,4),
('Trèèèèèèès bel endroit mais vraiment surpeuplé durant les vacances et les week-end','Très bon','2019-02-28 08:38:00','2019-03-02 10:10:00',
'2019-03-02 10:10:00',4,1,4),

-- La Vieille Ville
('Depuis de nombreuses années, je viens me promener dans la vieille ville au moins une dizaine de fois par année. Avec le temps il y a eu des changements, peu dans les ruelles du centre et le 
long de la rivière. Le cadre est on ne peut plus photogénique. Je ne m''en lasse pas et j''y viens toujours avec le même plaisir.','Excellent','2019-02-28 09:05:00','2019-03-02 10:15:00',
'2019-03-02 10:15:00',2,2,4),
('La vieille ville est jolie mais c''est devenu un centre commercial ! Du coup , la beauté des lieux est un peu gâchée. Ceci étant dit , il y a quand même quelques jolis coins calmes à découvrir 
et de bon restaurants à essayer.','Bon','2019-02-28 09:10:00','2019-03-02 10:20:00','2019-03-02 10:20:00',3,2,4),
('Du fait de sa proximité avec le lac d''Annecy et des canaux du Thiou qui la traversent, Annecy est surnommée la Venise des Alpes. En même temps, les bâtisses moyenâgeuses avec leurs imposantes 
portes et les petites ruelles pavées bordées de massives arches en pierres lui donnent un aspect de vieille ville médiévale fortifiée. De nombreux lieux emblématiques sont à découvrir 
impérativement comme le Palais de l''Île, le Jardin de l''Europe, le Pont des Amours, le château d''Annecy, etc...','Excellent','2019-02-28 09:11:00','2019-03-02 10:25:00','2019-03-02 10:25:00',
4,2,4),

-- Château d'Annecy
('Un beau bâtiment très bien entretenu, mais malheureusement quelle déception une fois à l''intérieur !!! Nous y voyons de grandes pièces vides avec des oeuvres contemporaines... Moi qui 
pensais apprendre sur le moyen âge, la vie d''Annecy autrefois… Quel dommage;(','Déconseillé','2019-02-28 10:15:00','2019-03-02 10:30:00','2019-03-02 10:30:00',2,4,4),
('Le château est impressionnant de loin et sa cours est magistrale! Par contre, l’intérieur est décevant. Le côté historique n’a pas du tout été préservé.','Moyen','2019-02-28 10:16:00',
'2019-03-02 10:35:00','2019-03-02 10:35:00',3,4,4),
('Un joli château mais pas grand chose d''époque à l''intérieur. Le point fort demeure la vue depuis la cour du monument.','Bon','2019-02-28 10:18:00','2019-03-02 10:40:00',
'2019-03-02 10:40:00',4,4,4),

-- Palais de l'isle
('Je pensais voir plus de choses d''époque dans cette bâtisse, mais la plupart de la visite repose sur des expositions sur l''architecture d''Annecy. Cela reste intéressant, mais je n''étais 
pas venu pour ça.','Bon','2019-02-28 11:18:00','2019-03-02 10:45:00','2019-03-02 10:45:00',2,5,4),
('C''est un endroit très intéressant, qui retrace l''histoire de la ville et son passé d''anciennes prisons. C''est émouvant. Superbement restauré pour en faire un musée passionnant.',
'Très bon','2019-02-28 11:20:00','2019-03-02 10:50:00','2019-03-02 10:50:00',3,5,4),

-- Voie Verte du Lac d'Annecy
('Piste cyclable faisant presque le tour du lac et aux vues imprenables. Mais attention, les accès sont très mal signalés, ce qui fait que beaucoup de touristes se retrouvent sur la route 
nationale, en parallèle de la piste cyclable.','Bon','2019-02-28 12:10:15','2019-03-02 11:00:00','2019-03-02 11:00:00',2,11,4),

-- Aiguille du Midi
('Site exceptionnel !!! A faire au moins une fois dans sa vie. Une escapade qui se prépare et se calcule si on veux tout faire. Très haute altitude, personne fragile s''abstenir.','Excellent',
'2019-02-28 13:10:15','2019-03-02 11:05:00','2019-03-02 11:05:00',2,14,4),
('C''est majestueux, grandiose. Je ne m''en lasse jamais tellement la nature est belle...','Excellent','2019-02-28 13:12:15','2019-03-02 11:10:00','2019-03-02 11:10:00',3,14,4),
('Lieu époustouflant !!! La pointe est à 3842 mètres. Le jour où nous y sommes allés le temps etait dégagé et la vue etait vraiment exceptionnelle. Nous avons visité l''aiguille du Midi hors 
vacances scolaires du coup il n''y avait pas trop de monde ce qui etait encore plus appréciable. Ne pas acheter ses billets la veille car si le temps ne permet pas l''accès le lendemain 
les billets ne sont pas remboursés. Pensez aussi à vous habiller chaudement car il fait glacial tout en haut (-12°).','Excellent','2019-02-28 13:14:15','2019-03-02 11:15:00',
'2019-03-02 11:15:00',4,14,4),

-- Mer de Glace
('La mer de glace est un incontournable. Si vous êtes en visite dans la région, vous devez prendre un petit train à la gare de chamonix afin d’accéder à la gare de montenvers. Cette montée 
de 20 minutes vous permet de voir des paysages magnifiques. Vous prenez ensuite une télécabine qui vous permet d’accéder à un palier pour prendre ensuite 500 marches à descendre pour enfin 
accéder à la grotte de la mer de glace. Le prix est quand même assez élevé car la visite est rapide.','Excellent','2019-02-28 14:14:15','2019-03-02 11:20:00','2019-03-02 11:20:00',2,15,4),
('La mer de glace se retire de plus en plus et il faut aujourd’hui prendre le petit train (comme depuis fort longtemps), un télécabine, puis descendre les marches et les remonter !',
'Très bon','2019-02-28 14:16:15','2019-03-02 11:25:00','2019-03-02 11:25:00',3,15,4),

-- Mont Blanc
('C''est vraiment magnifique, extraordinaire. La neige au rdv! La ville superbe! Je conseille à tous les amoureux de la nature !','Excellent','2019-02-28 15:16:15','2019-03-02 11:30:00',
'2019-03-02 11:30:00',2,16,4),
('On ne s''aventure pas à la conquête du mont blanc sans une préparation physique solide, sans la moindre expérience de la très haute montagne , sans des vêtements et un materiel adapté. 
Ensuite, il vaut mieux se faire accompagner par un guide professionnel. Cette ascension a un coût !! Et si vous la faite accompagné par des gens experimentés, bien choisir son itineraire.',
'Très bon','2019-02-28 15:18:15','2019-03-02 11:35:00','2019-03-02 11:35:00',3,16,4),

-- Lac Blanc
('Très belle randonnée qui demande du temps depuis la ville de chamonix. Cette randonnée est à faire pour un bon randonneur (à moins bien sûr de prendre le télésiège).','Très bon',
'2019-02-28 16:30:15','2019-03-02 11:40:00','2019-03-02 11:40:00',2,21,4);

-- *********************************************************************
-- formulaire_contact
-- *********************************************************************
INSERT INTO public.formulaire_contact(nom_na,adresse_mail_na,objet,message,date_form_contact,utilisateur_id)
VALUES
(NULL,NULL,'Proposer une amélioration','Pourriez-vous proposer plusieurs langues pour le site web? Actuellement, seul le français est disponible.','2019-02-28 17:30:15',2),
('Anderson','gillian.anderson@gmail.com','Proposer une amélioration','Le site n''est disponible qu''en français pour le moment. Avez-vous prévu de traduire le site en plusieurs langues ?', 
'2019-03-01 10:00:15',NULL),
(NULL,NULL,'Proposer une amélioration','Pensez-vous élargir le contenu de votre site à l''ensemble de la région Auvergne-Rhône-Alpes et pas seulement vous limiter au département de la 
Haute-Savoie ? Cordialement.','2019-03-01 10:00:16',3),
('Pasquier','sebastien.pasquier@gmail.com','Proposer une amélioration','Allez-vous étendre le site aux pays frontaliers ?','2019-03-01 11:05:16',NULL),
(NULL,NULL,'Proposer une nouvelle catégorie','Serait-il possible d''indiquer les hôtels disponibles pour chaque ville? Merci.','2019-03-01 11:10:16',2),
('Pasquier','sebastien.pasquier@gmail.com','Contacter l’administrateur','Bonjour, je souhaiterais vous proposer une amélioration. Êtes-vous d''accord pour en parler. Cdlt.',
'2019-03-02 12:10:16',NULL);

-- *********************************************************************
-- photo
-- *********************************************************************
INSERT INTO public.photo(nom_photo,provenance_photo,type_photo,utilisateur_id,ville_id,activite_id)
VALUES
-- photos utilisateurs
('jsp/assets/images/utilisateur/utilisateur-1.jpg','Non applicable','Profil utilisateur',1,NULL,NULL),
('jsp/assets/images/utilisateur/utilisateur-2.jpg','Non applicable','Profil utilisateur',2,NULL,NULL),
('jsp/assets/images/utilisateur/utilisateur-3.jpg','Non applicable','Profil utilisateur',3,NULL,NULL),
('jsp/assets/images/utilisateur/utilisateur-4.jpg','Non applicable','Profil utilisateur',4,NULL,NULL),

-- photos villes
('jsp/assets/images/annecy/annecy-1_2019-02-08.jpg','Libre de droits','Ville',NULL,1,NULL),
('jsp/assets/images/chamonix/chamonix-1_2019-02-08.jpg','Libre de droits','Ville',NULL,2,NULL),
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval-1_2019-02-08.jpg','https://www.flickr.com/photos/pvk/612078062/','Ville',NULL,3,NULL),
('jsp/assets/images/samoens/samoens-1_2019-02-08.jpg','Libre de droits','Ville',NULL,4,NULL),
('jsp/assets/images/evian-les-bains/evian-les-bains-1_2019-02-08.jpg','https://www.flickr.com/photos/bortescristian/7671328860/','Ville',NULL,5,NULL),
('jsp/assets/images/thonon-les-bains/thonon-les-bains-1_2019-02-08.jpg','https://www.flickr.com/photos/sybarite48/9916520663/','Ville',NULL,6,NULL),
('jsp/assets/images/megeve/megeve-1_2019-02-08.jpg','https://www.flickr.com/photos/martinvars/4447867683/','Ville',NULL,7,NULL),
('jsp/assets/images/sallanches/sallanches-1_2019-02-08.jpg','Libre de droits','Ville',NULL,8,NULL),
('jsp/assets/images/lovagny/lovagny-1_2019-02-08.jpg','https://www.flickr.com/photos/mlseguin/43942595092/','Ville',NULL,9,NULL),
('jsp/assets/images/annemasse/annemasse-1_2019-02-08.jpg','Libre de droits','Ville',NULL,10,NULL),

-- photos activités
-- Lac d'Annecy
('jsp/assets/images/annecy/annecy_lac-d-annecy-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,1),
('jsp/assets/images/annecy/annecy_lac-d-annecy-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,1),
('jsp/assets/images/annecy/annecy_lac-d-annecy-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,1),

-- La Vieille Ville
('jsp/assets/images/annecy/annecy_la-vieille-ville-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,2),
('jsp/assets/images/annecy/annecy_la-vieille-ville-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,2),
('jsp/assets/images/annecy/annecy_la-vieille-ville-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,2),

-- Pont des amours
('jsp/assets/images/annecy/annecy_pont-des-amours-1_2019-02-08.jpg','https://www.flickr.com/photos/marcus_hansson/36454379061/','Activité photo principale',NULL,NULL,3),
('jsp/assets/images/annecy/annecy_pont-des-amours-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/42796524951/','Activité photo secondaire',NULL,NULL,3),
('jsp/assets/images/annecy/annecy_pont-des-amours-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/36688736653/','Activité photo secondaire',NULL,NULL,3),

-- Château d'Annecy
('jsp/assets/images/annecy/annecy_chateau-d-annecy-1_2019-02-08.jpg','https://www.flickr.com/photos/camperdown/35586884016/','Activité photo principale',NULL,NULL,4),
('jsp/assets/images/annecy/annecy_chateau-d-annecy-2_2019-02-08.jpg','https://www.flickr.com/photos/camperdown/35458231882/','Activité photo secondaire',NULL,NULL,4),
('jsp/assets/images/annecy/annecy_chateau-d-annecy-3_2019-02-08.jpg','https://www.flickr.com/photos/30701623@N02/2971660666/','Activité photo secondaire',NULL,NULL,4),

-- Palais de l'isle
('jsp/assets/images/annecy/annecy_palais-de-l-isle-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,5),
('jsp/assets/images/annecy/annecy_palais-de-l-isle-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,5),
('jsp/assets/images/annecy/annecy_palais-de-l-isle-3_2019-02-08.jpg','https://www.flickr.com/photos/eurapart/4464444825/','Activité photo secondaire',NULL,NULL,5),

-- Château de Montrottier
('jsp/assets/images/lovagny/lovagny_chateau-de-montrottier-1_2019-02-08.jpg','https://www.flickr.com/photos/mlseguin/43942595092/','Activité photo principale',NULL,NULL,6),
('jsp/assets/images/lovagny/lovagny_chateau-de-montrottier-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/23648798528/','Activité photo secondaire',NULL,NULL,6),
('jsp/assets/images/lovagny/lovagny_chateau-de-montrottier-3_2019-02-08.jpg','https://www.flickr.com/photos/cornelluniversitylibrary/3485981587/','Activité photo secondaire',NULL,NULL,6),

-- Basilique de la Visitation
('jsp/assets/images/annecy/annecy_basilique-de-la-visitation-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,7),
('jsp/assets/images/annecy/annecy_basilique-de-la-visitation-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,7),
('jsp/assets/images/annecy/annecy_basilique-de-la-visitation-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,7),

-- Notre-Dame de Liesse
('jsp/assets/images/annecy/annecy_notre-dame-de-liesse-1_2019-02-08.jpg','https://www.flickr.com/photos/camperdown/34816819323/','Activité photo principale',NULL,NULL,8),
('jsp/assets/images/annecy/annecy_notre-dame-de-liesse-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/38333613595/','Activité photo secondaire',NULL,NULL,8),
('jsp/assets/images/annecy/annecy_notre-dame-de-liesse-3_2019-02-08.jpg','https://www.flickr.com/photos/camperdown/35495303171/','Activité photo secondaire',NULL,NULL,8),

-- Cathédrale Saint-Pierre
('jsp/assets/images/annecy/annecy_cathedrale-saint-pierre-1_2019-02-08.jpg','https://www.flickr.com/photos/renaud-camus/22069471945/','Activité photo principale',NULL,NULL,9),
('jsp/assets/images/annecy/annecy_cathedrale-saint-pierre-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/35334020902/','Activité photo secondaire',NULL,NULL,9),
('jsp/assets/images/annecy/annecy_cathedrale-saint-pierre-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/35114986400/','Activité photo secondaire',NULL,NULL,9),

-- Montagne du Semnoz
('jsp/assets/images/annecy/annecy_montagne-du-semnoz-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,10),
('jsp/assets/images/annecy/annecy_montagne-du-semnoz-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/37790216346/','Activité photo secondaire',NULL,NULL,10),
('jsp/assets/images/annecy/annecy_montagne-du-semnoz-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/41062021170/','Activité photo secondaire',NULL,NULL,10),

-- Voie Verte du Lac d'Annecy
('jsp/assets/images/annecy/annecy_voie-verte-du-lac-d-annecy-1_2019-02-08.jpg','https://www.flickr.com/photos/o_0/40792138575/','Activité photo principale',NULL,NULL,11),
('jsp/assets/images/annecy/annecy_voie-verte-du-lac-d-annecy-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/39884237760/','Activité photo secondaire',NULL,NULL,11),
('jsp/assets/images/annecy/annecy_voie-verte-du-lac-d-annecy-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/15280383142/','Activité photo secondaire',NULL,NULL,11),

-- Jardins de l'Europe
('jsp/assets/images/annecy/annecy_jardins-de-l-europe-1_2019-02-08.jpg','https://www.flickr.com/photos/o_0/37838318331/','Activité photo principale',NULL,NULL,12),
('jsp/assets/images/annecy/annecy_jardins-de-l-europe-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/38194018666/','Activité photo secondaire',NULL,NULL,12),
('jsp/assets/images/annecy/annecy_jardins-de-l-europe-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/44672415770/','Activité photo secondaire',NULL,NULL,12),

-- La Tournette
('jsp/assets/images/annecy/annecy_la-tournette-1_2019-02-08.jpg','https://www.flickr.com/photos/o_0/15157687617/','Activité photo principale',NULL,NULL,13),
('jsp/assets/images/annecy/annecy_la-tournette-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/15157901140/','Activité photo secondaire',NULL,NULL,13),
('jsp/assets/images/annecy/annecy_la-tournette-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/15157688558/','Activité photo secondaire',NULL,NULL,13),

-- Aiguille du Midi
('jsp/assets/images/chamonix/chamonix_aiguille-du-midi-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,14),
('jsp/assets/images/chamonix/chamonix_aiguille-du-midi-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,14),
('jsp/assets/images/chamonix/chamonix_aiguille-du-midi-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,14),

-- Mer de Glace
('jsp/assets/images/chamonix/chamonix_mer-de-glace-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,15),
('jsp/assets/images/chamonix/chamonix_mer-de-glace-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,15),
('jsp/assets/images/chamonix/chamonix_mer-de-glace-3_2019-02-08.jpg','https://www.flickr.com/photos/29477734@N07/16060657317/','Activité photo secondaire',NULL,NULL,15),

-- Mont Blanc
('jsp/assets/images/chamonix/chamonix_mont-blanc-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,16),
('jsp/assets/images/chamonix/chamonix_mont-blanc-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,16),
('jsp/assets/images/chamonix/chamonix_mont-blanc-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,16),

-- Téléphérique du Brévent
('jsp/assets/images/chamonix/chamonix_telepherique-du-brevent-1_2019-02-08.jpg','https://www.flickr.com/photos/84554176@N00/37005229041/','Activité photo principale',NULL,NULL,17),
('jsp/assets/images/chamonix/chamonix_telepherique-du-brevent-2_2019-02-08.jpg','https://www.flickr.com/photos/o_0/15360871555/','Activité photo secondaire',NULL,NULL,17),
('jsp/assets/images/chamonix/chamonix_telepherique-du-brevent-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/30181865098/','Activité photo secondaire',NULL,NULL,17),

-- Eglise Saint Michel 
('jsp/assets/images/chamonix/chamonix_eglise-saint-michel-1_2019-02-08.jpg','https://www.flickr.com/photos/renaud21/35258323493/','Activité photo principale',NULL,NULL,18),
('jsp/assets/images/chamonix/chamonix_eglise-saint-michel-2_2019-02-08.jpg','https://www.flickr.com/photos/renaud21/35240129133/','Activité photo secondaire',NULL,NULL,18),
('jsp/assets/images/chamonix/chamonix_eglise-saint-michel-3_2019-02-08.jpg','https://www.flickr.com/photos/o_0/42240557390/','Activité photo secondaire',NULL,NULL,18),

-- Glacier des Bossons
('jsp/assets/images/chamonix/chamonix_glacier-des-bossons-1_2019-02-08.jpg','Libre de droits','Activité photo principale',NULL,NULL,19),
('jsp/assets/images/chamonix/chamonix_glacier-des-bossons-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,19),
('jsp/assets/images/chamonix/chamonix_glacier-des-bossons-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,19),

-- Vallée Blanche
('jsp/assets/images/chamonix/chamonix_vallee-blanche-1_2019-02-08.jpg','https://www.flickr.com/photos/ruthanddave/111558084/','Activité photo principale',NULL,NULL,20),
('jsp/assets/images/chamonix/chamonix_vallee-blanche-2_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,20),
('jsp/assets/images/chamonix/chamonix_vallee-blanche-3_2019-02-08.jpg','Libre de droits','Activité photo secondaire',NULL,NULL,20),

-- Lac Blanc
('jsp/assets/images/chamonix/chamonix_lac-blanc-1_2019-02-08.jpg','https://www.flickr.com/photos/99459372@N03/14561617307/','Activité photo principale',NULL,NULL,21),
('jsp/assets/images/chamonix/chamonix_lac-blanc-2_2019-02-08.jpg','https://www.flickr.com/photos/rjshade/7951612092/','Activité photo secondaire',NULL,NULL,21),
('jsp/assets/images/chamonix/chamonix_lac-blanc-3_2019-02-08.jpg','https://www.flickr.com/photos/didierbaertschiger/4077831643/','Activité photo secondaire',NULL,NULL,21),

-- Les Grands Montets
('jsp/assets/images/chamonix/chamonix_les-grands-montets-1_2019-02-08.jpg','https://www.flickr.com/photos/fermion/5585135046/','Activité photo principale',NULL,NULL,22),
('jsp/assets/images/chamonix/chamonix_les-grands-montets-2_2019-02-08.jpg','https://www.flickr.com/photos/trailsource/5421644581/','Activité photo secondaire',NULL,NULL,22),
('jsp/assets/images/chamonix/chamonix_les-grands-montets-3_2019-02-08.jpg','https://www.flickr.com/photos/pascal-blachier/2640662366/','Activité photo secondaire',NULL,NULL,22),

-- Aiguilles Rouges
('jsp/assets/images/chamonix/chamonix_aiguilles-rouges-1_2019-02-08.jpg','https://www.flickr.com/photos/o_0/15333972816/','Activité photo principale',NULL,NULL,23),
('jsp/assets/images/chamonix/chamonix_aiguilles-rouges-2_2019-02-08.jpg','https://www.flickr.com/photos/alpiniste/5120505891/','Activité photo secondaire',NULL,NULL,23),
('jsp/assets/images/chamonix/chamonix_aiguilles-rouges-3_2019-02-08.jpg','https://www.flickr.com/photos/rjshade/5966144471/','Activité photo secondaire',NULL,NULL,23),

-- Cirque du Fer à Cheval
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval_cirque-du-fer-a-cheval-1_2019-02-08.jpg','https://www.flickr.com/photos/pvk/612078062/','Activité photo principale',NULL,NULL,24),
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval_cirque-du-fer-a-cheval-2_2019-02-08.jpg','https://www.flickr.com/photos/delaere/3722654203/','Activité photo secondaire',NULL,NULL,24),
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval_cirque-du-fer-a-cheval-3_2019-02-08.jpg','https://www.flickr.com/photos/delaere/3723474724/','Activité photo secondaire',NULL,NULL,24),

-- Cascade du Rouget
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval_cascade-du-rouget-1_2019-02-08.jpg','https://www.flickr.com/photos/girolame/3819004802/','Activité photo principale',NULL,NULL,25),
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval_cascade-du-rouget-2_2019-02-08.jpg','https://www.flickr.com/photos/girolame/3822804694/','Activité photo secondaire',NULL,NULL,25),
('jsp/assets/images/sixt-fer-a-cheval/sixt-fer-a-cheval_cascade-du-rouget-3_2019-02-08.jpg','https://www.flickr.com/photos/christelle-s/29075437856/','Activité photo secondaire',NULL,NULL,25);