I=input
n,c=int(I()),0
for _ in"a"*n:
 r,l,p=I().split();a,b=map(int,r.split("-"));c+=(p[a-1]==l[0])^(p[b-1]==l[0])
I(c)