from collections import deque
N, M = map(int, input().split())

arr = list (i for i in range(N+1))


for _ in range(M):
    i, j, k = map(int, input().split())

    arr= arr[:i] + arr[k:j+1] + arr[i:k] + arr[j+1:]

arr.remove(0)

print(*arr)