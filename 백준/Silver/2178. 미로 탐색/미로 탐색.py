from collections import deque
N, M = map(int, input().split())

miro = [list(map(int, input())) for _ in range(N)]
visited = list([False]*M for _ in range(N) )

dx = [1,0,-1,0]
dy = [0,1,0,-1]


def bfs(x,y):
    dq =deque()
    dq.append((x,y))
    visited[x][y] = True
    while dq:
        x, y = dq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if miro[nx][ny] == 0 or visited[nx][ny]:
                continue
            miro[nx][ny] = miro[x][y] + 1
            visited[nx][ny] = True
            dq.append((nx, ny))

bfs(0,0)
print(miro[-1][-1])