import sys


n, k = map(int, sys.stdin.readline().split())

li = list(map(int, sys.stdin.readline().split()))

arr = [0]
temp = 0
for i in li:
    temp+=i
    arr.append(temp)

result = list()
for i in range(k,n+1):
    result.append(arr[i] - arr[i-k]) 

print(max(result))
    