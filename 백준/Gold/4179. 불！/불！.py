from collections import deque


def bfs():
    while f_que:
        x, y = f_que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= r or ny < 0 or ny >= c or miro[nx][ny] == '#':
                continue
            if miro[nx][ny] == '.' and fire[nx][ny] == 0:
                f_que.append((nx, ny))
                fire[nx][ny] = fire[x][y] + 1

    while j_que:
        x, y = j_que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= r or ny < 0 or ny >= c:
                return jihoon[x][y]

            if miro[nx][ny] == '#' or jihoon[nx][ny] > 0:
                continue

            if fire[nx][ny] > jihoon[x][y] + 1 or fire[nx][ny] == 0:
                j_que.append((nx, ny))
                jihoon[nx][ny] = jihoon[x][y] + 1

    return 'IMPOSSIBLE'


r, c = map(int, input().split())
miro = [list(input()) for _ in range(r)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

j_que = deque()
f_que = deque()

fire = [[0 for _ in range(c)] for _ in range(r)]
jihoon = [[0 for _ in range(c)] for _ in range(r)]

for i in range(r):
    for j in range(c):
        if miro[i][j] == 'J':
            j_que.append((i, j))
            jihoon[i][j] = 1
        if miro[i][j] == 'F':
            f_que.append((i, j))
            fire[i][j] = 1
print(bfs())