from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs():
    while dq:
        x, y = dq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if gorangji[nx][ny] == 0:
                continue
            gorangji[nx][ny] = 0
            dq.append((nx, ny))


T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    gorangji = list()
    result = 0
    dq = deque()
    for i in range(N):
        gorangji.append([0] * M)

    for i in range(K):
        x, y = map(int, input().split())
        gorangji[y][x] = 1

    for i in range(N):
        for j in range(M):
            if gorangji[i][j] == 1:
                gorangji[i][j] = 0
                dq.append((i, j))
                bfs()
                result += 1

    print(result)
