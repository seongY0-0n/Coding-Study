N = int(input())
arr = list()
start = list()
link = list()
min = 10000
for i in range(N):
    arr.append(list(map(int,input().split())))
    

def dfs(s):
    global min
    if s == N//2:
        start_sum = 0
        link_sum = 0
        for i in range(N):
            if i not in start:
                link.append(i)
        
        for i in range(N//2):
            for j in range(i+1, N//2):
                start_sum+=arr[start[i]][start[j]]+arr[start[j]][start[i]]
                link_sum+=arr[link[i]][link[j]]+arr[link[j]][link[i]]
                
        if min > abs(start_sum-link_sum):
            min = abs(start_sum-link_sum)
        
        link.clear()
        return
    
    for i in range(N):
        if i in start:
            continue
        if len(start)!=0 and start[len(start)-1] > i:
            continue
        start.append(i)
        dfs(s+1)
        start.pop()
            
    

dfs(0)
print(min)