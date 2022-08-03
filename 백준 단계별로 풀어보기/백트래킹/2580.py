board=list()
count = 0
for i in range(9):
    a = list(map(int,input().split()))
    board.append(a)
    count += a.count(0)

result = board

def check(i,j,data,result):
    if data in result[i]:
        return False
    
    arr1=list()
    for a in range(9):
        arr1.append(result[a][j])
    if data in arr1:
        return False
    arr2=[result[i//3*3][j//3*3],result[i//3*3][j//3*3+1],result[i//3*3][j//3*3+2]
          ,result[i//3*3+1][j//3*3],result[i//3*3+1][j//3*3+1],result[i//3*3+1][j//3*3+2]
          ,result[i//3*3+2][j//3*3],result[i//3*3+2][j//3*3+1],result[i//3*3+2][j//3*3+2]]
    
    if data in arr2:
        return False
    
    return True

def dfs(s):
    if s==count:
        for i in range(9):
            print(*result[i])
        exit(0)
    
    for i in range(9):
        if result[i].count(0) == 0:
            continue
        index = result[i].index(0)
        for j in range(1,10):
            if check(i,index,j,result):
                result[i][index]=j
                dfs(s+1)
                result[i][index]=0
                
                
dfs(0)

