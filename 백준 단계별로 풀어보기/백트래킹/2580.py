arr = list()
for i in range(9):
    arr.append(list(map(int,input().split())))
    


def check(i,j,k):
    b = [i[0] for i in arr]
    c = [arr[i][j+1],arr[i][j+2],arr[i+1][j],arr[i+2][j],arr[i+1][j+1],arr[i+2][j+2],arr[i+2][j+1],arr[i+1][j+2]]
    if k in b:
        return False
    if k in arr[i]:
        return False
    if k in c:
        return False
    return True
    
    
    
    

def dfs():
    for i in range(9):
        if 0 in arr[i]:
            break
        print(123)
        return
        
    for i in range(7):
        for j in range(7):
            if arr[i][j]==0:
                
                for k in range(9):
                    if check(i,j,k):
                        arr[i][j]=k
                        dfs()
                        

dfs()
print(*arr)
