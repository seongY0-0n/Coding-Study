n = int(input())

arr=[list(map(int, input().split())) for i in range(n)]

a, b, c = 0, 0, 0

def check(x,y,n):
    global a,b,c
    num = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if num!=arr[i][j]:
                check(x,y,n//3)
                check(x+n//3, y, n//3)
                check(x+2*n//3, y, n//3)
                
                check(x,y+n//3,n//3)
                check(x+n//3, y+n//3, n//3)
                check(x+2*n//3, y+n//3, n//3)
                
                check(x,y+2*n//3,n//3)
                check(x+n//3, y+2*n//3, n//3)
                check(x+2*n//3, y+2*n//3, n//3)
                return
                        
    if num == -1:
        a+=1
    elif num == 0:
        b+=1
    else:
        c+=1

check(0,0,n)
print(a)
print(b)
print(c)