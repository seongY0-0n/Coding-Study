T = int(input())
for i in range(T):
    x1, y1, x2, y2 = map(int,input().split())
    n = int(input())
    count = 0
    arr = list()
    for i in range(n):
        arr.append(list(map(int,input().split())))
        d1 = ((x1 - arr[i][0])**2 +(y1 - arr[i][1])**2)**(1/2)
        d2 = ((x2 - arr[i][0])**2 +(y2 - arr[i][1])**2)**(1/2)
        if d1 <arr[i][2] and d2 > arr[i][2]:
            count+=1
        elif d1 > arr[i][2] and d2 < arr[i][2]:
            count+=1
        
    print(count)
        