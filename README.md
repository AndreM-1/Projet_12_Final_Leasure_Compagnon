### Projet 12 : Leasure Compagnon.

### 2 projets Maven ont été implémentés pour le projet 12 : 
-   1 pour l'application web côté client
-   1 pour les web services côté serveur de services

### L'application web est divisée en 5 sous-modules :

-   leasure-compagnon-business
-   leasure-compagnon-consumer
-   leasure-compagnon-model
-   leasure-compagnon-technical
-   leasure-compagnon-webapp

### L'application pour les web services est divisée en 6 sous-modules :

-   leasure-compagnon-ws-batch
-   leasure-compagnon-ws-business
-   leasure-compagnon-ws-consumer
-   leasure-compagnon-ws-model
-   leasure-compagnon-ws-technical
-   leasure-compagnon-ws-webapp

Ces applications ont été packagées avec Apache Maven 3.5.3.

### Mise en place de la base de données PostgreSQL 9.6 via Docker Toolbox.

La base de données PostgreSQL 9.6 avec la structure et le jeu de données de démo sera mise en place via Docker Toolbox.

En cas d'utilisation de Docker Toolbox en local, il faut vérifier les points suivants :

-   Le présent projet doit être installé dans la sous arborescence du répertoire C:\Users.
-   Ne pas oublier en vue d'instancier le conteneur de se placer dans le répertoire docker\dev (où se trouve le fichier docker-compose.yml), puis de lancer la commande docker-compose up, et finalement de modifier le HOSTNAME via Kitematic dans Settings -> Hostname / Ports -> Configure Hostname -> HOSTNAME.
-   Les scripts SQL de création de la base de données et d'insertion du jeu de données de démo sont disponibles dans le répertoire docker\dev\init\db\docker-entrypoint-initdb.d (à noter que ces fichiers sont également présent dans le répertoire script-SQL à titre informatif).
-   Dans le cas où le conteneur existe déjà, il faut s'assurer qu'il est bien en cours d'exécution. Si ce n'est pas le cas, il faut utiliser la commande : docker container start CONTAINER ID.
-   A chaque fois qu'on accède à la base de données depuis l'application pour les web services que ce soit pour les tests d'intégration depuis le module business ou alors depuis le module webapp, il faut que les fichiers de configuration respectifs, à savoir src\test-business\resources\db-sileasurecompagnon.properties et META-INF\context.xml soient en accord avec la configuration du conteneur docker.

### Déploiement de l'application pour les Web Services

L'application relative aux web services leasure-compagnon-ws-webapp.war est à déployer sur un serveur Apache Tomcat 9. Rappelons que seuls les web services peuvent se connecter à la base de données.

### Déploiement de l'application web

L'application web leasure-compagnon-webapp.war est à déployer sur un serveur Apache Tomcat 9. Cette application fera appel aux web services. 
Le fichier leasure-compagnon-webapp.war\META-INF\context.xml contient les adresses des web services.

### Déploiement du batch

Le module batch figure dans l'application relative aux web services, mais il ne dépend que des modules model et technical. Il fera donc lui aussi appel aux web services.
Le module batch permet d'envoyer divers types de mail aux usagers :
-   Des mails pour les tenir informer des dernières activités mises en ligne.
-	Des mails de confirmation ou de refus pour leur indiquer si le(s) activité(s) qu’ils ont postées ont été mises en ligne ou non.

Voici les étapes à suivre pour déployer le module batch : 

-   Décompresser le fichier leasure-compagnon-ws-batch-1.0-SNAPSHOT-archive-deploy.zip
-   Entrer dans le répertoire leasure-compagnon-ws-batch-1.0-SNAPSHOT
-   Vous pouvez configurer le batch via le fichier conf\config.properties : adresses des web services, contenu du mail, périodicité des mails, configuration du serveur SMTP Gmail.
-   Ouvrir l'invite de commandes depuis le répertoire leasure-compagnon-ws-batch-1.0-SNAPSHOT
-   Vous pouvez soit créer une variable d'environnement BATCH_HOME qui contient le chemin complet jusqu'au répertoire leasure-compagnon-ws-batch-1.0-SNAPSHOT ou alors exécuter la ligne
de commande suivante en renseignant directement sa valeur : java -DBATCH_HOME=D:\...\leasure-compagnon-ws-batch-1.0-SNAPSHOT -jar lib/leasure-compagnon-ws-batch-1.0-SNAPSHOT.jar

### Projet SOAP UI

Les fichiers relatifs au projet SOAP UI pour tester les web services sont dans le répertoire SOAP_UI.