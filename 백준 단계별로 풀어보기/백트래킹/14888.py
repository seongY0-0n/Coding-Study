N = int(input())

data = list(map(int, input().split()))

a, b, c, d = map(int, input().split())
result = list()
def dfs(s,arr):
    global a,b,c,d
    if s == N:
        result.append(arr)
        return
    
    if a>0:
        a-=1
        
        dfs(s+1, arr + data[s])
        a+=1
    if b>0:
        b-=1
        dfs(s+1,arr - data[s])
        b+=1
    if c>0:
        c-=1
        dfs(s+1,arr*data[s])
        c+=1
    if d>0:
        d-=1

        dfs(s+1,int(arr/data[s]))
        d+=1

dfs(1,data[0])
print(max(result))
print(min(result))