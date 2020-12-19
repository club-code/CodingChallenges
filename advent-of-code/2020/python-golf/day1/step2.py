I=input
n=int(I())
e=[int(I())for _ in"a"*n]
for a,b,c in __import__("itertools").combinations(e,3):
 if a+b+c==2020:I(a*b*c)