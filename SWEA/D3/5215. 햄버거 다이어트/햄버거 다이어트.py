T = int(input())

result = []
def dfs(index, score, cal):
    global max_score
    if cal > L:
        return
    if score > max_score:
        max_score = score
    if index == N:
        return
    dfs(index + 1, score, cal)
    dfs(index + 1, score + t[index], cal + k[index])



for tc in range(1, T + 1):
    N, L = map(int, input().split())
    t = []
    k = []
    for i in range(N):
        a, b = map(int, input().split())
        t.append(a)
        k.append(b)
    max_score = 0
    dfs(0,0,0)
    print(f'#{tc} {max_score}')
