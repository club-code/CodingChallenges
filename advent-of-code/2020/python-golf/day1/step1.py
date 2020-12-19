I=input
n=int(I())
e=[int(I())for _ in"a"*n]
for a,b in __import__("itertools").combinations(e,2):
 if a+b==2020:I(a*b)