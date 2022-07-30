N,M = map(int, input().split())

arr = list()

def dfs(s):
    if len(arr)==M:
        print(*arr)
        return
    
    for i in  range(1,N+1):
        if i < s:
            continue
        arr.append(i)
        s=i
        dfs(s)
        arr.pop()
        s=0

dfs(0)