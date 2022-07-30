N,M = map(int, input().split())

arr = list()

def dfs(d, s):
    if d == M:
        print(*arr)
        return
    
    for i in range(s,N+1):
        if i in arr :
            continue
        s = i
        arr.append(i)
        dfs(d+1, s+1)
        arr.pop()

dfs(0, 1)
        
