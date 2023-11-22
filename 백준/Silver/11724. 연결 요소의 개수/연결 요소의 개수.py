from collections import deque
import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def bfs(x):
    dq = deque()
    dq.append(x)
    visited[x] = True
    while dq:
        nx = dq.popleft()
        for j in arr[nx]:
            if visited[j]:
                continue
            dq.append(j)
            visited[j] = True


N, M = map(int, input().split())
arr = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)

for i in range(M):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

result = 0

for i in range(1, N + 1):
    if not visited[i]:
        result += 1
        bfs(i)

print(result)
