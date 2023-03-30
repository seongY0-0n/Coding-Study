N, M = map(int, input().split())

arr = [0] * N

for x in range(M):
    i, j, k = map(int, input().split())
    for y in range(i-1, j):
        arr[y] = k

print(*arr)
