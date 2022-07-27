import math
N = int(input())

arr = list(map(int,input().split()))


for i in range(1,N):
    print(arr[0]//math.gcd(arr[0],arr[i]),arr[i]//math.gcd(arr[0],arr[i]),sep='/')
    
