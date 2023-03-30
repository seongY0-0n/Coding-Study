N, M = map(int, input().split())
arr = list(i for i in range(1, N+1))

for i in range(M):
    i, j = map(int, input().split())
    temp = list()
    for m in range(i-1, j):
        temp.append(arr[m])

    for x in range(i-1, j):
        arr[x] = temp.pop()

print(*arr)
