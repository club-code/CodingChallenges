# Jour 2 - Password Philosophy

## Enoncé

### Partie 1

Vérifier que chaque mot de passe a bien l'occurence d'une lettre comprise dans
un intervalle. Renvoyer le nombre de mots de passe validant ce critère.

```
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
```

Par exemple `a` doit être présente entre `1` et `3` fois inclus dans le mot de
passe `abcde`, ici ce mot de passe est correct. Et en tout, `2` mot de passe le
sont.


### Partie 2

Vérifier que chaque mot de passe a bien une position sur 2 (exclusivement) égale
à une lettre. Renvoyer le nombre de mots de passe validant ce critère.

```
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
```

Par exemple `a` doit être présente à la position `1` OU `3` dans le mot de passe
`abcde`, ici ce mot de passe est correct. Et en tout, `1` mot de passe l'est.


## Solutions - Partie 1

### Solutions n°0 - Complexité `O(n)`

Itérer sur chacun des mots de passe et compter si l'occurrence du caractère est
dans l'intervalle.

```python
i = 0
for line in l do
	if line.password.countCharacter(line.character) in line.interval then
		i++
return i
```

Qui peut s'écrire en fonctionnel :

```python
return l.count{ line.password.count{ line.character } in line.interval }
```

La complexité est la somme des tailles des mots de passe, qui est environ
proportionnel au nombre de ligne (si une taille maximale existe) soir `O(n)`.


## Solutions - Partie 2

### Solutions n°0 - Complexité `O(n)`

Itérer sur chacun des mots de passe et vérifier si l'un ou l'autre (OU exclusif
aka xor) est le caractère.

```python
i = 0
for line in l do
	if line.password[line.interval.first] == line.character xor
			line.password[line.interval.last] == line.character then
		i++
return i
```

La complexité est le nombre de ligne `O(n)`.
