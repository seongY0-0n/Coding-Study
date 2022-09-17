import sys


dp = [0] * 101
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

T = int(input())

for i in range(T):
    N = int(input())
    if N < 6:
        print(dp[N])
    else:
        for i in range(6,N+1):
            dp[i] = dp[i-1] + dp[i-5]
        print(dp[i])