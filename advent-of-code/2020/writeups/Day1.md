# Jour 1 - *Report Repair*

## Enoncé

### Partie 1

Trouver deux nombres parmi les entrées (cf. ci-dessous) dont la somme vaut
`2020`. Renvoyer leur produit.

```
1721
979
366
299
675
1456
```

Exemple: `1721` et `299` dont le produit vaut `514579`.


### Partie 2

Trouver trois nombres parmi les entrées dont la somme vaut `2020`. Renvoyer
leur produit.

Exemple: `979`, `366` et `675` dont le produit vaut `241861950`.


## Solutions - Partie 1

### Solution n°0 - Complexité `O(n²)`

Tester tous les couples de la liste pour déterminer une solution.

```python
for each x in l do
	for each y in l do
		if x != y && x + y == 2020 then
			return x * y
```

La complexité est alors de `O(n²)`, on peut par ailleurs améliorer le
*coefficient* du O avec :

```python
for each x in l do
	for each y in l.after(x) do
		if x != y && x + y == 2020 then
			return x * y
```

`l.after(x)` étant la sous-liste des éléments suivant `x` dans la liste (on
pourrait de façon équivalente démarrer avec les indices strictement supérieurs
à celui de `x`).

La complexité est ici alors de `O(n * (n+1) / 2)` (dénombrement `n + (n-1) +
... + 1` ) qui est équivalent à `O(n²)`.


### Solution n°1 - Complexité `O(n * ln n)`

Trier les entrées et prendre un indice `i <- 0` au début de la liste et un
indice `j <- list.size - 1` à la fin de la liste.  Il suffit alors
d'incrémenter `i` si la somme n'est pas assez grande ou de décrémenter `j` si
la somme est trop grande par rapport à `2020`.

```python
l.sort()

i = 0
j = l.size - 1

while l[i] + l[j] != 2020 do
	if l[i] + l[j] < 2020 then
		i++
	else if l[i] + l[j] > 2020 then
		j--
	else
		return l[i] * l[j]
```

La complexité plus précisément est de `O(n * ln n)` pour le tri et `O(n)` pour
la boucle `while`, finalement on a `O(n * ln n)`.


### Solution n°2 - Complexité `O(n)`

Utiliser la structure de données *ensemble* qui permet de tester en `O(1)` pour
chaque valeur de la liste si `2020 - valeur` existe.

```python
s = l.toSet()

for each x in s do
	if 2020 - x in s then
		return (2020 - x) * x
```

La complexité est `n` fois un test en `O(1)` soit `O(n)`.


## Solutions - Partie 2

### Solution n°0 - Complexité `O(n³)`

De même que la solution n°0 de la partie 1, on va chercher le premier triplet
de nombres dont la somme vaut `2020`.

```python
for each x in l do
	for each y in l do
		for each z in l do
			if x != y != z && x + y + z == 2020 then
				return x * y * z
```

De même, une amélioration possible est :

```python
for each x in l do
	for each y in l.after(x) do
		for each z in l.after(y) do
			if x != y != z && x + y + z == 2020 then
				return x * y * z
```


### Solution n°1 - Complexité `O(n²)`

De même que la solution n°1 de la partie 1, on va chercher un couple dont la
somme vaut `2020 - x` avec `x` parcourant tous les éléments de la liste triée.

```python
l.sort()

for k in l.indices do
	 = l[k]
	i = k+1
	j = l.size - 1

	while l[i] + l[j] != 2020 - x do
		if l[i] + l[j] < 2020 - x then
			i++
		else if l[i] + l[j] > 2020 - x then
			j--
		else
			return l[i] * l[j] * x
```

La complexité est `O(n * ln n)` pour le tri et `O(n * (n+1) / 2)` pour les
tours de boucles, on a alors une complexité `O(n²)`.


### Solution n°2 - Complexité `O(n²)`

De même que la solution n°2 de la partie 1, on utilise un *ensemble* afin
d'optimiser la recherche de `2020 - x - y` pour tout `(x, y)` dans `liste²`.

```python
s = l.toSet()

for each x in s do
	for each y in s do
		if 2020 - x - y in s then
			return (2020 - x - y) * x * y
```
