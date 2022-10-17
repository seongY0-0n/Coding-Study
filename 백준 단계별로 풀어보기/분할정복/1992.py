n = int(input())

arr=[list(map(str, input().strip())) for i in range(n)]

def check(x,y,n):
    color = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != arr[i][j]:
                print('(', end='')
                check(x, y, n//2)
                check(x, y+n//2, n//2)
                check(x+n//2, y, n//2)
                check(x+n//2, y+n//2, n//2)
                print(')', end='')
                return
    print(color, end='')

check(0,0,n)