import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

temp = list(set(arr))
temp.sort()

dic = {temp[i] : i for i in range(len(temp))}

for i in arr:
    print(dic[i], end=' ')