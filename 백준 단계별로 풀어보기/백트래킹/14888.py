N = int(input())

arr = list(map(int, input().split()))

a = list(map(int, input().split()))
result = list()

def dfs():
    if sum(a)==0:
        result.append(res)
        return
    
    for i in range(1,N):
        if i == 0 :
            res = arr[0]
        else:
            for j in range(4):
                if a[j] == 0:
                    continue
                if j==0:
                    res += arr[i]
                    a[j]-=1
                    dfs()
                elif j==1:
                    res -= arr[i]
                    a[j] -= 1
                    dfs()
                elif j==2:
                    res = res* arr[i]
                    a[j] -= 1
                    dfs()
                else:
                    res //= arr[i]
                    a[j] -= 1
                    dfs()


dfs()
print(result)
                    
        
    

                
                
                