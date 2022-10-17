a, b, c = map(int,input().split())

def mul(x,y):
    global a,b,c
    
    if y!=b:
        mul(x*a, y+1)
        return
    print(x%c)

mul(1,0)
