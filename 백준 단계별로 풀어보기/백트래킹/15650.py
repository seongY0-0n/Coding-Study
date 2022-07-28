N ,M = map(int, input().split())

arr = list()

def dfs(start):
    if len(arr) == M:
        print(*arr)
        return

    for i in range(start, N+1):
        if i not in arr:
            arr.append(i)
            dfs(i+1)
            arr.pop()
        
dfs(1)