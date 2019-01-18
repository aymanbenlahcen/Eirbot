Chatbot Project - BENLAHCEN Ayman_CHEIKH Aymane - ENSEIRB-MATMECA 2018/2019

INTRODUCTION
------------

Ce projet permet à l'utilisateur de discuter avec des chatbots en ligne de commande. Il propose notamment une panoplie de chatbots qui vont permettre à l’utilisateur
de récupérer diverses informations à travers des APIs directement depuis son terminal à travers une session de chat.

CONTENTS
--------

Le fichier zip contient principalement :

    /readme.txt - ce fichier
    /build - les fichiers nécessaires pour la compilation
    /dist - contenant le fichier .jar pour lancer l'application
    /src - contenant deux packages :
		- chatbot : le main de l'application
		- bots : ce fichier contient les différents bots implémentés


DOCUMENTATION & SUPPORT
-----------------------

La documentation des différentes APIs implémentés se trouve dans les liens suivants :
	- http://www.icndb.com/
	- https://opentdb.com/api_config.php
	- https://api.ipify.org?format=json
	- https://api.adviceslip.com/advice
	- https://www.boredapi.com
	- https://breaking-bad-quotes.herokuapp.com/v1/quotes
	

ARCHITECTURE DU PROJET
-------------------
Le projet est principalemnt divisé en deux packages. Le package Chatbot contenant le main du projet, une classe UserInterface qui gère l'interface utilisateur et une
autre classe qui s'occupe des requêtes HTTP. Le deuxième package est le package bots lequel contient une classe consacré à chaque bot implémenté ainsi qu'une classe
Gestionnaire qui permet de gérer tous ces bots à l'aide d'un HashMap. Le HashMap rend facile l'ajout et la suppression des bots. 

REMARQUES
--------------------- 
Un bot "@help" donne une description de tous les bots implémentés. Il est à noter que pour icndb et quiz, Il faut taper "@icndb " au lieu de "@icndb" et "@quiz " 
au lieu de "@quiz" au cas où ces deux bots ne prennent pas d'arguments. Lorsque ces deux bots ne prennent pas des arguments, tout se passe normalement.