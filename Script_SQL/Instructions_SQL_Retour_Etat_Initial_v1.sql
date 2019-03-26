DELETE FROM public.photo WHERE id>89;
ALTER SEQUENCE photo_id_seq RESTART 90;

DELETE FROM public.formulaire_contact WHERE id>6;
ALTER SEQUENCE formulaire_contact_id_seq RESTART 7;

DELETE FROM public.avis WHERE id>20;
ALTER SEQUENCE avis_id_seq RESTART 21;

DELETE FROM public.coordonnee_gps WHERE id>35;
ALTER SEQUENCE coordonnee_gps_id_seq RESTART 36;

DELETE FROM public.activite_type_activite WHERE activite_id>25;

DELETE FROM public.activite WHERE id>25;
ALTER SEQUENCE activite_id_seq RESTART 26;

DELETE FROM public.utilisateur WHERE id>4;
ALTER SEQUENCE utilisateur_id_seq RESTART 5;