import sys
N = int(sys.stdin.readline())
arr = list()

for i in range(N):
    arr.append(sys.stdin.readline().strip())
arr=list(set(arr))
arr.sort()
arr.sort(key = len)

for i in range(len(arr)):
    print(arr[i])