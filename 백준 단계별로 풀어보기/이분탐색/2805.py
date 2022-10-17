n, m = map(int,input().split())

arr=list(map(int,input().split()))

arr.sort()


low, high = 0, arr[-1]
while low <= high:
    sum = 0
    mid = (low + high)//2
    for i in arr:
        if i - mid > 0:
            sum += (i - mid)
    
    if sum < m:
        high = mid - 1
    else:
        low = mid +1
        
print(high)