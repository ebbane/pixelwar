<h1 align="center">PixelWar Websocket</h1>

  <div align="center">
    <strong>M2 Informatique</strong>
    <br />
    <a href="https://github.com/ebbane/pixelwar"><strong>Explore le repo</strong></a>
    <br />
    <br />
    ·
    <a href="https://www.java.com/fr/">Java 17</a>
  </div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table des matières</summary>
  <ol>
    <li>
      <a href="#a-propos-du-projet">A propos du projet</a>
      <ul>
        <li><a href="#construit-avec">Construit avec</a></li>
      </ul>
    </li>
    <li>
      <a href="#commencer">Commencer</a>
      <ul>
        <li><a href="#prérequis">Prérequis</a></li>
        <li><a href="#installations">Installations</a></li>
      </ul>
    </li>
    <li>
      <a href="#commandes-utiles">Commandes utiles</a>
    </li>
    <li>
      <a href="#contact">Contact</a>
    </li>
  </ol>
</details>

## A propos du projet

Le but du projet est de découvrir et de mettre en place un serveur websocket pour l'utiliser via un
client et envoyer des positions de pixel.

### Construit avec

Ce projet est construit avec les logiciels, et applications suivantes :

* [Docker](https://www.docker.com/)
* [Java](https://www.java.com/fr/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [PostgreSQL](https://www.postgresql.org/)
* [Websocket](https://developer.mozilla.org/fr/docs/Web/API/WebSockets_API)
* [Github](https://github.com/)
* [IntelliJ IDEA](https://www.jetbrains.com/fr-fr/idea/)

<p align="right">(<a href="#top">Retour en haut</a>)</p>

## Commencer

Mise en place du projet en local pour les utilisateurs

### Prérequis

Ce projet nécéssite quelques installations de pré-lancement.

* [docker desktop](https://docs.docker.com/desktop/)

ou

* [Java 17](https://www.java.com/fr/download/)
* [Maven](https://maven.apache.org/install.html)

### Installations

Instructions à suivre (conseillé) pour le lancement du projet en local.

#### Avec docker

1. Lancer docker sur son environnement
2. Cloner le repo (ou dézipper le dossier)
   ```sh
   git git@github.com:ebbane/pixelwar.git
   ```
3. Lancer la démo (via docker) :
   ```sh
   cd pixelwar
   docker-compose up -d
   ```

#### Avec maven

1. Lancer localement une base de donnée postgres
2. Cloner le repo (ou dézipper le dossier)
   ```sh
   git clone git@github.com:ebbane/pixelwar.git
   ```

2. Pour lancer la demo vous avez deux possibilitées :

    1. générer un nouveau jar
   ````sh
       mvn clean package
       java -jar target/pixelwar.jar
   ````

    2. lancer l'application via spring
   ```` sh
       mvn clean install -DskipTests=true
       mvn spring-boot:run
   ````

## Utilisation

ouvrir le fichier index.html ou alors rendez vous à l'url : "http://localhost:8080/"

## Commandes utiles

1. Vérifier les images docker disponible
   ```sh
      docker images -a
    ```
3. Supprimer une image docker
   ```sh
      docker rmi <image_id>
    ```

<p align="right">(<a href="#top">Retour en haut</a>)</p>

## Contact

Ebbane DIET - ebbane.diet@ynov.com - support (À contacter si un problème survient au lancement)

Github : [@ebbane](https://github.com/ebbane)

<p align="right">(<a href="#top">Retour en haut</a>)</p>
