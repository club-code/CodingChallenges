# Day 1

## Step 1

*123 caractères*

La première ligne `I=input` permet de définir une fonction `I` qui aura le même effet qu'`input`.
C'est assez fréquent en code golf Python lorsque que la fonction `input` doit être utilisée plus de 3 fois.

Les deux lignes suivantes lisent d'abord le nombre de lignes puis chacune de ces lignes, en les convertissant au passage en entier.
On note la petite astuce `"a"*n` qui est plus court que `range(n)` si on ne se sert pas de l'indice de la boucle.

Dans la suivante, on utilise `itertools.combinations` pour trouver toutes les combinaisons de 2 nombres de l'entrée.
Comme on n'utilise cette fonction qu'une seule fois dans le code, utiliser le mot clé `import` habituel prendrait plus de place.
Ici on utilise donc la fonction Python `__import__("nom du module")`.

Enfin, la dernière ligne regarde si la condition de l'énoncé est remplie ou non.
On remarque l'utilisation de `input` au lieu de `print` pour afficher le résultat.
En effet, comme il n'y a qu'une seule ligne à afficher, `input` permet d'afficher son contenu puis le programme crash car aucune entrée supplémentaire ne lui est envoyée.

## Step 2

*129 caractères*

Il n'y a presque rien qui change, juste la taille des combinaisons qui passe de 2 à 3,
et l'utilisation de 3 variables a, b et c.