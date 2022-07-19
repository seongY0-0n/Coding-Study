M, N = map(int, input().split())

def prime(num):
    if num == 1:
        return False
    elif num == 2:
        return True
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

for i in range(M,N+1):
    if prime(i): print(i)