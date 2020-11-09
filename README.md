# TravelFinder
## Présentation :

TravelFinder est une application Android développée à l'aide du langage Kotlin. 
Elle permet de suggérer des destinations de voyage à l'utilisateur, le tout trié par continent.

![Capture1](https://raw.githubusercontent.com/Tabernaq/TravelFinder/master/img/capture1.png)

## Fonctionnalités :

### - Menu horizontal :
Afin de pouvoir parcourir les diverses destinations proposées par TravelFinder, l'utilisateur peut choisir le continent de son choix grâce à un menu horizontal fait avec un composant natif : TabLayout

![Capture2](https://raw.githubusercontent.com/Tabernaq/TravelFinder/master/img/capture2.png)

### - Système de cartes :
Chaque destination est affiché dans une carte :

![Capture3](https://raw.githubusercontent.com/Tabernaq/TravelFinder/master/img/capture3.png)

Chaque carte est divisé en trois parties :
- Une image montrant la destination
- Le nom de la destination
- Une bref description de la destination


Chacune de ces cartes sont stockés dans un RecyclerView, ce qui permet d'afficher toutes les cartes dans une liste

## Architecture :

### - Affichage : 

L'architecture de l'affichage se compose de la manière suivante :

![Capture4](https://raw.githubusercontent.com/Tabernaq/TravelFinder/master/img/capture4.png)

- Un TabLayout qui permet d'afficher la barre de navigation
- Un FrameLayout qui permet d'afficher les listes de cartes

Le tout imbriqué dans un ConstraintLayout

### - Base de données : 

Afin de pouvoir afficher les données de chaque destination, toutes les informations sont stockées dans une base de données. La base de données est composés d'une seule table contenant les attributs suivants : 
- id qui est la clé primaire
- nom qui correspond au nom de la destination
- desc qui correspond à la description de la destination
- src_img qui correspond au lien de l'image
- ville qui correspond au nom de la ville de la destination
- continent qui correspond au continent de la description

