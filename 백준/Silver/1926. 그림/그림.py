from collections import deque
n,m = map(int,input().split())
paper = [list(map(int, input().split())) for _ in range(n)]
def bfs(x,y):
    result = 1
    dq = deque()
    dq.append((x,y))
    visited[x][y] = True
    while dq:
        x,y = dq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if paper[nx][ny] == 0 or visited[nx][ny]:
                continue
            dq.append((nx,ny))
            visited[nx][ny] = True
            result += 1
    return result


visited = [[False] * m for _ in range(n)]
count = 0
max_size = 0
dx = [1,0,-1,0]
dy = [0,1,0,-1]

for i in range(n):
    for j in range(m):
        if paper[i][j] == 1 and not visited[i][j]:
            count += 1
            max_size = max(bfs(i, j), max_size)

print(count)
print(max_size)

