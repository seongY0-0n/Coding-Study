n = int(input())

arr1 = list(map(int, input().split()))
arr1.sort()

m = int(input())

arr2 = list(map(int,input().split()))

for i in arr2:
    low = 0 
    high = n-1

    while low <= high:
        mid = (low + high)//2
        if i == arr1[mid]:
            break
        elif i > arr1[mid]:	
            low = mid + 1	
        else:			
            high = mid - 1	
    
    if i == arr1[mid]:
        print(1)
    else:
        print(0)