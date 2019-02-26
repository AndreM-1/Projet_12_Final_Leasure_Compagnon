
CREATE SEQUENCE public.statut_activite_avis_id_seq;

CREATE TABLE public.statut_activite_avis (
                id INTEGER NOT NULL DEFAULT nextval('public.statut_activite_avis_id_seq'),
                statut_activite_avis VARCHAR(50) NOT NULL,
                CONSTRAINT statut_activite_avis_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.statut_activite_avis_id_seq OWNED BY public.statut_activite_avis.id;

CREATE SEQUENCE public.saison_id_seq;

CREATE TABLE public.saison (
                id INTEGER NOT NULL DEFAULT nextval('public.saison_id_seq'),
                nom_saison VARCHAR(50) NOT NULL,
                CONSTRAINT saison_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.saison_id_seq OWNED BY public.saison.id;

CREATE SEQUENCE public.duree_id_seq;

CREATE TABLE public.duree (
                id INTEGER NOT NULL DEFAULT nextval('public.duree_id_seq'),
                duree_conseillee VARCHAR(50) NOT NULL,
                CONSTRAINT duree_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.duree_id_seq OWNED BY public.duree.id;

CREATE SEQUENCE public.type_activite_id_seq;

CREATE TABLE public.type_activite (
                id INTEGER NOT NULL DEFAULT nextval('public.type_activite_id_seq'),
                type_activite VARCHAR(50) NOT NULL,
                CONSTRAINT type_activite_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.type_activite_id_seq OWNED BY public.type_activite.id;

CREATE SEQUENCE public.pays_id_seq;

CREATE TABLE public.pays (
                id INTEGER NOT NULL DEFAULT nextval('public.pays_id_seq'),
                nom_pays VARCHAR(20) NOT NULL,
                CONSTRAINT pays_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.pays_id_seq OWNED BY public.pays.id;

CREATE SEQUENCE public.region_id_seq;

CREATE TABLE public.region (
                id INTEGER NOT NULL DEFAULT nextval('public.region_id_seq'),
                nom_region VARCHAR(50) NOT NULL,
                pays_id INTEGER NOT NULL,
                CONSTRAINT region_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.region_id_seq OWNED BY public.region.id;

CREATE SEQUENCE public.departement_id_seq;

CREATE TABLE public.departement (
                id INTEGER NOT NULL DEFAULT nextval('public.departement_id_seq'),
                nom_departement VARCHAR(50) NOT NULL,
                region_id INTEGER NOT NULL,
                CONSTRAINT departement_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.departement_id_seq OWNED BY public.departement.id;

CREATE SEQUENCE public.ville_id_seq;

CREATE TABLE public.ville (
                id INTEGER NOT NULL DEFAULT nextval('public.ville_id_seq'),
                nom_ville VARCHAR(50) NOT NULL,
                code_postal CHAR(5) NOT NULL,
                description VARCHAR(800) NOT NULL,
                nb_habitant INTEGER NOT NULL,
                departement_id INTEGER NOT NULL,
                CONSTRAINT ville_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.ville_id_seq OWNED BY public.ville.id;

CREATE UNIQUE INDEX ville_idx
 ON public.ville
 ( nom_ville, code_postal );

CREATE SEQUENCE public.utilisateur_id_seq;

CREATE TABLE public.utilisateur (
                id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_seq'),
                civilite VARCHAR(8) NOT NULL,
                nom VARCHAR(50) NOT NULL,
                prenom VARCHAR(50) NOT NULL,
                pseudo VARCHAR(20) NOT NULL,
                adresse_mail VARCHAR(50) NOT NULL,
                salt CHAR(30) NOT NULL,
                mot_de_passe_securise CHAR(44) NOT NULL,
                date_inscription TIMESTAMP NOT NULL,
                telephone CHAR(14),
                date_naissance DATE,
                adresse VARCHAR(100),
                code_postal VARCHAR(10),
                ville VARCHAR(100),
                pays VARCHAR(100),
                envoi_mail_informatif BOOLEAN NOT NULL,
                administrateur BOOLEAN NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;

CREATE UNIQUE INDEX utilisateur_idx
 ON public.utilisateur
 ( pseudo );

CREATE UNIQUE INDEX utilisateur_idx1
 ON public.utilisateur
 ( adresse_mail );

CREATE UNIQUE INDEX utilisateur_idx2
 ON public.utilisateur
 ( salt );

CREATE UNIQUE INDEX utilisateur_idx3
 ON public.utilisateur
 ( mot_de_passe_securise );

CREATE SEQUENCE public.activite_id_seq;

CREATE TABLE public.activite (
                id INTEGER NOT NULL DEFAULT nextval('public.activite_id_seq'),
                nom_activite VARCHAR(50) NOT NULL,
                description VARCHAR(800) NOT NULL,
                adresse VARCHAR(100),
                lien_horaire_ouverture VARCHAR(300),
                date_demande_ajout TIMESTAMP NOT NULL,
                date_moderation_admin TIMESTAMP,
                date_mise_en_ligne TIMESTAMP,
                utilisateur_id INTEGER NOT NULL,
                ville_id INTEGER NOT NULL,
                duree_id INTEGER NOT NULL,
                saison_id INTEGER NOT NULL,
                statut_activite_avis_id INTEGER NOT NULL,
                CONSTRAINT activite_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.activite_id_seq OWNED BY public.activite.id;

CREATE TABLE public.activite_type_activite (
                activite_id INTEGER NOT NULL,
                type_activite_id INTEGER NOT NULL,
                CONSTRAINT activite_type_activite_pk PRIMARY KEY (activite_id, type_activite_id)
);


CREATE SEQUENCE public.coordonnee_gps_id_seq;

CREATE TABLE public.coordonnee_gps (
                id INTEGER NOT NULL DEFAULT nextval('public.coordonnee_gps_id_seq'),
                latitude NUMERIC(8,6) NOT NULL,
                longitude NUMERIC(7,6) NOT NULL,
                ville_id INTEGER,
                activite_id INTEGER,
                CONSTRAINT coordonnee_gps_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.coordonnee_gps_id_seq OWNED BY public.coordonnee_gps.id;

CREATE SEQUENCE public.avis_id_seq;

CREATE TABLE public.avis (
                id INTEGER NOT NULL DEFAULT nextval('public.avis_id_seq'),
                commentaire VARCHAR(500) NOT NULL,
                appreciation VARCHAR(20) NOT NULL,
                date_poste_avis TIMESTAMP NOT NULL,
                date_moderation_admin_avis TIMESTAMP,
                date_mise_en_ligne_avis TIMESTAMP,
                utilisateur_id INTEGER NOT NULL,
                activite_id INTEGER NOT NULL,
                statut_activite_avis_id INTEGER NOT NULL,
                CONSTRAINT avis_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.avis_id_seq OWNED BY public.avis.id;

CREATE SEQUENCE public.formulaire_contact_id_seq;

CREATE TABLE public.formulaire_contact (
                id INTEGER NOT NULL DEFAULT nextval('public.formulaire_contact_id_seq'),
                nom_na VARCHAR(50),
                adresse_mail_na VARCHAR(50),
                objet VARCHAR(50) NOT NULL,
                message VARCHAR(500) NOT NULL,
                date_form_contact TIMESTAMP NOT NULL,
                utilisateur_id INTEGER,
                CONSTRAINT formulaire_contact_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.formulaire_contact_id_seq OWNED BY public.formulaire_contact.id;

CREATE SEQUENCE public.photo_id_seq;

CREATE TABLE public.photo (
                id INTEGER NOT NULL DEFAULT nextval('public.photo_id_seq'),
                nom_photo VARCHAR(200) NOT NULL,
                provenance_photo VARCHAR(300) NOT NULL,
                type_photo VARCHAR(30) NOT NULL,
                utilisateur_id INTEGER,
                ville_id INTEGER,
                activite_id INTEGER,
                CONSTRAINT photo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.photo_id_seq OWNED BY public.photo.id;

CREATE UNIQUE INDEX photo_idx
 ON public.photo
 ( nom_photo );

ALTER TABLE public.activite ADD CONSTRAINT statut_activite_avis_activite_fk
FOREIGN KEY (statut_activite_avis_id)
REFERENCES public.statut_activite_avis (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.avis ADD CONSTRAINT statut_activite_avis_avis_fk
FOREIGN KEY (statut_activite_avis_id)
REFERENCES public.statut_activite_avis (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activite ADD CONSTRAINT saison_activite_fk
FOREIGN KEY (saison_id)
REFERENCES public.saison (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activite ADD CONSTRAINT duree_activite_fk
FOREIGN KEY (duree_id)
REFERENCES public.duree (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activite_type_activite ADD CONSTRAINT type_activite_activite_type_activite_fk
FOREIGN KEY (type_activite_id)
REFERENCES public.type_activite (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.region ADD CONSTRAINT pays_region_fk
FOREIGN KEY (pays_id)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.departement ADD CONSTRAINT region_departement_fk
FOREIGN KEY (region_id)
REFERENCES public.region (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ville ADD CONSTRAINT departement_ville_fk
FOREIGN KEY (departement_id)
REFERENCES public.departement (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT ville_photo_fk
FOREIGN KEY (ville_id)
REFERENCES public.ville (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activite ADD CONSTRAINT ville_activite_fk
FOREIGN KEY (ville_id)
REFERENCES public.ville (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.coordonnee_gps ADD CONSTRAINT ville_coordonnee_fk
FOREIGN KEY (ville_id)
REFERENCES public.ville (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT utilisateur_photo_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.formulaire_contact ADD CONSTRAINT utilisateur_formulaire_contact_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.avis ADD CONSTRAINT utilisateur_avis_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activite ADD CONSTRAINT utilisateur_activite_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT activite_photo_fk
FOREIGN KEY (activite_id)
REFERENCES public.activite (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.avis ADD CONSTRAINT activite_avis_fk
FOREIGN KEY (activite_id)
REFERENCES public.activite (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.coordonnee_gps ADD CONSTRAINT activite_coordonnee_fk
FOREIGN KEY (activite_id)
REFERENCES public.activite (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.activite_type_activite ADD CONSTRAINT activite_activite_type_activite_fk
FOREIGN KEY (activite_id)
REFERENCES public.activite (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
