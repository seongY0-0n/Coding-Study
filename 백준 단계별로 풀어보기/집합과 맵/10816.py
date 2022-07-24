import sys
N = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
M = int(sys.stdin.readline())

arr2 = list(map(int, sys.stdin.readline().split()))
d={}
for i in arr:
    if i in d:
        d[i] += 1
    else:
        d[i] = 1

for i in arr2:
    if d.get(i):
        print(d.get(i), end=' ')
    else:
        print(0,end=' ')