M = int(input())
N = int(input())
def prime(num):
    if num == 1:
        return False
    elif num == 2:
        return True
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

sosu = list()
for i in range(M,N+1):
    if prime(i):
        sosu.append(i)
    
if len(sosu) != 0:
    print(sum(sosu))
    print(min(sosu))
else:    
    print(-1)

        
