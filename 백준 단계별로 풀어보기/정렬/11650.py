import sys
N = int(sys.stdin.readline())
arr = list()
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
    
arr.sort(key = lambda x : (x[0],x[1]))


for i in range(N):
    print(*arr[i])