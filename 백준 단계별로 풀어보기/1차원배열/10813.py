N, M = map(int, input().split())
arr = list()
for i in range(1, N+1):
    arr.append(i)

for i in range(M):
    i, j = map(int, input().split())
    arr[i-1], arr[j-1] = arr[j-1], arr[i-1]

print(*arr)
