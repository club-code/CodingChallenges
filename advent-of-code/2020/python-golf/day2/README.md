# Day 1

## Step 1

*123 caractères*

La première ligne `I=input` permet de définir une fonction `I` qui aura le même effet qu'`input`.

La ligne suivante lis d'abord le nombre de lignes `n` et initialise un compteur `c` à 0.
On effectue ensuite une boucle n fois et on lis chaque ligne.

Par défaut, la fonction `split` par défaut découpe une chaîne de caractères sur les espaces.
La variable `r` vaudra donc par exemple `1-3`, `l` vaudra `a:` et `p` contiendra le mot de passe.

En Python, les booléens sont une sous-classe des entiers. Dans une opération arithmétique, `True` vaudra 1 et `False` 0.
Ici, on va donc ajouter 1 à `c` si le nombre d'occurences du caractère `l[0]` dans `p` est inclus dans le `range`.
Pour créer ce `range`, on coupe `r` selon le caractère `-`, on applique la fonction `int` à chaque élément de la liste qu'on obtient
(grâce à la fonction `map`), et on récupère les deux éléments dans les variables a et b. Puis on crée un `range` de a à b+1 exclu (donc b inclu).
Ainsi on transforme `1-3` en un `range` contenant `[1,2,3]`.

On remarque l'utilisation d'un point-virgule au lieu d'un retour à la ligne, qui nous permet d'éviter l'espace d'indentation du `for`.

## Step 2

*124 caractères*

Le début du code est le même.

Après avoir lu les variables a, b, l et p, on teste les deux positions a et b et on effectue l'opération `^` (ou exclusif).
Cette opération retournera 0 si les deux conditions sont vraies ou si les deux sont fausses, et 1 si les deux conditions ont une valeur différente.
Ainsi, on remplit la condition "seulement l'un des deux index dans `p` vaut la lettre `l`"