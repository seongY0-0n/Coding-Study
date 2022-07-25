T = int(input())

for i in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = ((x1-x2)**2 + (y1-y2)**2)**(1/2)
    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
        continue
    
    if r1 + r2 == d or d + min(r1,r2) == max(r1,r2):
        print(1)
    elif max(r1,r2) - min(r1,r2) < d < r1+r2:
        print(2)
    else:
        print(0)
    