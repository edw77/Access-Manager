# Access-Manager
Application de gestion des accès de l'ESIGELEC

Permet de gérer virtuellement les accès aux portes électroniques de l'ESIGELEC par profil. On peut donc :
* Lister, ajouter, supprimer ou modifier des portails/salles (lieux)
* Créer, modifier ou supprimer des personnes dans la base de données
* Créer ou supprimer des badges virtuels associés à des personnes
* Créer et attribuer des accès à des profils, et également les lister
* Attribuer un profil à une personne

Repose sur une base de donnée Oracle qui n'est plus disponible 
Modifier le fichier src/bdd/ConnexionDAO.java et le diriger vers une autre base de donnée pour résoudre le problème
Requiert le pilote Oracle jdbc
