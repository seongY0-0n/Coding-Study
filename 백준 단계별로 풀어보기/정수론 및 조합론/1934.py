import sys
T = int(input())
for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    result=0 
    for i in range(1,min(A,B)+1):
        if A%i==0 and B%i==0:
            result = i
    print(result*(A//result)*(B//result))