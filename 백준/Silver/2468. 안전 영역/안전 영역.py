from collections import deque


def bfs(i, j, limit):
    dq = deque()
    dq.append((i, j))
    visited[i][j] = True
    while dq:
        x, y = dq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if land[nx][ny] <= limit or visited[nx][ny]:
                continue
            dq.append((nx, ny))
            visited[nx][ny] = True


N = int(input())

land = []
max_limit = 0
for _ in range(N):
    land.append(list(map(int, input().split())))
    max_limit = max(max_limit, max(land[-1]))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

answer = 0
for limit in range(max_limit):
    visited = [[False for _ in range(N)] for _ in range(N)]
    result = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and land[i][j] > limit:
                bfs(i, j, limit)
                result += 1
    answer = max(answer,result)
print(answer)