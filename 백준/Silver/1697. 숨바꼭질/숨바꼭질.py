from collections import deque



N, K = map(int, input().split())

dist = ['.'] * 100001
dist[N] = 0

dq = deque()
dq.append(N)

def bfs():
    while dq:
        x = dq.popleft()
        if x == K:
            return dist[x]
        if x + 1 <= 100000 and dist[x+1] == '.':
            dist[x+1] = dist[x] + 1
            dq.append(x+1)
        if x - 1 >= 0 and dist[x-1] == '.':
            dist[x-1] = dist[x] + 1
            dq.append(x-1)
        if x * 2 <= 100000 and dist[2*x] =='.':
            dist[2*x] = dist[x] + 1
            dq.append(x*2)

print( bfs() )
