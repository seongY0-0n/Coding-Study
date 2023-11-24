import sys

n = int(sys.stdin.readline())

dp = [[0 for _ in range(2)] for _ in range(n+1)]

podoju = []

for _ in range(n):
    podoju.append(int(input()))

if n == 1:
    print(podoju[0])
    exit()
elif n == 2:
    print(podoju[0] + podoju[1])
    exit()

dp[1][0] = podoju[0]
dp[1][1] = 0
dp[2][0] = podoju[1]
dp[2][1] =podoju[0] + podoju[1]
dp[3][0] = dp[1][0]+podoju[2]
dp[3][1] = max(dp[2][0] + podoju[2] , dp[2][1])

for i in range(4, n+1):
    dp[i][0] = max(dp[i-2]) + podoju[i-1]
    dp[i][1] = max(dp[i-1][0] + podoju[i-1], dp[i-1][1])


print(max(dp[n]))

