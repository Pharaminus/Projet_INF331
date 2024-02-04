--------------PROJET INF 331-------------------

------------------------------------------------
GROUPE 56: NOMS ET MATRICULES DES MEMBRES<<<<<<<
------------------------------------------------
AMBOMO TIGA GEDEON                      21T2496
BABALEKAMEN BABATACK LANDRY (chef)      21T2660
SAHA KEUATSOP PIERRE AIME               21T2394
BAYE RUTH                               15U2912
TAGNE TALLA IDRISS CHANEL               19M2351

-----------------------------------------------
Lancement standard (sans docker, en local)<<<<<
-----------------------------------------------

1 - Ouvrir le dossier et executer la class 'OrientationStudentApplication.java' pour lancer l'application;
2 - Ouvrir le dossier 'Test data' et executer les script SQL afin approvionner la BDD;
3 - Tester l'application via l'adresse 'localhost:8080/login/form' et entrer l'email 'test@gmail.com' et le mot de passe 'test';
4 - Click sur le bouton 'Access to' du carroussel de titre 'JOB PREDICTION' puis entrer les notes pour obtenir une prediction.

--------------------------
Lancement avec Docker <<<<
--------------------------

NB: arreter le server local MySQL ou changer de port (qu'il soit different de 3306)

1 - Creer un reseau specifique pour nos container via la commande :

=========>>>>> docker network create studor_network

2 -Creer et lancer le container de la BDD MySQL via la commande :

=========>>>>> docker run --name mysql_studor -p 3306:3306 --network studor_network -e MYSQL_DATABASE=app_db -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

3 - Ouvrir le dossier 'Test data' et executer les script SQL afin approvionner la BDD;

4 - Creer et lancer le container de l'application via la commande :

=========>>>>> docker run --network studor_network --name studor_container -p 8080:8080 -d studor_image