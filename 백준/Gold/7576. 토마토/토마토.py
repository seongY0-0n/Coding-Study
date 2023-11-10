from collections import deque

N, M = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(M)]
dq = deque()
dx = [1,0,-1,0]
dy = [0,1,0,-1]


for i in range(M):
    for j in range(N):
        if box[i][j] == 1:
            dq.append((i,j))

def bfs(q):
    temp = 0
    result = 0
    for b in box:
        temp += b.count(0)
    if temp == 0:
        return 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue
            if box[nx][ny] == -1:
                continue
            if box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                q.append((nx,ny))

    for b in box:
        if 0 in b:
            return -1
        result = max(max(b),result)

    return result-1



print(bfs(dq))



