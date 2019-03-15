DELETE FROM public.photo WHERE id>89;
ALTER SEQUENCE photo_id_seq RESTART 90;

DELETE FROM public.formulaire_contact WHERE id>6;
ALTER SEQUENCE formulaire_contact_id_seq RESTART 7;

DELETE FROM public.utilisateur WHERE id>4;
ALTER SEQUENCE utilisateur_id_seq RESTART 5;