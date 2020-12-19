# Python code golf

## Comment lancer le code ?

Vous devez avoir [pipenv](http://sametmax.com/pipenv-solution-moderne-pour-remplacer-pip-et-virtualenv/) installé sur votre machine.
Une fois pipenv installé, exécutez `pipenv shell`.
Dans le dossier actuel, vous trouverez le fichier `run.sh` qui prend en argument le numéro du jour et qui exécute le fichier Python avec l'entrée associée à ce jour. Il faut l'exécuter dans le shell pipenv.

## Qu'est-ce que le code golf en Python ?

Le code golf est un exercice de programmation qui consiste à écrire le code le plus court possible pour répondre à un énoncé, dans le langage de votre choix (ici le Python, mais d'autres langages sont naturellement plus compacts comme Ruby ou Perl).
Bien sûr, je ne suis pas expert et vous pourrez sûrement écrire des codes plus court, si l'exercice vous intéresse, n'hésitez pas à ajouter vos codes ^^
Il y a quelques règles que je vais imposer cependant (même si elles sont assez classiques en code golf) :
- Le programme ne doit pas tourner indéfiniment
- Le programme a le droit de crash si toutes les réponses ont été affichées dans la console au préalable
- Le programme doit être lisible (il est par exemple possible de compresser un code en utilisant UTF-16 mais le code n'est plus lisible)
- Les entrées sont lues depuis l'entrée standard. Afin de faciliter la lecture, le script `run.sh` donne d'abord le nombre de lignes dans l'entrée, puis les lignes du fichier.

Pour chaque jour, vous trouverez deux fichiers `step1.py` et `step2.py` contenant les codes du jour ainsi qu'un README expliquant le code et les astuces pour en réduire la taille.