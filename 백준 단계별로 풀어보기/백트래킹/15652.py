N, M = map(int,input().split())

arr = list()

def dfs():
    if len(arr)==M:
        print(*arr)
        return
    
    if len(arr)==0:
        for i in range(1,N+1):
            arr.append(i)
            dfs()
            arr.pop()
    else:
                
        for i in range(1,N+1):
            if i >= arr[-1]:
                arr.append(i)
                dfs()
                arr.pop()
            continue

dfs()
        