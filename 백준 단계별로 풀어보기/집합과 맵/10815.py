import sys

N = int(sys.stdin.readline())

arr1 = list(map(int,sys.stdin.readline().split()))

M = int(sys.stdin.readline())

arr2 = list(map(int,sys.stdin.readline().split()))

arr1.sort()

for i in arr2:
    low, high = 0, N
    k = 0
    while low <= high:
        mid = (low + high)//2
        if arr1[mid] == i:
            k = 1
            break
        elif arr1[mid] > i:
            high = mid - 1
        else:
            low = mid + 1
    
    print(k, end=' ')
        
    
