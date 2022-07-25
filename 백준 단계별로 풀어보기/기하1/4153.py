while True:
    a,b,c=map(int,input().split())
    if a==0 and b==0 and c==0:
        break
    else:    
        arr=[a,b,c]
        d = max(arr)
        arr.remove(d)
        if d*d == arr[0]*arr[0] + arr[1]*arr[1]:
            print('right')
        else:
            print('wrong')