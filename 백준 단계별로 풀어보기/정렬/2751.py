import sys
N = int(sys.stdin.readline())
arr = list()
for i in range(N):
    arr.append(int(sys.stdin.readline()))
arr.sort()

for i in range(N):
    print(arr[i])