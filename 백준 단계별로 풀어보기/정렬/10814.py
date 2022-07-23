from ast import Index
from os import remove
import sys
N = int(sys.stdin.readline())

arr = list()
for i in range(N):
    age, name =map(str, sys.stdin.readline().split())
    age = int(age)
    arr1 = [age,name]
    arr.append(arr1)

for i in range(N):
    arr[i].append(i)

arr.sort(key = lambda x:(x[0],x[2]))
for i in range(N):
    arr[i][2]=''

for i in range(N):
    print(*arr[i])
    