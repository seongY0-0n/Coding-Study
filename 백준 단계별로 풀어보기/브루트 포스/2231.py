N = int(input())

for i in range(1,N+1):
    a = i
    sum = i
    k = i
    while a>0:
        sum = sum + a%10
        a = a//10
    
    if sum == N: 
        print(k)
        break
    
    if i==N:
        print(0)
        


         