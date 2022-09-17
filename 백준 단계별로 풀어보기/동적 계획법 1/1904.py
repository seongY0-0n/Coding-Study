import sys
input = sys.stdin.readline
fib_arr = [0] * 1000001
fib_arr[1] = 1
fib_arr[2] = 2

def fib_dp(n):
    for i in range(3,n+1):
        fib_arr[i] = (fib_arr[i-1] + fib_arr[i-2])%15746
        
    
N = int(input())
fib_dp(N)
print(fib_arr[N])
