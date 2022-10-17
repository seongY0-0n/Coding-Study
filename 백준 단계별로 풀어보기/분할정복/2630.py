n = int(input())

arr = list()
for i in range(n):
    arr.append(list(map(int, input().split())))

b, w = 0, 0

def check(x,y,n):
    global b, w
    color = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j] != color:
                check(x, y, n//2)
                check(x, y+n//2, n//2)
                check(x+n//2, y, n//2)
                check(x+n//2, y+n//2, n//2)
                return
    if color == 1:
        b+=1
    else:
        w+=1

check(0,0,n)
print(w)
print(b)
    