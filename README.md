# CodingChallenges

Dépôt contenant les essais de corrections/solutions des exercices de différents concours/batailles de code et ce dans différents langages.

## Structure du projet

La racine du projet contient un répertoire par concours/batailles de code, qui sont eux mêmes structurés sous la forme ci-dessous 
:
```
├── advent-of-code
│   └── 2020
│       ├── jvm
```

Chaque langage a sa propre structure de dossier qui doit être identique afin de simplifier la prise en main. Toutes les instructions nécessaires à l'exécution des tests.

Les solutions doivent récupérer les entrées par le **stdin** (Entrée standard) et donner les réponses par le **stdout** (Sortie standard). En effet, il est important d'assurer la compatibilité des exécutions et **TOUS** les concours utilisent, pour leurs plateformes automatisées, les entrées/sorties standards.

Attention, ces structures et instructions sont vouées à évoluer au cours du temps.


### JVM

#### Structure

Ce sont des projets [Gradle](https://gradle.org/) avec une structure qui est défini ci-dessous. On notera la présence de *package* pour chacun des exercices. Ainsi les fonctions/classes nécessaires (main) et les tests (test) se trouvent dans ce *package*. De plus les resources de tests se trouvent sous la même hiérarchie mais ici dans un simple dossiers du même nom que le *package*.

```
└── src
    ├── main
    │   ├── java
    │   ├── kotlin
    │   │   ├── day1
    │   │   ├── day9
    │   │   └── library
    │   └── resources
    └── test
        ├── java
        ├── kotlin
        │   ├── day1
        │   └── day9
        └── resources
            ├── day1
            └── day9
```

##### Du nommage des packages

Chaque package doit reprendre la terminologie du concours (dans l'exemple *day*), on prendra par défaut *exercise* suivi du numéro de l'exercice.

#### Exécution des tests

Ce sont des tests [JUnit4](https://junit.org/junit4/), qui peuvent être facilement exploitable par votre IDE favoris, sinon en ligne de commande avec *gradlew*.

Les commandes Gradle utilisent un fichier présent dans chaque projet nommé *gradlew* sous Linux et *gradlew.bat*.

Afin d'exécuter tous les tests, on utilisera `./gradlew :test`. On remarque que les tests ne sont pas verbeux par défaut, seuls les erreurs sont présentées.

Afin d'exécuter toute une classe de test, on utilisera `./gradlew :test --tests "PACKAGE.CLASSE_DE_TEST"` par exemple `./gradlew :test --tests "day1.Day"`.

Afin d'exécuter une méthode de test, on utilisera `./gradlew :test --tests "PACKAGE.CLASSE_DE_TEST.METHODE` par exemple `./gradlew --tests "day1.Day.testSample"`.

#### Structure des tests

Les tests utilise une bibliothèque crée pour l'occasion [library-kotlin](https://github.com/club-code/library-kotlin) dont une classe *GenericTest*. Elle permet de tester avec deux URI d'un fichier d'entrée et d'un fichier de sortie que l'on souhaite comparer (méthode `genericTest`). 
Elle permet de récupérer avec une URI d'un fichier d'entrée, la réponse au problème (méthode `genericTry`).

