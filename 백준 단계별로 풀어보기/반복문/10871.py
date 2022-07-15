import sys

N,X=map(int, sys.stdin.readline().split())
arr=list(map(int, sys.stdin.readline().split()))
result=[]
for i in range(N):
    if arr[i]<X:
        result.append(arr[i])

print(*result)