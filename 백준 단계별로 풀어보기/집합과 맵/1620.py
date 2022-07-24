from re import A
import sys

N, M = map(int , sys.stdin.readline().split())
d= {}
for i in range(N):
    a=sys.stdin.readline().strip()
    d[str(i+1)] = a
    d[a] = str(i+1)

arr = list()
for i in range(M):
    arr.append(sys.stdin.readline().strip())

for i in arr:
    print(d[i])

