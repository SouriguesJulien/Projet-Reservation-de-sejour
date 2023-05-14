# projet-reservation-sejours
De EL HOUARI Bouchra & SOURIGUES Julien

## Introduction

Application de réservation de séjour avec différents modes :
- mode non authentifié
- mode authentifié
- mode hôte

## Répartition de tâches et problèmes rencontrés

Pour ce qui est de la répartition des tâches, nous avons tous les deux fait de tous car nous n'avons pas pu nous répartir les tâches à cause d'une problème sur l'ordinnateur de Julien. Il ne pouvait tout simplement pas run ni build le projet et ceux peut importe l'environnement, du coup nous avons tous les deux travaillé sur l'ordinnateur de Bouchra, ce qui explique qu'elle est la seule à avoir push sur notre Git.

## Ressources
Les fichiers ressources sont au nombre de 5. Nous allons expliquer le contenu de chacun.
> location_en_validation et location_loue semble être les mêmes, sauf que chacun à une utilité.
> - location_en_validation.csv : sert pour les hôtes. Cela permet de voir les locations dont le panier a été validé par les utilisateurs
> - location_loue.csv : sert pour les voyageurs. Cela permet de mettre dans son panier les locations souhaitées.

### _commentaires.csv :_
    private int id;
    private int location_id;    // id de locations.csv
    private int user_id;        // id de utilisateurs.csv
    private String reponse;     // reponse de l'utilisateur pour une location
    private double note;

### _location_en_validation.csv :_
    private int id;
    private int location_id;    // id de locations.csv
    private int user_id;        // id de utilisateurs.csv
    private boolean isValide;   // l'hôte doit valider

### _location_loue.csv :_
    private int id;
    private int location_id;    // id de locations.csv
    private int user_id;        // id de utilisateurs.csv
    private boolean isValide;   // si l'utilisateur peut voir et valider une location

### _locations.csv :_
    private int id;
    private LocalDate startDate;    // debut de la disponibilite de la location
    private LocalDate endDate;      // fin de la disponibilite de la location
    private double price;
    private String location;        // ville de la location
    private String title;           // la localisation (au bord de mer, au centre-ville,...)
    private int numberOfPeople;     // nombre de personne maximum
    private String host_user_id;
    private boolean location_loue;  // Savoir si la location est disponible
    private String urlPhoto;
