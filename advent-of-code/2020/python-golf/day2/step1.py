I=input
n,c=int(I()),0
for _ in"a"*n:
 r,l,p=I().split();a,b=map(int,r.split("-"));c+=p.count(l[0])in range(a,b+1)
I(c)