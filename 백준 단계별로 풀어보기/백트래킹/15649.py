N,M = map(int,input().split())

arr = list()

def dfs(d):
    if d == M:
        print(*arr)
        return
    
    for i in range(1,N+1):
        if i in arr:
            continue
        arr.append(i)
        dfs(d+1)
        arr.pop()

dfs(0)